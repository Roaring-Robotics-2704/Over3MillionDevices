package org.usfirst.frc2704.comandrobot.subsystems;

import org.usfirst.frc2704.comandrobot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2704.comandrobot.Robot;

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

    public void grab() {
        grabMotor.set(Robot.oi.joystick2.getZ());
    }
    public void stopGrab() {
        grabMotor.set(0);
    }

    public void tilt() {
        tiltMotor.set(Robot.oi.joystick2.getY());
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