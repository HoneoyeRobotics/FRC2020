/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanel extends SubsystemBase {
  double ControlPanelArmWheelSpeed = 0.5;
  private final WPI_VictorSPX m_ControlPanelArmWheel = new WPI_VictorSPX(8);
  public ControlPanel() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
  public void run(double speed) {
    m_ControlPanelArmWheel.set(speed);
  }

  public void startRunning() {
    m_ControlPanelArmWheel.set(ControlPanelArmWheelSpeed);
  }

  public void increaseWheelSpeed() {
    ControlPanelArmWheelSpeed = ControlPanelArmWheelSpeed + 0.1;
    m_ControlPanelArmWheel.set(ControlPanelArmWheelSpeed);
  }

  public void decreaseWheelSpeed() {
    ControlPanelArmWheelSpeed = ControlPanelArmWheelSpeed - 0.1;
    m_ControlPanelArmWheel.set(ControlPanelArmWheelSpeed);
  }

  /**
   * Set the claw motor to move in the close direction.
   */
  public void stopRunning() {
    m_ControlPanelArmWheel.set(0);
  }

  // public void drive(final double xSpeed) {
  //   m_ControlPanelArmWheel.open();
  // }

public void placeholder() {

}
}