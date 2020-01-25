/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PowercellSystem extends SubsystemBase {
  private final Compressor compressor;
  private final DoubleSolenoid conveyorSolenoid;
  //private final DoubleSolenoid rearHatchSolenoid;
  // private final VictorSfinal final PX m_ConveyerMotor;
  private final WPI_TalonSRX conveyerMotor = new WPI_TalonSRX(Constants.CANID_ConveyerMotor);
  private final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(Constants.CANID_IntakeMotor);

  public PowercellSystem() {
    //initializes compressor here
    conveyorSolenoid = new DoubleSolenoid (Constants.CANID_PCM, Constants.PCMID_ConveyerSoleniodForward, Constants.PCMID_ConveyerSoleniodBackward);
   //rearHatchSolenoid = new DoubleSolenoid (Constants.CANID_PCM, Constants.PCMID_ConveyerHatchForward, Constants.PCMID_ConveyerHatchBackward);
    compressor = new Compressor(Constants.CANID_PCM);
    compressor.setClosedLoopControl(true);
  }

  public void RunConveyer(double speed) {
    conveyerMotor.set(speed);
  }

  public void RunIntake(double speed) {
    intakeMotor.set(speed);
  }

  // public void OpenConveyerHatch() {
  //   rearHatchSolenoid.set(Value.kForward);
  // }

  // public void CloseConveyerHatch() {
  //   rearHatchSolenoid.set(Value.kReverse);
  // }

  // public void HoldConveyerHatch() {
  //   rearHatchSolenoid.set(Value.kOff);
  // }

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