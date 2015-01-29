package org.usfirst.frc.team3331.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Joystick controller;
	Joystick exio;
	DigitalInput limitSwitch;
	Compressor compressor;
	Talon talon;
	Relay spike;
	DoubleSolenoid solenoid;
	Jaguar jag;
	Servo pan;
	Servo tilt;
	BuiltInAccelerometer accel;
	JoystickButton spikeForward;
	JoystickButton spikeReverse;
	PowerDistributionPanel pdp;
	
	int autoLoopCounter;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	SensorBase.setDefaultSolenoidModule(1);
    	controller = new Joystick(0);
    	exio = new Joystick(1);
    	limitSwitch = new DigitalInput(0);
    	compressor = new Compressor(1);
    	talon = new Talon(0);
    	spike = new Relay(0);
    	solenoid = new DoubleSolenoid(0, 1);
    	jag = new Jaguar(3);
    	pan = new Servo(1);
    	tilt = new Servo(2);
    	pdp = new PowerDistributionPanel();
    	spikeForward = new JoystickButton(controller, 1);
    	spikeReverse = new JoystickButton(controller, 2);
    	accel = new BuiltInAccelerometer();
    	
    	LiveWindow.addSensor("Sensor", "Accelerometer", accel);
    	LiveWindow.addSensor("Sensor", "Limit Switch", limitSwitch);
    	LiveWindow.addSensor("Power", "PDP", pdp);
    	LiveWindow.addSensor("PCM", "Compressor", compressor);
    	LiveWindow.addActuator("Speed Controllers", "Jaguar", jag);
    	LiveWindow.addActuator("Speed Controllers", "Talon", talon);
    	LiveWindow.addActuator("Other Actuators", "Spike", spike);
    	LiveWindow.addActuator("Other Actuators", "Solenoid", solenoid);
    	LiveWindow.setEnabled(true);
    	
    	solenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	LiveWindow.setEnabled(false);
    	//jag.setCurrentMode(1, 0.01, 0.1);
    	//jag.enableControl();
    	autoLoopCounter = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	jag.set(0.5);
		autoLoopCounter++;
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	exio.setOutput(1, true);
    	LiveWindow.setEnabled(true);
    	pdp.startLiveWindowMode();
    	//jag.setVoltageMode();
    	//jag.enableControl();
    	//jag.setVoltageRampRate(1.0);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	if (exio.getRawButton(2)) {
    		jag.set(0);
    	} else if (exio.getRawButton(3)) {
	    	if (limitSwitch.get()) {
	    		double val = controller.getRawAxis(0);
	    		jag.set(Math.pow(val, 2) * Math.signum(val));
	    	} else {
	    		double val = controller.getRawAxis(0);
	    		jag.set(-1.0 * Math.pow(val, 2) * Math.signum(val));
	    	}
    	}
    	if (exio.getRawButton(4)) {
    		talon.set(exio.getRawAxis(2));
    	} else {
    		talon.set(0);
    	}
    	if(spikeForward.get()) {
    		spike.set(Relay.Value.kForward);
    	} else if (spikeReverse.get()){
       		spike.set(Relay.Value.kReverse);
    	} else {
    		spike.set(Relay.Value.kOff);
    	}
    	if(controller.getRawButton(5)) {
    		exio.setOutput(2, true);
    	} else {
    		exio.setOutput(2, false);
    	}
    	if (controller.getRawButton(3)) {
    		solenoid.set(DoubleSolenoid.Value.kForward);
    	} else if (controller.getRawButton(4)) {
    		solenoid.set(DoubleSolenoid.Value.kReverse);
    	}
    	pan.set((controller.getRawAxis(2) + 1.0) / 2.0);
    	tilt.set((controller.getRawAxis(3) + 1.0) / 2.0);
    	System.out.println("3: " + pdp.getCurrent(3) + ", 4: " + pdp.getCurrent(4) + ", 12: " + pdp.getCurrent(12) + ", Total: " + pdp.getTotalCurrent());
    	LiveWindow.run();
    }

    /**
     * This function is called once each time the robot enters test mode
     */
    public void testInit() {
    	//jag.setVoltageMode();
    	//jag.enableControl();
    	LiveWindow.setEnabled(true);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }

    /**
     * This function is called once each time the robot is disabled
     */
    public void disabledInit() {
    	//jag.disableControl();
    	jag.set(0);
    	talon.set(0);

    	exio.setOutput(1, false);
    }
    
    /**
     * This function is called periodically while disabled
     */
    public void disabledPeriodic() {
    }
    
}
