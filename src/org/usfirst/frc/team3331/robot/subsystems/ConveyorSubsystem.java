package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;
import org.usfirst.frc.team3331.robot.commands.conveyorCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ConveyorSubsystem extends Subsystem {
    
    public void initDefaultCommand() {
    	setDefaultCommand(new conveyorCommand());
    }
    
    public void init() {
    	RobotMap.conveyorMotor1.set(0);
    	RobotMap.conveyorMotor2.set(0);
    }
    
    public void conveyor() {
    	if (RobotMap.gamepad.getRawAxis(2) != 0) {
    			RobotMap.conveyorMotor1.set(RobotMap.gamepad.getRawAxis(2));
    			RobotMap.conveyorMotor2.set(RobotMap.gamepad.getRawAxis(2));
    	}
    	
    	if (RobotMap.gamepad.getRawAxis(3) != 0) {
    		RobotMap.conveyorMotor1.set(-RobotMap.gamepad.getRawAxis(3));
    		RobotMap.conveyorMotor2.set(-RobotMap.gamepad.getRawAxis(3));
    	}
    	
    	if (RobotMap.liftSwitch.get()) {
    		RobotMap.gamepad.setRumble(Joystick.RumbleType.kLeftRumble, 1);
    		RobotMap.gamepad.setRumble(Joystick.RumbleType.kRightRumble, 1);
    	}
    }
    
    public void autoConveyorUp(int stage) {
	    if (stage == 1) {
    		RobotMap.conveyorMotor1.set(1);
	    	RobotMap.conveyorMotor2.set(1);
	    }
	    else if (stage == 2) {
	    	RobotMap.conveyorMotor1.set(0.5);
	    	RobotMap.conveyorMotor2.set(0.5);
	    }
    }
    
    public void autoConveyorDown() {
    	RobotMap.conveyorMotor1.set(-1);
    	RobotMap.conveyorMotor2.set(-1);
    }
    
    public boolean getLiftState() {
    	return RobotMap.liftSwitch.get();
    }
}
