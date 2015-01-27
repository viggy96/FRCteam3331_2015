package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticSubsystem extends Subsystem {
    boolean state = false;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    public void init(){
    	state = false;
    }
    
    public void solenoidForward(){
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kForward);
    	RobotMap.solenoid2.set(DoubleSolenoid.Value.kForward);
    	state = true;

    }
    public void solenoidReverse(){
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kReverse);
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kReverse);
    	state = true;
    }
    public boolean getState(){
    	return state;
    }
}
