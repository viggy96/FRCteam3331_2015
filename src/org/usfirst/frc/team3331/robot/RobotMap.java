package org.usfirst.frc.team3331.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int autoDriveTime = 5;
    
	public static RobotDrive drivetrain = new RobotDrive(1, 2, 3, 4);
    
    public static Joystick gamepad = new Joystick(1);
    public static int leftStickX = 1;
    public static int leftStickY = 2;
    public static int rightStickX = 4;
    public static int rightStickY = 5;
}
