package org.usfirst.frc.team2869.robot.commands;

import org.usfirst.frc.team2869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author BETHPAGE HIGH SCHOOL, 2015 TEAM #869
 */
public class Robot180 extends Command {
	
	double yaw = Robot.getIMU().getYaw();
	boolean isFinished = true;

    public Robot180() {
        requires(Robot.chassis);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if (Robot.getIMU().getYaw() < yaw + 180) {
    		Robot.chassis.mecanumDrive(0, 0, 1, 0);
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
