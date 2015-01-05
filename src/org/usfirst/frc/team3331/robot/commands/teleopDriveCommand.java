package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;
import org.usfirst.frc.team3331.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class teleopDriveCommand extends Command {
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	
    public teleopDriveCommand() {
		requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveSubsystem.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveSubsystem.teleopDrive();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driveSubsystem.init();
    }
}
