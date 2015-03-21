package org.usfirst.frc.team3331.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class autoCommandGroup extends CommandGroup {
    
    public  autoCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	/*
    	addSequential(new autoDriveCommand());
    	addSequential(new autoStartLiftCommand());
    	addSequential(new autoStafeLeftCommand());
    	addSequential(new autoRotateRightCommand());
    	addSequential(new autoDriveCommand());
    	addSequential(new autoLowerLiftCommand());
    	addSequential(new autoDriveBackwardsCommand());
    	*/
  	
    	/*
    	addSequential(new autoStartLiftCommand());
    	addSequential(new autoStafeLeftCommand());
    	
    	addSequential(new autoDriveBackwardsCommand());
    	addSequential(new autoDriveCommand());
    	*/
    	
    	addSequential(new autoDriveCommand());
    	addSequential(new autoConveyorCommand());
    	
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    }
}
