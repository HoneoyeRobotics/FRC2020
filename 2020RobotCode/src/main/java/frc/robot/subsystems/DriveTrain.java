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
import edu.wpi.first.wpilibj.SPI;

public class DriveTrain extends SubsystemBase {
  private final SpeedController m_leftMotorGroup = new SpeedControllerGroup(new WPI_VictorSPX(26), new WPI_VictorSPX(25));
  private final SpeedController m_rightMotorGroup = new SpeedControllerGroup(new WPI_VictorSPX(27), new WPI_VictorSPX(28));
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotorGroup, m_rightMotorGroup);
  
  private final AHRS navx;

  public DriveTrain() {
    
    navx = new AHRS(SPI.Port.kMXP);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    boolean motionDetected = navx.isMoving();
    SmartDashboard.putNumber("Rotation", navx.getAngle());
    SmartDashboard.putBoolean("MotionDetected", motionDetected);
    SmartDashboard.putNumber("Pitch", navx.getPitch());
    SmartDashboard.putNumber("Roll", navx.getRoll());
  }

  public void drive(double xSpeed, double zRotation) {
  m_drive.arcadeDrive(xSpeed, zRotation);
  SmartDashboard.putNumber("xSpeed", xSpeed);
  SmartDashboard.putNumber("zRotation", zRotation);
}

  public double getAngle() {
    return navx.getAngle();
  }

  public void log() {
    //pee pee poo poo why are you reading this
 }
}