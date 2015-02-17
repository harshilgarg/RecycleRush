package org.usfirst.frc.team2869.robot.subsystems;

import org.usfirst.frc.team2869.robot.RobotMap;
import org.usfirst.frc.team2869.robot.commands.StopElevator;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	
	double elevatorSpeed = 0.1;
	
	Victor left;
	Victor right;
	
	public Elevator () {
		left = new Victor(RobotMap.VICTOR_LEFT);
		right = new Victor(RobotMap.VICTOR_RIGHT);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new StopElevator());
    }
    
    public void stop() {
    	left.set(0);
    	right.set(0);
    }
    
    public void up() {
    	left.set(elevatorSpeed);
    	right.set(elevatorSpeed);
    }
    
    public void down() {
    	left.set(-elevatorSpeed);
    	right.set(-elevatorSpeed);
    }
}

