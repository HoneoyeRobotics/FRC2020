/*----------------------------------------------------------------------------*/
/* CopyzRotation (c) 2018-2019 FIRST. All zRotations Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import java.util.function.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * An example command that uses an example subsystem.
 */
public class ArcadeDrive extends CommandBase {
  private final DriveTrain m_drivetrain;
  private final DoubleSupplier m_xSpeed;
  private final DoubleSupplier m_zRotation;

  private final BooleanSupplier m_stephenMode;

  private boolean stephenMode = false;
  private boolean stephenModePressed = false;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDrive(DoubleSupplier xSpeed, DoubleSupplier zRotation, BooleanSupplier stephenMode, DriveTrain drivetrain) {
    m_drivetrain = drivetrain;
    m_xSpeed = xSpeed;
    m_zRotation = zRotation;
    m_stephenMode = stephenMode;
    addRequirements(m_drivetrain);
  }

// Called repeatedly when this Command is scheduled to run
@Override
public void execute() {
  m_drivetrain.drive(m_xSpeed.getAsDouble(), m_zRotation.getAsDouble() * 0.75);
  //is not pressed, and button pressed
  if(stephenModePressed == false && m_stephenMode.getAsBoolean())
  {
    stephenModePressed = true;
    stephenMode = !stephenMode;
    SmartDashboard.putBoolean("StephenMode", stephenMode);
  }
  else if(stephenModePressed == m_stephenMode.getAsBoolean() == false){
    stephenModePressed = false;
  }

}

//Make this return true when this Command no longer needs to run execute()
@Override
public boolean isFinished() {
  return false; // Runs until interrupted
}

// Called once after isFinished returns true
@Override
public void end(boolean interrupted) {
  m_drivetrain.drive(0, 0);
}
}