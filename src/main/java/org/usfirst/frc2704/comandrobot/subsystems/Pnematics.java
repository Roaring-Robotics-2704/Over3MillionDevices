/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2704.comandrobot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Timer;

/**
 * Add your docs here.
 */
public class Pnematics extends Subsystem {

  private DoubleSolenoid boxSolenoid;
  private DoubleSolenoid frontSolenoid;
  private DoubleSolenoid backSolenoid;
  //private Compressor compressor;
  private Timer solenoidTimer;
  private Boolean timerOn;

  public Pnematics() {
    /*
    compressor = new Compressor(0);           
    addChild("compressor", compressor);
    //turnOn();*/
    
  
    boxSolenoid = new DoubleSolenoid(2, 3);
    addChild("solenoid", boxSolenoid);
    
    frontSolenoid = new DoubleSolenoid(4, 5);
    addChild("solenoid", frontSolenoid);
    
    backSolenoid = new DoubleSolenoid(0, 1);
    addChild("solenoid", backSolenoid);

  }

  public void startTimer() {
    if (timerOn == false) {
      solenoidTimer.reset();
      solenoidTimer.start();
      timerOn = true;
    }
  }

  /*public void turnOn() {
    compressor.setClosedLoopControl(true);
  }

  public void turnOff() {
    compressor.setClosedLoopControl(false);
  }*/

  public void frontExtend() {
    frontSolenoid.set(DoubleSolenoid.Value.kForward);
    /*startTimer();
    if (solenoidTimer.get() >= 0.25) {
      solenoidTimer.stop();
      timerOn = false;
    }*/
    //solenoid1.set(DoubleSolenoid.Value.kOff);
    }

  public void backExtend(){
    backSolenoid.set(DoubleSolenoid.Value.kForward);
    }

  public void boxOpen(){
    boxSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void frontRetract() {
    frontSolenoid.set(DoubleSolenoid.Value.kReverse);
   /*solenoid1.set(DoubleSolenoid.Value.kReverse);
    startTimer();
    if (solenoidTimer.get() >= 0.25) {
      solenoidTimer.stop();
      timerOn = false;
    }*/
  }

  public void backRetract(){
    backSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void boxClose(){
    boxSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void stop() {                                    //not sure if we need it, it might stop on it's own
    frontSolenoid.set(DoubleSolenoid.Value.kOff);         
    boxSolenoid.set(DoubleSolenoid.Value.kOff);
    backSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
