package org.usfirst.frc.team3331.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	private static final Jaguar frontLeftMotor = new Jaguar(0);
	private static final Jaguar frontRightMotor = new Jaguar(1);
	private static final Jaguar rearLeftMotor = new Jaguar(2);
	private static final Jaguar rearRightMotor = new Jaguar(3);
	
	public static final RobotDrive drivetrain = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    
	public static final DoubleSolenoid solenoid1 = new DoubleSolenoid (1, 2);
    public static final DoubleSolenoid solenoid2 = new DoubleSolenoid (3, 4);

    public static final Joystick gamepad = new Joystick(1);
    public static final int leftStickX = 0;
    public static final int leftStickY = 1;
    public static final int rightStickX = 2;
    public static final int rightStickY = 3;
}
