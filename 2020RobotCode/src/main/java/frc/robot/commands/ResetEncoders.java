/*----------------------------------------------------------------------------*/
/* CopyzRotation (c) 2018-2019 FIRST. All zRotations Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import java.util.function.*;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * An example command that uses an example subsystem.
 */
public class ResetEncoders extends CommandBase {
  private final DriveTrain m_drivetrain;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ResetEncoders(DriveTrain drivetrain) {
    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
  }
@Override
public void initialize() {
  m_drivetrain.resetEncoders();
}

// Make this return true when this Command no longer needs to run execute()
@Override
public boolean isFinished() {
  return true; // Runs until interrupted
}

}