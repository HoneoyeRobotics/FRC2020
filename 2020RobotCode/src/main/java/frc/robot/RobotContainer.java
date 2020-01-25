/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import java.util.ResourceBundle.Control;

//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//all command and subsystem imports
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ControlPanel controlPanel;
  private final DriveTrain drivetrain;
  private final Climber climber;
  private final PowerCellSystem powerCellSystem;
  private final Joystick driverJoystick = new Joystick(0);
  private final Joystick pilotJoystick = new Joystick(1);
  // private final JoystickButton m_RunControlPanelArmWheel = new
  // JoystickButton(pilotJoystick, 0); // button A, check button id
  // private final Autonomous m_autonomousCommand = new Autonomous();
  private final ArcadeDrive m_autoCommand;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // construct subsystems
    drivetrain = new DriveTrain();
    climber = new Climber();
    controlPanel = new ControlPanel();
    powerCellSystem = new PowerCellSystem();

    drivetrain.setDefaultCommand(new ArcadeDrive(() -> driverJoystick.getRawAxis(1) * -1,
        () -> driverJoystick.getRawAxis(2) - driverJoystick.getRawAxis(3), drivetrain));
    controlPanel.setDefaultCommand(new ControlPanelColorVisionTracking(controlPanel));
    
    // Show what command your subsystem is running on the SmartDashboard
    SmartDashboard.putData(drivetrain);
    SmartDashboard.putData(controlPanel);
    SmartDashboard.putData(new ResetControlPanel(controlPanel));
    
    // Call log method on all subsystems
    drivetrain.log();
    m_autoCommand = new ArcadeDrive(null, null, drivetrain);
    
    // Configure the button bindings
    configurePilotButtonBindings();
    configureDriverButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configurePilotButtonBindings() {
    // buttons for pilot joystick
    final JoystickButton aButton = new JoystickButton(pilotJoystick, 1);
    final JoystickButton bButton = new JoystickButton(pilotJoystick, 2);
    final JoystickButton xButton = new JoystickButton(pilotJoystick, 3);
    final JoystickButton leftBumper = new JoystickButton(pilotJoystick, 5);
    final JoystickButton rightBumper = new JoystickButton(pilotJoystick, 6);

    // Connect the buttons to commands
    aButton.toggleWhenPressed(new RunControlPanelArmWheel(controlPanel, () -> bButton.get(), () -> xButton.get()));
    leftBumper.whileHeld(new ExtendControlPanelArm(controlPanel));
    rightBumper.whileHeld(new RetractControlPanelArm(controlPanel));
  }

  private void configureDriverButtonBindings() {
    // buttons for driverjoystick
    final JoystickButton leftBumper = new JoystickButton(driverJoystick, 5);
    final JoystickButton rightBumper = new JoystickButton(driverJoystick, 6);

    // connecting buttons to commands
    leftBumper.whileHeld(new ElevateClimber(climber));
    rightBumper.whileHeld(new RetractClimber(climber));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
