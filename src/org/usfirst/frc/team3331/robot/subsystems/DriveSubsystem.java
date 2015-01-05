package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;
import org.usfirst.frc.team3331.robot.commands.teleopDriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    public void initDefaultCommand() {
        setDefaultCommand(new teleopDriveCommand());
    }
    
    public void init() {
    	RobotMap.drivetrain.tankDrive(0, 0);
    }
    
    public void autoDrive(double leftValue, double rightValue) {
    	RobotMap.drivetrain.tankDrive(leftValue, rightValue);
    }
    
    public void teleopDrive() {
    	RobotMap.drivetrain.tankDrive(-RobotMap.gamepad.getRawAxis(2), -RobotMap.gamepad.getRawAxis(5));
    }
}

