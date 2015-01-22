package org.usfirst.frc.team2869.robot.commands;

import org.usfirst.frc.team2869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HalfDrive extends Command {

    public HalfDrive() {
        requires(Robot.chassis);
        setInterruptible(false);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double x = Robot.oi.getX(),
               y = Robot.oi.getY(),
               r = Robot.oi.getRotation();
         Robot.chassis.mecanumDrive(x/2, -y/2, r/2, 0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
