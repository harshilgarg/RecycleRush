package org.usfirst.frc.team2869.robot.commands;

import org.usfirst.frc.team2869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author BETHPAGE HIGH SCHOOL, 2015 TEAM #869
 */
public class Robot180 extends Command {
	
	boolean isFinished = false;
	
	double yaw = Robot.chassis.getModifiedYaw();
	double target;

    public Robot180() {
        requires(Robot.chassis);
    }

    protected void initialize() {
    	target = yaw + 180;
    	target = target % 360;
    }

    protected void execute() {
    	SmartDashboard.putNumber("yaw", Robot.chassis.getModifiedYaw());
    	double low = target - 5;
    	double high = target + 5;
    	double currentYaw = Robot.chassis.getModifiedYaw();
    	
    	if (currentYaw > low && currentYaw < high) {
    		isFinished = true;
    		Robot.chassis.mecanumDrive(0, 0, 0, 0);
    	}
    	else {
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
