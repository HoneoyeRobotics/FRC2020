/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PowerCellSystem extends SubsystemBase {
  private final int PCMID;  
  private final Compressor compressor;
  private final DoubleSolenoid conveyorSolenoid;
  private final DoubleSolenoid rearHatchSolenoid;
  //private final VictorSfinal final PX m_ConveyerMotor;
  private final WPI_VictorSPX frontWheelMotor = new WPI_VictorSPX(10); 
  private final WPI_VictorSPX conveyerMotor = new WPI_VictorSPX(11);
  
  public PowerCellSystem(int PCMID) {
    //initializes compressor here
    conveyorSolenoid = new DoubleSolenoid (PCMID, 4,5);
    rearHatchSolenoid = new DoubleSolenoid (PCMID, 2,3);
    this.PCMID = PCMID;
    compressor = new Compressor(PCMID);
    compressor.setClosedLoopControl(true);
  }

  public void RunFrontWheel(double speed) {
    frontWheelMotor.set(speed);
  }

  public void RunConveyer(double speed) {
    conveyerMotor.set(speed);
  }

  public void OpenConveyerHatch() {
    rearHatchSolenoid.set(Value.kForward);
  }

  public void CloseConveyerHatch() {
    rearHatchSolenoid.set(Value.kReverse);
  }

  public void HoldConveyerHatch() {
    rearHatchSolenoid.set(Value.kOff);
  }

  public void RaiseConveyer() {
    conveyorSolenoid.set(Value.kForward);
  }

  public void HoldConveyer() {
    conveyorSolenoid.set(Value.kOff); 
  }

  public void LowerConveyer() {
    conveyorSolenoid.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}