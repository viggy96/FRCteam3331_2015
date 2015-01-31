package org.usfirst.frc.team3331.robot.subsystems;

import org.usfirst.frc.team3331.robot.RobotMap;
import org.usfirst.frc.team3331.robot.commands.conveyorCommand;

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
    	RobotMap.conveyorMotor1.set(RobotMap.gamepad.getRawAxis(3));
    	RobotMap.conveyorMotor2.set(RobotMap.gamepad.getRawAxis(3));
    }
}
