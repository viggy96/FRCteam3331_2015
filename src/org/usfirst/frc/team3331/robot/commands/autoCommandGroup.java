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
   	
//    	addSequential(new autoDriveCommand());
//    	addSequential(new auto());
//    	addSequential(new autoFinishLiftCommand());
//    	addSequential(new autoLowerLiftCommand());
//  	
//    	
//    	addSequential(new autoStartLiftCommand());
//    	addSequential(new autoStafeLeftCommand());
    	
    	addSequential(new autoDriveBackwardsCommand());
    	addSequential(new autoDriveCommand());
    	 
    	
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    }
}
