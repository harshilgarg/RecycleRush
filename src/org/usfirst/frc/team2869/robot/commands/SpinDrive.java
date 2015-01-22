package org.usfirst.frc.team2869.robot.commands;

import org.usfirst.frc.team2869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinDrive extends Command {

    public SpinDrive() {
        requires(Robot.chassis);
        setInterruptible(false);
    }

    protected void initialize() {
    }

    protected void execute() {
    	  Robot.chassis.mecanumDrive(0, 0, Robot.oi.getRotation(), 0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
