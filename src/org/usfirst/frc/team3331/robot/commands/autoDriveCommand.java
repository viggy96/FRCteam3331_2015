package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class autoDriveCommand extends Command {

    public autoDriveCommand() {
        requires(Robot.DriveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.DriveSubsystem.init();
    	setTimeout(3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveSubsystem.autoDrive_Cartesian(0, 1, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveSubsystem.init();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
