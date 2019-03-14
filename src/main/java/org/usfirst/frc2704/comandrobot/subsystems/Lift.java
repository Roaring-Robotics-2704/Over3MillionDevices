/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDOutput;
/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
private WPI_VictorSPX liftMotor1;
private WPI_VictorSPX liftMotor2;
  private DigitalInput limitSwitch;
private SpeedControllerGroup liftMotors;
public Encoder liftEncoder;
  private boolean PIDActive = false;
  public boolean homed = false;
  private double liftSpeed = 0.25;
  private PIDController pid;
public Lift() {

  liftMotor1 = new WPI_VictorSPX(1);
  addChild("lift Motor1", liftMotor1);
  liftMotor1.setInverted(false);

  liftMotor2 = new WPI_VictorSPX(2);
  addChild("lift Motor2", liftMotor2);
  liftMotor2.follow(liftMotor1);
  liftMotor2.setInverted(InvertType.FollowMaster);

  liftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
  liftEncoder.setDistancePerPulse(1.440);

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
  liftMotors.set(liftSpeed);

}
public void liftDown(){
  pidConflictResolve();
  liftMotors.set(-liftSpeed);
}
public void liftStop(){
  pidConflictResolve();
  liftMotors.set(0);
}
/*
public void setLiftPosition(double a) {
  pid.setSetpoint(a);
  pid.enable();
}

public double getLiftPosition() {
  return liftEncoder.getDistance();
}
*/
public void setSpeed(double a) {
  pidConflictResolve();
  liftMotors.set(a);
}
/*
public void goUpOneStage() {
  liftMotor1.set(0.5);
  if (liftEncoder.getDistance() >= .8) {
    canToggleStage = true;
  }
}

public void goDownOneStage() {
  liftMotor1.set(0.5);
  if (liftEncoder.getDistance() >= .8) {
    canToggleStage = true;
  }
}*/

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
