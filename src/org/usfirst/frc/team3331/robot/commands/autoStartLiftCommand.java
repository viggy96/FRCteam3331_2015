package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoStartLiftCommand extends Command {

    public autoStartLiftCommand() {
        requires(Robot.ConveyorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.ConveyorSubsystem.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ConveyorSubsystem.autoConveyorUp(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.ConveyorSubsystem.getLiftState();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.ConveyorSubsystem.init();
    }
}
