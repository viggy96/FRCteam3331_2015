package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class teleopDriveCommand extends Command {
	
    public teleopDriveCommand() {
		requires(Robot.DriveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.DriveSubsystem.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveSubsystem.teleopDrive();
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
    	Robot.DriveSubsystem.init();
    }
}
