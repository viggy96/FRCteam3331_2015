package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;
import org.usfirst.frc.team3331.robot.commands.telopDriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    RobotDrive drivetrain = RobotMap.drivetrain;
    Joystick gamepad = RobotMap.gamepad;
    
    public void initDefaultCommand() {
        setDefaultCommand(new telopDriveCommand());
    }
    
    public void init() {
    	drivetrain.tankDrive(0, 0);
    }
    
    public void autoDrive(double leftValue, double rightValue) {
    	drivetrain.tankDrive(leftValue, rightValue);
    }
    
    public void telopDrive() {
    	drivetrain.tankDrive(-gamepad.getRawAxis(2), -gamepad.getRawAxis(5));
    }
}

