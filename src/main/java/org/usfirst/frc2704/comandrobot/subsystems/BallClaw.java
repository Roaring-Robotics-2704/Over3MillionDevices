package org.usfirst.frc2704.comandrobot.subsystems;

import org.usfirst.frc2704.comandrobot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2704.comandrobot.Robot;

public class BallClaw extends Subsystem {

    private PWMTalonSRX grab;
    private PWMTalonSRX lift;

    public BallClaw() {
        grab = new PWMTalonSRX(1);
        addChild("grab", grab);
        grab.setInverted(false);
        lift = new PWMTalonSRX(3);
        addChild("lift", lift);
        lift.setInverted(false);
    }

    public void grab() {
        grab.set(Robot.oi.joystick2.getX());
    }
    public void stopGrab() {
        grab.set(0);
    }

    public void lift() {
        lift.set(Robot.oi.joystick2.getY());
    }

    public void stopLift() {
        lift.set(0);
    }

    @Override
    public void initDefaultCommand() {
      //Set the default command for a subsystem here.
      //setDefaultCommand(new MySpecialCommand());
    }
}