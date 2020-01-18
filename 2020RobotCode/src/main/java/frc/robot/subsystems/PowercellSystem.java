/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PowerCellSystem extends SubsystemBase {

  private final int PCMID;  
  private final Compressor compressor;
  private final DoubleSolenoid  conveyorSolenoid;
  private final DoubleSolenoid  rearHatchSolenoid;
  public PowerCellSystem(int PCMID) {
    //initialize all motors here
    conveyorSolenoid = new DoubleSolenoid (PCMID, 0,1);
    rearHatchSolenoid = new DoubleSolenoid (PCMID, 2,3);
    this.PCMID = PCMID;
    compressor = new Compressor(PCMID);
    compressor.setClosedLoopControl(true);
  }

  public void RunFrontWheel() {
    //bla bla runs the front wheel shaft
  }

  public void RunConveyer() {
    //bla bla runs bottom conveyer
  }

  public void OpenConveyerHatch() {
    //bla bla opens conveyer hatch
  }

  public void CloseConveyerHatch() {
    //bla bla closes conveyer hatch
  }

  public void HoldConveyerHatch() {
    //bla bla hold conveyer hatch position
  }

  public void RaiseConveyer() {
    //bla bla raise conveyer pneumatic pistons
  }

  public void HoldConveyer() {
    //bla bla hold pneumatic pistons position 
  }

  public void LowerConveyer() {
    //bla bla close pneumatic pistons
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
