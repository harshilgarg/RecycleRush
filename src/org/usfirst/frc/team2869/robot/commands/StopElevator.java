package org.usfirst.frc.team2869.robot.commands;

import org.usfirst.frc.team2869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopElevator extends Command {

    public StopElevator() {
        requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.stop();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
