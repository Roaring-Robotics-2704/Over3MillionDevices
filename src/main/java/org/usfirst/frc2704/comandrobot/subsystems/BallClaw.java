package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BallClaw extends Subsystem {

    private WPI_TalonSRX leftGrabMotor;
    private WPI_TalonSRX rightGrabMotor;
    private WPI_TalonSRX tiltMotor;

    public BallClaw() {
        leftGrabMotor = new WPI_TalonSRX(4);
        addChild("leftGrabMotor", leftGrabMotor);
        leftGrabMotor.setInverted(false);

        rightGrabMotor = new WPI_TalonSRX(3);
        addChild("rightGrabMotor", rightGrabMotor);
        rightGrabMotor.follow(leftGrabMotor);
        rightGrabMotor.setInverted(InvertType.OpposeMaster);

        tiltMotor = new WPI_TalonSRX(21);
        addChild("tiltMotor", tiltMotor);
        tiltMotor.setInverted(false);
    }
    
    public void setGrab(double in) {
        leftGrabMotor.set(in);
    }

    public void stopGrab() {
        leftGrabMotor.set(0);
    }

    public void setTilt(double in) {
        tiltMotor.set(in);
    }

    public void stopTilt() {
        tiltMotor.set(0);
    }

    @Override
    public void initDefaultCommand() {
      //Set the default command for a subsystem here.
      //setDefaultCommand(new MySpecialCommand());
    }
}