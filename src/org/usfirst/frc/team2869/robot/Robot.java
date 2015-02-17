package org.usfirst.frc.team2869.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2869.robot.commands.ExampleCommand;
import org.usfirst.frc.team2869.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2869.robot.subsystems.Elevator;
import org.usfirst.frc.team2869.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveTrain chassis = new DriveTrain();
	public static final Elevator elevator = new Elevator();
	
	public static OI oi;

    Command autonomousCommand;
   
    public void robotInit() {
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
}
