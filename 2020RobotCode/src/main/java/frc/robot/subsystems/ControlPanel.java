/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanel extends SubsystemBase {
  double ControlPanelArmWheelSpeed = 0.5;
  private final WPI_VictorSPX m_ControlPanelArmWheel = new WPI_VictorSPX(8);
  
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  private final ColorMatch m_colorMatcher = new ColorMatch();  

  public enum MatchedColor { None, Blue, Green, Red, Yellow }
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  private double editableConfidence = 0.92;

  public ControlPanel() {
    resetConfidence();
    SmartDashboard.putNumber("Editable Confidence", editableConfidence);
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
  }

  public void resetConfidence(){
    Preferences prefs = Preferences.getInstance();
       
    editableConfidence = prefs.getDouble("ColorWheelConfidence", 0.93);
    
    SmartDashboard.putNumber("Editable Confidence", editableConfidence);
  }

  public void MoveArmWheel() {
    //bla bla moves arm wheel
  }

  public void RunArmWheel(double speed) {
    m_ControlPanelArmWheel.set(speed);
  }

  public void ExtendArmWheel() {
    //bla bla extends arm wheel from frame
  }

  public void RetractArmWheel() {
    //bla bla retracts arm wheel to frame
  }

  public MatchedColor getColor(){
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    MatchedColor currentColor;

    if (match.color == kBlueTarget) {
      currentColor = MatchedColor.Blue;
    } else if (match.color == kRedTarget) {
      currentColor = MatchedColor.Red;
    } else if (match.color == kGreenTarget) {
      currentColor = MatchedColor.Green;
    } else if (match.color == kYellowTarget) {
      currentColor = MatchedColor.Yellow;
    } else {
      currentColor = MatchedColor.None;
    }
    
    if (match.confidence <= editableConfidence) {
      currentColor = MatchedColor.None;
    }
    SmartDashboard.putString("COLOR: Guess Color", currentColor.toString());
    
    SmartDashboard.putNumber("COLOR: Confidence", match.confidence);
    return currentColor;
    
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}