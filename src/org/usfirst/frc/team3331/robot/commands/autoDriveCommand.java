package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;
import org.usfirst.frc.team3331.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoDriveCommand extends Command {
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	
    public autoDriveCommand() {
        requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveSubsystem.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveSubsystem.autoDrive(1, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.init();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
