/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;

public class RunControlPanelArmWheel extends CommandBase {
  private ControlPanel controlPanel;
  private double CurrentSpeed = 0.0;
  private double SpeedModifier = 0.1;
  private BooleanSupplier IncreaseSpeed;
  private BooleanSupplier DecreaseSpeed;
  private boolean IncreasingSpeed = false;
  private boolean DecreasingSpeed = false;
  public RunControlPanelArmWheel(ControlPanel ControlPanel, BooleanSupplier IncreaseSpeed, BooleanSupplier DecreaseSpeed) {
    this.controlPanel = ControlPanel;
    this.IncreaseSpeed = IncreaseSpeed;
    this.DecreaseSpeed = DecreaseSpeed;
    addRequirements(controlPanel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putString("RunWheelStatus", "Initialize");
    CurrentSpeed = 0.5;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(IncreaseSpeed.getAsBoolean() == true && IncreasingSpeed == false){
      CurrentSpeed += SpeedModifier;
      IncreasingSpeed = true; 
    }
    else if (IncreaseSpeed.getAsBoolean() == false && IncreasingSpeed == true)
      IncreasingSpeed = false;

    if(DecreaseSpeed.getAsBoolean() == true && DecreasingSpeed == false){
      CurrentSpeed -= SpeedModifier;
      DecreasingSpeed = true; 
    }
    else if (DecreaseSpeed.getAsBoolean() == false && DecreasingSpeed == true)     
    DecreasingSpeed = false;

    if (CurrentSpeed >= 1.0) {
      CurrentSpeed = 1.0;
    }
    
    if (CurrentSpeed <= 0.0) {
      CurrentSpeed = 0;
    }
    controlPanel.run(CurrentSpeed);
    SmartDashboard.putString("RunWheelStatus", "Execute");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    controlPanel.stopRunning();
    SmartDashboard.putString("RunWheelStatus", "End");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}