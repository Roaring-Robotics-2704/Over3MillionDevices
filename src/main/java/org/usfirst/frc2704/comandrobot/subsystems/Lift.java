/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDOutput;
import java.lang.Math.*;
/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
private WPI_TalonSRX liftMotor1;
private WPI_TalonSRX liftMotor2;
  private DigitalInput limitSwitch;
private SpeedControllerGroup liftMotors;
public Encoder liftEncoder;
  private boolean PIDActive = false;
  public boolean homed = false;
  private double liftSpeed = 0.75;
  private PIDController pid;
  private boolean canToggleStage;
  public double goalDistance = 0;
public Lift() {

  liftMotor1 = new WPI_TalonSRX(1);
  addChild("lift Motor1", liftMotor1);
  liftMotor1.setInverted(false);

  liftMotor2 = new WPI_TalonSRX(2);
  addChild("lift Motor2", liftMotor2);
  liftMotor2.follow(liftMotor1);
  liftMotor2.setInverted(InvertType.FollowMaster);

  liftEncoder = new Encoder(1, 2, false, Encoder.EncodingType.k4X);
  liftEncoder.setDistancePerPulse(1.440);
  liftEncoder.reset();
  liftMotors = new SpeedControllerGroup(liftMotor1, liftMotor2);
  //limitSwitch = new DigitalInput(0);
  
  pid = new PIDController(0.01,0,0,liftEncoder,liftMotors);
  pid.disable();
  //pid.setInputRange(0,0);
  pid.setOutputRange(-liftSpeed,liftSpeed);
  // safety
}
public void pidConflictResolve() {
  if (pid.isEnabled()) {
    pid.disable();
  }
}

public void liftUp(){
  pidConflictResolve();
  /*if (liftEncoder.getDistance() >= 1000) {
    liftMotors.set(liftSpeed);
  }
  else if (liftEncoder.getDistance() <= 1000) {
      liftMotors.set(0);
  }
  */
  liftMotors.set(liftSpeed);
 // liftEncoder.reset();
}

public void liftDown(){
  pidConflictResolve();
  /*
 if( liftEncoder.getDistance() >= 10){
  liftMotors.set(-liftSpeed);
 }
 
 else if( liftEncoder.getDistance() <= 10){
  liftMotors.set(0);
 }e
*/
  liftMotors.set(-0.05);
 // liftEncoder.reset();
}
public void liftStop(){
  pidConflictResolve();
  if (liftEncoder.getDistance() < goalDistance) {
    liftMotors.set((Math.abs(liftEncoder.getDistance() - goalDistance)/75) * (liftSpeed));
  }
  else if (liftEncoder.getDistance() > goalDistance) {
    liftMotors.set((Math.abs(liftEncoder.getDistance() - goalDistance)/20) * (-liftSpeed));
  }
  /*
  if (liftEncoder.getDistance() <= 0 && liftEncoder.getDistance() != goalDistance) {
    liftMotors.set((Math.abs(liftEncoder.getDistance() - goalDistance)/75) * (liftSpeed));
  }
  else if (liftEncoder.getDistance() >= 1 && liftEncoder.getDistance() != goalDistance ) {
    liftMotors.set((Math.abs(liftEncoder.getDistance() - goalDistance)/20) * (-liftSpeed));
  }
  */
  //liftMotors.set(0);
}

public void setLiftPosition(double a) {
  pid.setSetpoint(a);
  pid.enable();
}

public double getDistance() {
  return liftEncoder.getDistance();
}

public void setSpeed(double a) {
  pidConflictResolve();
  liftMotors.set(a);
}
public double getSpeed(){
  return liftMotors.get();
}
/*
public void goUpOneStage() {
  liftMotor1.set(0.5);
  if (liftEncoder.getDistance() >= .8) {
    canToggleStage = true;
  }
}

public void goDownOneStage() {
  liftMotor1.set(-0.5);
  if (liftEncoder.getDistance() >= .8) {
    canToggleStage = true;
  }
}
*/
public boolean home() {
  if (limitSwitch.get()) {
    homed=true;
    liftEncoder.reset();
    return true;
  } else {
    liftMotor1.set(-0.1);
    return false;
  }
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
