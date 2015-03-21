package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;
import org.usfirst.frc.team3331.robot.commands.conveyorCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ConveyorSubsystem extends Subsystem {
    double limiter = 1.0;
    
    public void initDefaultCommand() {
    	setDefaultCommand(new conveyorCommand());
    }
    
    public void init() {
    	RobotMap.conveyorMotor1.set(0);
    	RobotMap.conveyorMotor2.set(0);
    }
    
    public void conveyor() {
    	if (RobotMap.gamepad.getRawAxis(2) != 0) {
    		RobotMap.conveyorMotor1.set(RobotMap.gamepad.getRawAxis(2) * limiter);
    		RobotMap.conveyorMotor2.set(RobotMap.gamepad.getRawAxis(2) * limiter);
    	}
    	if (RobotMap.gamepad.getRawAxis(3) != 0 ) {
    		RobotMap.conveyorMotor1.set(-RobotMap.gamepad.getRawAxis(3) * limiter);
    		RobotMap.conveyorMotor2.set(-RobotMap.gamepad.getRawAxis(3) * limiter);
    	}
    	
    	if (RobotMap.gamepad.getRawAxis(2) == 0 && RobotMap.gamepad.getRawAxis(3) == 0) init();
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
