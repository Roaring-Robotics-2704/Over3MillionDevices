/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDBase;
import edu.wpi.first.wpilibj.TimedRobot;
/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
private WPI_TalonSRX liftTalon;

public Lift(){

  liftTalon = new WPI_TalonSRX(1);
  addChild("lift talon", liftTalon);
  liftTalon.setInverted(false);
}
public void liftUp(){
  liftTalon.set(0.5);

}
public void liftDown(){
  liftTalon.set(0.5);
}
public void liftStop(){
  liftTalon.set(0);
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
