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
  private static final ControlPanel ControlPanel = new ControlPanel();
  private final DriveTrain m_drivetrain = new DriveTrain();
  // The robot's subsystems and commands are defined here...
  // private final ControlPanel m_ControlPanel = new Subsystem();
  private final Joystick driverJoystick = new Joystick(0);
  private final Joystick pilotJoystick = new Joystick(1);
  // private final JoystickButton m_RunControlPanelArmWheel = new
  // JoystickButton(pilotJoystick, 0); // button A, check button id
  // private final Autonomous m_autonomousCommand = new Autonomous();
  private final ArcadeDrive m_autoCommand = new ArcadeDrive(null, null, m_drivetrain);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_drivetrain.setDefaultCommand(new ArcadeDrive(() -> driverJoystick.getRawAxis(1) * -1,
        () -> driverJoystick.getRawAxis(2) - driverJoystick.getRawAxis(3), m_drivetrain));
    // Show what command your subsystem is running on the SmartDashboard
    SmartDashboard.putData(m_drivetrain);

    // Call log method on all subsystems
    m_drivetrain.log();

    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // buttons for pilot joystick
    final JoystickButton aButton = new JoystickButton(pilotJoystick, 1);
    final JoystickButton bButton = new JoystickButton(pilotJoystick, 2);
    final JoystickButton xButton = new JoystickButton(pilotJoystick, 3);
    // Connect the buttons to commands
    aButton.toggleWhenPressed(new RunControlPanelArmWheel(ControlPanel));
    bButton.toggleWhenPressed(new IncreaseControlPanelArmWheelSpeed(ControlPanel));
    xButton.toggleWhenPressed(new DecreaseControlPanelArmWheelSpeed(ControlPanel));
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
