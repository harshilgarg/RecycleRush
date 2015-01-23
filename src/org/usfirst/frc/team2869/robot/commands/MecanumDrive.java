package org.usfirst.frc.team2869.robot.commands;

import org.usfirst.frc.team2869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Default Command that constantly runs on the driveTrain subsystem until another
 * Command replaces it. Allows for regular mecanum drive functionality.
 * 
 * @author BETHPAGE HIGH SCHOOL, 2015 TEAM #869
 */
public class MecanumDrive extends Command {

    public MecanumDrive() {
        requires(Robot.chassis);
    }

    protected void initialize() {
    	Robot.chassis.setOrientationFrontLeft(false);
        Robot.chassis.setOrientationFrontRight(true);
        Robot.chassis.setOrientationRearLeft(false);
        Robot.chassis.setOrientationRearRight(true);
    }

    protected void execute() {
    	 double cartesianX = Robot.oi.getX(),
                cartesianY = Robot.oi.getY(),
                rotation = Robot.oi.getRotation();
          
    	 double x, y, r;
          
          if (Math.abs(cartesianX) < 0.1) {
              x = 0;
          } else {
              x = cartesianX;
          }
          
          if (Math.abs(cartesianY) < 0.1) {
              y = 0;
          } else {
              y = cartesianY;
          }
          
          if (Math.abs(rotation) < 0.1) {
              r = 0;
          } else {
              r = rotation;
          }
          
          SmartDashboard.putNumber("X", -x);
          SmartDashboard.putNumber("Y", -y);
          SmartDashboard.putNumber("R", -r);
          
          SmartDashboard.putNumber("FrontLeft", Robot.chassis.getFrontLeft().get());
          SmartDashboard.putNumber("FrontRight", Robot.chassis.getFrontRight().get());
          SmartDashboard.putNumber("RearLeft", Robot.chassis.getRearLeft().get());
          SmartDashboard.putNumber("RearRight", Robot.chassis.getRearRight().get());
          
          Robot.chassis.mecanumDrive(-x, -y, r, 0);
          
    }	

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
