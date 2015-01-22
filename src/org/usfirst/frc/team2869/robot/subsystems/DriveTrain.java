package org.usfirst.frc.team2869.robot.subsystems;

import org.usfirst.frc.team2869.robot.PowerControlTalon;
import org.usfirst.frc.team2869.robot.RobotMap;
import org.usfirst.frc.team2869.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	RobotDrive drive;
	PowerControlTalon frontLeft, frontRight, rearLeft, rearRight;
	
	public DriveTrain() {
		frontLeft = new PowerControlTalon(RobotMap.FRONTLEFT);
		frontRight = new PowerControlTalon(RobotMap.FRONTRIGHT);
		rearLeft = new PowerControlTalon(RobotMap.REARLEFT);
		rearRight = new PowerControlTalon(RobotMap.REARRIGHT);
		
		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	}
  
    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
    }
    
    public void mecanumDrive(double x, double y, double rotation, double gyroAngle) {
        drive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
    }
    
    public void setOrientationFrontLeft(boolean motorDirection) {
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, motorDirection);
    }
    
    public void setOrientationFrontRight(boolean motorDirection) {
    	drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, motorDirection);
    }
    
    public void setOrientationRearLeft(boolean motorDirection) {
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, motorDirection);
    }
    
    public void setOrientationRearRight(boolean motorDirection) {
    	drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, motorDirection);
    }
    
    public PowerControlTalon getFrontLeft() {
    	return frontLeft;
    }
    
    public PowerControlTalon getFrontRight() {
    	return frontRight;
    }
    
    public PowerControlTalon getRearLeft() {
    	return rearLeft;
    }
    
    public PowerControlTalon getRearRight() {
    	return rearRight;
    }
}

