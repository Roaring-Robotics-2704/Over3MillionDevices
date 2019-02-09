/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2704.comandrobot.subsystems;
import org.usfirst.frc2704.comandrobot.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Timer;

/**
 * Add your docs here.
 */
public class HatchHook extends Subsystem {

  private DoubleSolenoid solenoid1;
  private DoubleSolenoid solenoid2;
  private Compressor compressor;
  private Timer solenoidTimer;

  public HatchHook() {
    compressor = new Compressor(0);
    addChild("compressor", compressor);
    solenoid1 = new DoubleSolenoid(1, 2);
    addChild("solenoid", solenoid1);
    solenoid2 = new DoubleSolenoid(3, 4);
    addChild("solenoid2", solenoid2);
  }

  public void turnOn() {
    compressor.setClosedLoopControl(true);
  }

  public void turnOff() {
    compressor.setClosedLoopControl(false);
  }

  public void extend() {
    solenoid1.set(DoubleSolenoid.Value.kForward);
    solenoid2.set(DoubleSolenoid.Value.kForward);
    solenoidTimer.reset();
    solenoidTimer.start();
    while (solenoidTimer.get() != 0.25) {}
    solenoidTimer.stop();
    solenoid1.set(DoubleSolenoid.Value.kOff);
    solenoid2.set(DoubleSolenoid.Value.kOff);
  }

  public void retract() {
    solenoid1.set(DoubleSolenoid.Value.kReverse);
    solenoid2.set(DoubleSolenoid.Value.kReverse);
    solenoidTimer.reset();
    solenoidTimer.start();
    while (solenoidTimer.get() != 0.25) {}
    solenoidTimer.stop();
    solenoid1.set(DoubleSolenoid.Value.kOff);
    solenoid2.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
