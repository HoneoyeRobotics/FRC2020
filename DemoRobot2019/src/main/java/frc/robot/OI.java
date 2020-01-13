/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * Add your docs here.
 */
public class OI {
public final int driverJoystickForwardAxis = 1;  //left stick, left and right
  public final int driverJoystickTurnLeftAxis = 2;   // left trigger
  public final int driverJoystickTurnRightAxis = 3;   // right trigger

  public final int driverJoystickStrafeAxis = 0; 

  public Joystick driverJoystick = new Joystick(0); 
  public Joystick secondaryJoystick = new Joystick(1);

//   public JoystickButton driverButtonA = new JoystickButton(driverJoystick, 1);  
//   public JoystickButton driverButtonB  = new JoystickButton(driverJoystick, 2); 
//   public JoystickButton driverButtonX = new JoystickButton(driverJoystick, 3);   
//   public JoystickButton driverButtonY = new JoystickButton(driverJoystick, 4); 
//   public JoystickButton leftStickButton2 = new JoystickButton(leftTankStick, 2);   
//   public JoystickButton rightStickButton2 = new JoystickButton(rightTankStick, 2);
//   public JoystickButton rightStickButton10 = new JoystickButton(rightTankStick, 10); 
//   public JoystickButton rightStickButton11  = new JoystickButton(rightTankStick, 11);

  public JoystickButton secondaryButtonA = new JoystickButton(secondaryJoystick, 1);  
  public JoystickButton secondaryButtonB  = new JoystickButton(secondaryJoystick, 2);
  public JoystickButton secondaryButtonX = new JoystickButton(secondaryJoystick, 3);
  public JoystickButton secondaryButtonY = new JoystickButton(secondaryJoystick, 4);
  public JoystickButton secondaryButtonLB = new JoystickButton(secondaryJoystick, 5);
  public JoystickButton secondaryButtonRB  = new JoystickButton(secondaryJoystick, 6);
  public JoystickButton secondaryButtonBack = new JoystickButton(secondaryJoystick, 7);
  public JoystickButton secondaryButtonStart = new JoystickButton(secondaryJoystick, 8);


}
