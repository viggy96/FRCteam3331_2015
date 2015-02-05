package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class conveyorCommand extends Command {
	int direction = 0;
	
    public conveyorCommand() {
    	requires(Robot.ConveyorSubsystem);
    	this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.ConveyorSubsystem.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ConveyorSubsystem.conveyor();
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
    }
}
