/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  
  private final DoubleSolenoid elevatorSolenoid;

  public Climber(int PCMID) {
    //initialize all motors here
    elevatorSolenoid = new DoubleSolenoid (PCMID, 4,5);
  }

  public void RaiseClimber() {
    //bla bla elevate climber
  }

  public void LowerClimber() {
    //bla bla retract climber
  }

  public void HoldClimber() {
    //bla bla hold climbers current position
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
