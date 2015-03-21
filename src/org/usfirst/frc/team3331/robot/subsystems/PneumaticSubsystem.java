package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticSubsystem extends Subsystem {
    boolean state = false;
    boolean leftState = false, rightState = false;
    
    public void initDefaultCommand() {
    	
    }
    
    public void init() {
    	state = false;
    }
    
    public void solenoidForward() {
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kForward);
    	RobotMap.solenoid2.set(DoubleSolenoid.Value.kForward);
    	state = true;

    }
    
    public void solenoidReverse() {
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kReverse);
    	RobotMap.solenoid2.set(DoubleSolenoid.Value.kReverse);
    	state = true;
    }
    
    public void reset() {
    	RobotMap.solenoid1.set(DoubleSolenoid.Value.kForward);
    	RobotMap.solenoid2.set(DoubleSolenoid.Value.kForward);
    }
    
    public void solenoid1() {
    	if (leftState) {
    		RobotMap.solenoid1.set(DoubleSolenoid.Value.kForward);
    		leftState = false;
    	}
    	else {
    		RobotMap.solenoid1.set(DoubleSolenoid.Value.kReverse);
    		leftState = true;
    	}
    	state = true;
    }
    
    public void solenoid2() {
    	if (rightState) {
    		RobotMap.solenoid2.set(DoubleSolenoid.Value.kForward);
    		rightState = false;
    	}
    	else {
    		RobotMap.solenoid2.set(DoubleSolenoid.Value.kReverse);
    		rightState = true;
    	}
    	state = true;
    }
    
    public boolean getState(){
    	return state;
    }
}
