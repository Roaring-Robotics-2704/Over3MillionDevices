/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDBase;
import edu.wpi.first.wpilibj.TimedRobot;
/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
private WPI_VictorSPX liftMotor1;
private WPI_VictorSPX liftMotor2;
private SpeedControllerGroup liftMotors;
public Lift(){

  liftMotor1 = new WPI_VictorSPX(1);
  addChild("lift Motor1", liftMotor1);
  liftMotor1.setInverted(false);

  liftMotor2 = new WPI_VictorSPX(2);
  addChild("lift Motor2", liftMotor2);
  liftMotor2.setInverted(false);

  liftMotors = new SpeedControllerGroup(liftMotor1, liftMotor2);
  addChild("lift Motors",liftMotors);

}
public void liftUp(){
  liftMotors.set(0.5);

}
public void liftDown(){
  liftMotors.set(0.5);
}
public void liftStop(){
  liftMotors.set(0);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
