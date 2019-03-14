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

public class LiftControls extends Command {

  public LiftControls() {
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
    //System.out.println("lift pos = " + Robot.lift.getLiftPosition());
    boolean manualup=Robot.oi.joystick1Buttons[5].get(),
        manualdown=Robot.oi.joystick1Buttons[3].get(),
        //stageup=Robot.oi.joystick1Buttons[6].get(),
        //stagedown=Robot.oi.joystick1Buttons[4].get(),
        slowdrop=Robot.oi.joystick1Buttons[4].get();
    Lift l = Robot.lift;
    if (manualup) {
        l.liftUp();
    } else if (manualdown) {
        l.liftDown();
    } else if (slowdrop) {
        l.setSpeed(-0.1);
    /*} else if (stageup || stagedown) {
        if (l.homed) {
            if (stageup) {
                // todo
            } else if (stagedown) {
                // todo
            }
        } else {
            //l.home();
        }
    */} else {
        l.liftStop();
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
    Robot.lift.liftStop();
  }
  

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}