/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2704.comandrobot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2704.comandrobot.Robot;
import org.usfirst.frc2704.comandrobot.subsystems.*;

public class MoveClawWithJoystick extends Command {

  public MoveClawWithJoystick() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
     boolean Clawup=Robot.oi.joystick2Buttons[1].get(),
     Clawdown=Robot.oi.joystick2Buttons[2].get();
     BallClaw B = Robot.ballclaw;
     if (Clawup) {
      B.setTilt(0.8);
  } else if (Clawdown) {
      B.setTilt(-0.8);
  } else {
      B.setTilt(0);
    }

     
      B.setGrab(Robot.oi.joystick2.getY());
    
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.ballclaw.stopGrab();
    Robot.ballclaw.stopTilt();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
