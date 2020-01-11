/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  //These are our motor controlers 
  private WPI_TalonSRX rearRightDriveMotor;
  private WPI_VictorSPX rearLeftDriveMotor;
  private WPI_VictorSPX frontRightDriveMotor;
  private WPI_VictorSPX frontLeftDriveMotor;
  private Arcade drivetrain;
  public DriveTrain() {
    rearRightDriveMotor = new WPI_TalonSRX();
    rearLeftDriveMotor = new WPI_VictorSPX();
    frontRightDriveMotor = new WPI_VictorSPX();
    frontLeftDriveMotor = new WPI_VictorSPX();
    leftDriveMotorGroup = new SpeedControlerGroup(rearLeftDriveMotor, frontLeftDriveMotor);
    rightDriveMotorGroup = new SpeedControlerGroup(rearRightDriveMotor, frontRightDriveMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
