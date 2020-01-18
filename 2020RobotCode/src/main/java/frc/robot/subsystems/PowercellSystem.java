/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PowercellSystem extends SubsystemBase {
  public PowercellSystem() {
    //initialize all motors here
  }

  public void RunFrontWheel() {
    //bla bla runs the front wheel shaft
  }

  public void RunBottomConveyer() {
    //bla bla runs bottom conveyer
  }

  public void RunTopConveyer() {
    //bla bla runs top conveyer
  }

  public void RunBackWheel() {
    //bla bla runs back wheel shaft
  }

  public void OpenConveyerHatch() {
    //bla bla opens conveyer hatch
  }

  public void CloseConveyerHatch() {
    //bla bla closes conveyer hatch
  }

  public void OpenPneumatics() {
    //bla bla open pneumatic pistons
  }

  public void StopPneumatics() {
    //bla bla hold pneumatic pistons
  }

  public void ClosePneumatics() {
    //bla bla close pneumatic pistons
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
