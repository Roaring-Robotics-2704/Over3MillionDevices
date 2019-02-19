/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2704.comandrobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2704.comandrobot.Robot;

public class ControlHookWithButtons extends Command {
  public ControlHookWithButtons() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.hatchhook.turnOn();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.oi.joystick1Buttons[1].get() == true && Robot.hatchhook.canUseHook == true) {
      Robot.hatchhook.canUseHook = false;
      Robot.hatchhook.extend();
    }
    if (Robot.oi.joystick1Buttons[2].get() == true && Robot.hatchhook.canUseHook == true) {
      Robot.hatchhook.canUseHook = false;
      Robot.hatchhook.retract();
    }
    if (Robot.oi.joystick1Buttons[7].get() == true) {
      Robot.hatchhook.turnOn();
    }
    if (Robot.oi.joystick1Buttons[8].get() == true) {
      Robot.hatchhook.turnOff();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.hatchhook.turnOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}