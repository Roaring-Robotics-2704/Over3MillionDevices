package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;

public class BallClaw extends Subsystem {

    private PWMTalonSRX grabMotor;
    private PWMTalonSRX tiltMotor;

    public BallClaw() {
        grabMotor = new PWMTalonSRX(1);
        addChild("grabMotor", grabMotor);
        grabMotor.setInverted(false);
        tiltMotor = new PWMTalonSRX(3);
        addChild("tiltMotor", tiltMotor);
        tiltMotor.setInverted(false);
    }

    public void setGrab(double in) {
        grabMotor.set(in);
    }

    public void stopGrab() {
        grabMotor.set(0);
    }

    public void setTilt(double in) {
        tiltMotor.set(in);
    }

    public void stoptilt() {
        tiltMotor.set(0);
    }

    @Override
    public void initDefaultCommand() {
      //Set the default command for a subsystem here.
      //setDefaultCommand(new MySpecialCommand());
    }
}