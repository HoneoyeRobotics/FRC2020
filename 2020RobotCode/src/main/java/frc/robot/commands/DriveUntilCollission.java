/*----------------------------------------------------------------------------*/
/* CopyzRotation (c) 2018-2019 FIRST. All zRotations Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import java.util.function.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * An example command that uses an example subsystem.
 */
public class DriveUntilCollission extends CommandBase {
  private final DriveTrain m_drivetrain;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveUntilCollission(DriveTrain drivetrain, boolean reverse, double minTime) {
    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
    this.reverse = reverse;
    this.minTime = minTime;
  }

  private final double minTime;
  private final boolean reverse;

  private Timer timer  = new Timer();
  @Override
  public void initialize() {
    
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    double xSpeed = 0.667;
    if(reverse)
      xSpeed *= -1;
    m_drivetrain.drive(xSpeed, 0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return m_drivetrain.collisionDetected() && timer.get() > minTime;
  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0, 0);
  }
}