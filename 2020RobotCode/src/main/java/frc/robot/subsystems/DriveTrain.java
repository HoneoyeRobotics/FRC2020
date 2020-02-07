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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private final SpeedController m_leftMotorGroup = new SpeedControllerGroup(
      new WPI_VictorSPX(Constants.CANID_FrontLeftDriveMotor), new WPI_VictorSPX(Constants.CANID_RearLeftDriveMotor));
  private final SpeedController m_rightMotorGroup = new SpeedControllerGroup(
      new WPI_VictorSPX(Constants.CANID_FrontRightDriveMotor), new WPI_VictorSPX(Constants.CANID_RearRightDriveMotor));
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotorGroup, m_rightMotorGroup);
  private final Encoder leftEncoder;
  private final Encoder rightEncoder;
  private final AHRS navx;

  public DriveTrain() {
    // AHRS ahrs = new AHRS(SerialPort.Port.kMXP); /* Alternatives: SPI.Port.kMXP,
    // I2C.Port.kMXP or SerialPort.Port.kUSB */
    navx = new AHRS(SPI.Port.kMXP);
    leftEncoder = new Encoder(Constants.leftEncoderA, Constants.leftEncoderB);
    rightEncoder = new Encoder(Constants.rightEncoderA, Constants.rightEncoderB);
    leftEncoder.setDistancePerPulse((6.0 / 12.0 * Math.PI) / 360.0);
    rightEncoder.setDistancePerPulse((6.0 / 12.0 * Math.PI) / 360.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    boolean motionDetected = navx.isMoving();
    SmartDashboard.putNumber("Rotation", navx.getAngle());
    SmartDashboard.putBoolean("MotionDetected", motionDetected);
    SmartDashboard.putNumber("Pitch", navx.getPitch());
    SmartDashboard.putNumber("Roll", navx.getRoll());
    SmartDashboard.putNumber("LeftEncoder", leftEncoder.get());
    SmartDashboard.putNumber("RightEncoder", rightEncoder.get());
    SmartDashboard.putNumber("LeftEncoderDistance", leftEncoder.getDistance());
    SmartDashboard.putNumber("RightEncoderDistance", rightEncoder.getDistance());
  }

  // public void drive(double xSpeed, double zRotation) {
  //   m_drive.arcadeDrive(xSpeed, zRotation);
  //   SmartDashboard.putNumber("xSpeed", xSpeed);
  //   SmartDashboard.putNumber("zRotation", zRotation);
  // }

  public void drive(double leftSpeed, double rightSpeed) {
    m_drive.tankDrive(leftSpeed,rightSpeed);
    SmartDashboard.putNumber("rightSpeed", rightSpeed);
    SmartDashboard.putNumber("leftSpeed", leftSpeed);

  }

  public double getAngle() {
    return navx.getAngle();
  }


  public double rightEncoderDistance(){
    return rightEncoder.getDistance();
  }

  public double leftEncoderDistance(){
    return leftEncoder.getDistance();
  }
  public void resetEncoders(){
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public void log() {
    // pee pee poo poo why are you reading this
    // did you know that cameras have a limited fov
  }
}