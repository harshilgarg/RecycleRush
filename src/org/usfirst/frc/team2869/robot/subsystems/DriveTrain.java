package org.usfirst.frc.team2869.robot.subsystems;

import org.usfirst.frc.team2869.robot.PowerControlTalon;
import org.usfirst.frc.team2869.robot.RobotMap;
import org.usfirst.frc.team2869.robot.commands.MecanumDrive;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	SerialPort serialPort;
	IMUAdvanced imu;
	
	boolean initialization;

	
	RobotDrive drive;
	PowerControlTalon frontLeft, frontRight, rearLeft, rearRight;
	
	public DriveTrain() {
		frontLeft = new PowerControlTalon(RobotMap.FRONTLEFT);
		frontRight = new PowerControlTalon(RobotMap.FRONTRIGHT);
		rearLeft = new PowerControlTalon(RobotMap.REARLEFT);
		rearRight = new PowerControlTalon(RobotMap.REARRIGHT);
		
		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
		
		try {
    	serialPort = new SerialPort(57600, SerialPort.Port.kMXP);
		imu = new IMUAdvanced(serialPort, (byte) 50);
    	} catch( Exception ex ) {
    		
    	}
        if ( imu != null ) {
            LiveWindow.addSensor("IMU", "Gyro", imu);
        }
        initialization = true;
        
        if (initialization && !imu.isCalibrating()) {
            Timer.delay(0.3);
            imu.zeroYaw();
            initialization = false;
        }
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
    
    public IMUAdvanced getIMU() {
    	return imu;
    }
}

