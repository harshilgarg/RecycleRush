
package org.usfirst.frc.team2869.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2869.robot.commands.ExampleCommand;
import org.usfirst.frc.team2869.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2869.robot.subsystems.ExampleSubsystem;

import com.kauailabs.navx.mxp.IMUAdvanced;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	/*SerialPort serialPort;
	static IMUAdvanced imu;
	
	boolean initialization;*/

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveTrain chassis = new DriveTrain();
	
	public static OI oi;

    Command autonomousCommand;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
      	/*try {
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
            }*/
    	
		oi = new OI();
        autonomousCommand = new ExampleCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	/*SmartDashboard.putBoolean("IMU_Connected",      imu.isConnected());
        SmartDashboard.putBoolean("IMU_IsCalibrating",  imu.isCalibrating());
        SmartDashboard.putNumber( "IMU_Yaw",            imu.getYaw());
        SmartDashboard.putNumber( "IMU_Pitch",          imu.getPitch());
        SmartDashboard.putNumber( "IMU_Roll",           imu.getRoll());
        SmartDashboard.putNumber( "IMU_CompassHeading", imu.getCompassHeading());
        SmartDashboard.putNumber( "IMU_Update_Count",   imu.getUpdateCount());
        SmartDashboard.putNumber( "IMU_Byte_Count",     imu.getByteCount());
        SmartDashboard.putNumber( "IMU_Accel_X",        imu.getWorldLinearAccelX());
        SmartDashboard.putNumber( "IMU_Accel_Y",        imu.getWorldLinearAccelY());
        SmartDashboard.putBoolean("IMU_IsMoving",       imu.isMoving());
        SmartDashboard.putNumber( "IMU_Temp_C",         imu.getTempC());*/

		if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void disabledInit() {
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
   
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    /*public static IMUAdvanced getIMU() {
    	return imu;
    }*/
}
