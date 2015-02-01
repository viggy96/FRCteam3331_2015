package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticSubsystem extends Subsystem {
    boolean state = false;
    
    public void initDefaultCommand() {
    	
    }
    
    public void init() {
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kOff);
    	RobotMap.solenoid2.set(DoubleSolenoid.Value.kOff);
    	state = false;
    }
    
    public void solenoidForward() {
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kForward);
    	RobotMap.solenoid2.set(DoubleSolenoid.Value.kForward);
    	state = true;

    }
    
    public void solenoidReverse() {
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kReverse);
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kReverse);
    	state = true;
    }
    
    public void reset() {
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kReverse);
    	RobotMap.solenoid2.set(DoubleSolenoid.Value.kReverse);
    }
    
    public boolean getState(){
    	return state;
    }
}
