package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;
import org.usfirst.frc.team3331.robot.commands.teleopDriveCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
    
    public void initDefaultCommand() {
        setDefaultCommand(new teleopDriveCommand());
    }
    
    public void init() {
    	RobotMap.drivetrain.tankDrive(0, 0);
    }
    
    public void autoDrive_Cartesian(double x, double y, double rotation) {
    	RobotMap.drivetrain.mecanumDrive_Cartesian(x, y, rotation, 0);
    }
    
    public void autoDrive_Polar(double magnitude, double direction, double rotation) {
    	RobotMap.drivetrain.mecanumDrive_Polar(magnitude, direction, rotation);
    }
    
    public void teleopDrive() {
    	double axes[] = normaliseAxes();
    	RobotMap.drivetrain.mecanumDrive_Cartesian(axes[0], axes[1], axes[2], 0);
    	// X, Y, rotation, gyroAngle
    }
    
    private double[] normaliseAxes() {
    	double axes[] = new double[3];
    	
    	double x = RobotMap.gamepad.getRawAxis(RobotMap.leftStickX), y = RobotMap.gamepad.getRawAxis(RobotMap.leftStickY);
    	double rotation = RobotMap.gamepad.getRawAxis(RobotMap.rightStickX);
    	
    	axes[0] = Math.copySign(Math.pow(x, 2), x);
    	axes[1] = Math.copySign(Math.pow(y, 2), y);
    	axes[2] = Math.copySign(Math.pow(rotation,  2),  rotation); 
    	
    	return axes;
    }
    
}

