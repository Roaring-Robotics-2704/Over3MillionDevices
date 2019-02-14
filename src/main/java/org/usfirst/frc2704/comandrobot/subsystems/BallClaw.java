package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BallClaw extends Subsystem {

    private WPI_TalonSRX grabMotor;
    private WPI_TalonSRX tiltMotor;

    public BallClaw() {
        grabMotor = new WPI_TalonSRX(3);
        addChild("grabMotor", grabMotor);
        grabMotor.setInverted(false);
        tiltMotor = new WPI_TalonSRX(4);
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

    public void stopTilt() {
        tiltMotor.set(0);
    }

    @Override
    public void initDefaultCommand() {
      //Set the default command for a subsystem here.
      //setDefaultCommand(new MySpecialCommand());
    }
}