/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;

public class RunControlPanelArmWheel extends CommandBase {
  // private WPI_VictorSPX controlPanelArmWheel;
  private ControlPanel controlPanel;
  // private Command startRunning;
  // private Command stopRunning;

  public RunControlPanelArmWheel(ControlPanel ControlPanel) {
    this.controlPanel = ControlPanel;
    addRequirements(controlPanel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putString("RunWheelStatus", "Initialize");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    controlPanel.startRunning();
    SmartDashboard.putString("RunWheelStatus", "Execute");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean command_ends) {
    controlPanel.stopRunning();
    SmartDashboard.putString("RunWheelStatus", "End");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}