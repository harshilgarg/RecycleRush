package org.usfirst.frc.team2869.robot.commands;

import org.usfirst.frc.team2869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author BETHPAGE HIGH SCHOOL, 2015 TEAM #869
 */
public class Robot180 extends Command {
	
	double yaw = Robot.chassis.getIMU().getYaw();
	boolean isFinished = false;

    public Robot180() {
        requires(Robot.chassis);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	SmartDashboard.putNumber("yaw", Robot.chassis.getIMU().getYaw());
    	if (Robot.chassis.getIMU().getYaw() < yaw + 180) {
    		Robot.chassis.mecanumDrive(0, 0, 0.8, 0);
    	}
    	else {
    		isFinished = true;
    		Robot.chassis.mecanumDrive(0, 0, 0, 0);
    	}
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
