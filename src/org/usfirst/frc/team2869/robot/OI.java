package org.usfirst.frc.team2869.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2869.robot.commands.DownElevator;
import org.usfirst.frc.team2869.robot.commands.HalfDrive;
import org.usfirst.frc.team2869.robot.commands.Robot180;
import org.usfirst.frc.team2869.robot.commands.SpinDrive;
import org.usfirst.frc.team2869.robot.commands.StopDrive;
import org.usfirst.frc.team2869.robot.commands.StopElevator;
import org.usfirst.frc.team2869.robot.commands.UpElevator;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    Joystick driveStick = new Joystick(RobotMap.DRIVESTICK);
    Joystick fireStick = new Joystick(RobotMap.FIRESTICK);
    
    Button rotateButton = new JoystickButton(driveStick, RobotMap.ROTATEBUTTON);
    Button stopButton = new JoystickButton(driveStick, RobotMap.STOPBUTTON);
    Button halfButton = new JoystickButton(driveStick, RobotMap.HALFBUTTON);
    Button turn180Button = new JoystickButton(driveStick, RobotMap.TURN180BUTTON);
    
    Button upElevator = new JoystickButton(fireStick, RobotMap.UPELEVATORBUTTON);
    Button downElevator = new JoystickButton(fireStick, RobotMap.DOWNELEVATORBUTTON);
    Button stopElevator = new JoystickButton(fireStick, RobotMap.STOPELEVATORBUTTON);
    
    public OI() {
    	rotateButton.whileHeld(new SpinDrive());
    	stopButton.toggleWhenPressed(new StopDrive());
    	halfButton.toggleWhenPressed(new HalfDrive());
    	turn180Button.whenPressed(new Robot180());
    	
    	upElevator.whileHeld(new UpElevator());
    	downElevator.whileHeld(new DownElevator());
    	stopElevator.whenPressed(new StopElevator());
    }
    
    public double getX() {
    	return driveStick.getX();
    }
    
    public double getY() {
    	return driveStick.getY();
    }
    
    public double getRotation() {
    	return fireStick.getX();
    }
    
}

