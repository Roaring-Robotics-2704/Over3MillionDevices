// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.



package org.usfirst.frc2704.comandrobot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2704.comandrobot.Robot;

/**
 *
 */
public class DriveWithJoystick extends Command {

    // increasing this value causes turn speed to be more higher per degree turned on the joystick.
    private double turnSpeedModifier = 0.50;

    // increasing this value causes the forwards/backwards speed to be larger for any joystick input.
    private double moveSpeedModifier = 1;

    // increasing this value makes the magnitude of robot twist required to enter "turn mode" higher.
    private double turnDeadZone = 0.5;

    // this value makes it so that when the robot leaves the turn speed dead zone, it doesn't jerk.
    private double turnadjust = turnDeadZone*turnSpeedModifier;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveWithJoystick() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (Math.abs(Robot.oi.joystick1.getZ())<turnDeadZone) {
            // forward speed is the modified motor impulse to move the robot.
            double forwardspeed=Robot.oi.joystick1.getY()*moveSpeedModifier;
            Robot.drivetrain.tankDrive(forwardspeed,forwardspeed);
        } else {
            // turn speed is the modified motor impulse to turn the robot.
            double turnspeed=Robot.oi.joystick1.getZ()*turnSpeedModifier;
            // make turning not jerky by decreasing the absolute value of turnspeed.
            // talk to tom for further explanation.
            turnspeed = turnspeed<0 ? turnspeed+turnadjust : turnspeed-turnadjust;
            // if there's a problem with the code, it's probably right here,
            // and it it safe to comment it out.
            Robot.drivetrain.tankDrive(turnspeed,-turnspeed);
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
        Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
