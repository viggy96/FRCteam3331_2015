package org.usfirst.frc.team3331.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	private static final Talon frontLeftMotor = new Talon(0);
	private static final Talon frontRightMotor = new Talon(1);
	private static final Talon rearLeftMotor = new Talon(2);
	private static final Talon rearRightMotor = new Talon(3);
	
	public static final RobotDrive drivetrain = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    
	public static final DoubleSolenoid solenoid1 = new DoubleSolenoid(4, 5);
    public static final DoubleSolenoid solenoid2 = new DoubleSolenoid(6, 7);

    public static final Joystick gamepad = new Joystick(0);
    public static final Joystick joy = new Joystick(1);
    public static final int leftStickX = 0;
    public static final int leftStickY = 1;
    public static final int rightStickX = 4;
    public static final int rightStickY = 5;
    
    public static final TalonSRX conveyorMotor1 = new TalonSRX(4);
    public static final TalonSRX conveyorMotor2 = new TalonSRX(5);
    
    public static final DigitalInput liftSwitch = new DigitalInput(0);
    
    public static final PowerDistributionPanel pdp = new PowerDistributionPanel();
}
