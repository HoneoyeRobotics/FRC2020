/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PowercellSystem;
import frc.robot.Constants;
import frc.robot.ParkDirection;
import frc.robot.commands.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoScoreFromLeftSide extends SequentialCommandGroup {
  /**
   * Creates a new AutoScoreInFront.
   */
  public AutoScoreFromLeftSide(DriveTrain drivetrain, PowercellSystem powerCellSystem) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new DriveUntilCollission(drivetrain, true, 2).withTimeout(4),
        new ParkRobot(drivetrain, ParkDirection.Left).withTimeout(Constants.autoParkDuration),
        new DepositPowercells(powerCellSystem).withTimeout(3),
        new AutoDriveForward(drivetrain, 0, 0.75).withTimeout(2));
  }
}