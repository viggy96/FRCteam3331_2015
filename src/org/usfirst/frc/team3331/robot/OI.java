package org.usfirst.frc.team3331.robot;

import org.usfirst.frc.team3331.robot.commands.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    // Button button = new JoystickButton(stick, buttonNumber);
	Button rightButton = new JoystickButton(RobotMap.gamepad, 6),
			leftButton = new JoystickButton(RobotMap.gamepad, 5);
	
	public OI() {
		rightButton.whenPressed(new solenoid1Command());
		leftButton.whenPressed(new solenoid2Command());
	}
    // button.whenPressed(new ExampleCommand());
    // button.whileHeld(new ExampleCommand());
    // button.whenReleased(new ExampleCommand());
}

