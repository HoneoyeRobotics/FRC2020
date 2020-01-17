/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ControlPanel;
import frc.robot.subsystems.ControlPanel.MatchedColor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ControlPanelColorVisionTracking extends CommandBase {
  private final ControlPanel controlPanel;

  public ControlPanelColorVisionTracking(ControlPanel controlPanel) {
    this.controlPanel = controlPanel;
    addRequirements(controlPanel);
  }

  private MatchedColor lastColor = MatchedColor.None;
  private MatchedColor lookForColor = MatchedColor.None;

  private double rotations = 0.0;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lastColor = MatchedColor.None;
    lookForColor = MatchedColor.None;
    rotations = 0.0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    MatchedColor currentColor = controlPanel.getColor();

    if (lookForColor == MatchedColor.None && currentColor != MatchedColor.None)
      lookForColor = currentColor;
    else if (lastColor != MatchedColor.None && currentColor != MatchedColor.None && currentColor != lastColor
        && currentColor == lookForColor) {
      rotations += 0.5;
    }
    if(currentColor == MatchedColor.None)
      return;
    lastColor = currentColor;

    SmartDashboard.putString("LastColor", lastColor.toString());
    SmartDashboard.putString("lookForColor", lookForColor.toString());
    SmartDashboard.putNumber("rotations", rotations);
    SmartDashboard.putString("Detected Color", currentColor.toString());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
