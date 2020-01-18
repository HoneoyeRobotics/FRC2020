/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final SpeedController m_leftMotorGroup = new SpeedControllerGroup(new WPI_VictorSPX(1), new WPI_VictorSPX(2));
  private final SpeedController m_rightMotorGroup = new SpeedControllerGroup(new WPI_VictorSPX(3), new WPI_TalonSRX(9));
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotorGroup, m_rightMotorGroup);
  
  public DriveTrain() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double xSpeed, double zRotation) {
  m_drive.arcadeDrive(xSpeed, zRotation);
  SmartDashboard.putNumber("xSpeed", xSpeed);
  SmartDashboard.putNumber("zRotation", zRotation);
}

  public void log() {
    //pee pee poo poo why are you reading this
 }
}