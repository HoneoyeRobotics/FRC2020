/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Rotate90 extends CommandBase {
  /**
   * Creates a new Rotate90.
   */
  public Rotate90() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // store current angle in  variable 
    // set degrees turned to zero
    // poo poo pee pee
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // get current angle and increment degrees turned
    // turn robot
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // return true if degrees turned is greater than 90
    return false;
  }
}
