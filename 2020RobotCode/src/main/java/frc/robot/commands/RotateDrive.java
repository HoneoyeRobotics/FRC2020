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
public class RotateDrive extends CommandBase {
  private final DriveTrain m_drivetrain;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RotateDrive(DriveTrain drivetrain, double angle) {
    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
    this.angle = angle;
  }

  private double angle = 0;
  private double startAngle = 0;
  private double endAngle = 0;

  @Override
  public void initialize() {
    startAngle = m_drivetrain.getAngle();
    endAngle = startAngle + angle;
  }

  @Override
  public void execute() {
    double driveSpeed = 0.5;
    if (m_drivetrain.getAngle() > endAngle)
      driveSpeed *= -1;
    m_drivetrain.drive(0, driveSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return m_drivetrain.getAngle() > endAngle;
  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0, 0);
  }

}