/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase {
  // These are our motor controlers
  private WPI_TalonSRX rearRightDriveMotor;
  private WPI_VictorSPX rearLeftDriveMotor;
  private WPI_VictorSPX frontRightDriveMotor;
  private WPI_VictorSPX frontLeftDriveMotor;
  private DifferentialDrive driveTrain;
  private SpeedControllerGroup leftDriveMotorGroup;
  private SpeedControllerGroup rightDriveMotorGroup;

  public DriveTrain() {
    // rearRightDriveMotor = new WPI_TalonSRX(RobotContainer.rearRightDriveMotorCanID);
    // rearLeftDriveMotor = new WPI_VictorSPX(RobotContainer.rearLeftDriveMotorCanID);
    // frontRightDriveMotor = new WPI_VictorSPX(RobotContainer.frontRightDriveMotorCanID);
    // frontLeftDriveMotor = new WPI_VictorSPX(RobotContainer.frontLeftDriveMotorCanID);
    leftDriveMotorGroup = new SpeedControllerGroup(rearLeftDriveMotor, frontLeftDriveMotor);
    rightDriveMotorGroup = new SpeedControllerGroup(rearRightDriveMotor, frontRightDriveMotor);
    driveTrain = new DifferentialDrive(leftDriveMotorGroup, rightDriveMotorGroup);
  }

  public void DifferentialDrive(final double ySpeed, final double xSpeed, final double zRotation)
  {
    SmartDashboard.putNumber("ySpeed", ySpeed);
    SmartDashboard.putNumber("xSpeed", xSpeed);
    SmartDashboard.putNumber("zRotation", zRotation);
    //driveTrain.driveCartesian(ySpeed, xSpeed, zRotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void log() {
}
}
