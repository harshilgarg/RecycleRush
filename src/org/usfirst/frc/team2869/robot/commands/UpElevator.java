package org.usfirst.frc.team2869.robot.commands;

import org.usfirst.frc.team2869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpElevator extends Command {

    public UpElevator() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.elevator.up();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
