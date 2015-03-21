package org.usfirst.frc.team3331.robot.commands;

import org.usfirst.frc.team3331.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class solenoid1Command extends Command {

    public solenoid1Command() {
        requires(Robot.PneumaticSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.PneumaticSubsystem.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.PneumaticSubsystem.solenoid1();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.PneumaticSubsystem.getState();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.PneumaticSubsystem.init();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
