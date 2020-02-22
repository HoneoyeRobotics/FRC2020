/*----------------------------------------------------------------------------*/
/* CopyzRotation (c) 2018-2019 FIRST. All zRotations Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import java.util.function.*;

import edu.wpi.first.wpilibj2.command.*;
//import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * An example command that uses an example subsystem.
 */
public class AutoTest1 extends SequentialCommandGroup {
  
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutoTest1(DriveTrain drivetrain) {
    addCommands(new RotateDrive(drivetrain, 90), 
    new AutoDriveForward(drivetrain, 1, 1), 
    new RotateDrive(drivetrain, 270),
        new AutoDriveForward(drivetrain, 1, 1));
  }

}