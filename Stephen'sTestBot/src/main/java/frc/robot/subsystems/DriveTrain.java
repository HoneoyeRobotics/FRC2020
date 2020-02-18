/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final SpeedController leftMotorGroup;
  private final SpeedController rightMotorGroup;
  private final DifferentialDrive drive;

  public DriveTrain() {
    leftMotorGroup = new SpeedControllerGroup(new WPI_VictorSPX(1), new WPI_VictorSPX(2));
    rightMotorGroup = new SpeedControllerGroup(new WPI_VictorSPX(3), new WPI_VictorSPX(4));
    drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
