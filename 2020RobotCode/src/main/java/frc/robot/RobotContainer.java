/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;

//import java.util.ResourceBundle.Control;

//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.controller.*;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
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
  // private final ControlPanel controlPanel;
  private final DriveTrain drivetrain;
  private final Climber climber;
  private final PowercellSystem powerCellSystem;
  // private final Joystick leftDriverJoystick = new Joystick(0);
  // private final Joystick rightDriverJoystick = new Joystick(1);
  private final Joystick driverJoystick = new Joystick(0);
  private final Joystick coPilotjoystick = new Joystick(2);
  private final UsbCamera usbCamera;

  // private final JoystickButton m_RunControlPanelArmWheel = new
  // JoystickButton(coPilotjoystick, 0); // button A, check button id
  // private final Autonomous m_autonomousCommand = new Autonomous();
  private final ArcadeDrive m_autoCommand;
  final JoystickButton stephenModeButton = new JoystickButton(driverJoystick, 8);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // construct subsystems
    drivetrain = new DriveTrain();
    climber = new Climber();
    // controlPanel = new ControlPanel();u
    powerCellSystem = new PowercellSystem();

    ArcadeDrive arcadeDrive = new ArcadeDrive(() -> driverJoystick.getRawAxis(1) * -1,
        () -> driverJoystick.getRawAxis(3) - driverJoystick.getRawAxis(2), () -> stephenModeButton.get(), drivetrain);
    drivetrain.setDefaultCommand(arcadeDrive);
    // controlPanel.setDefaultCommand(new
    // ControlPanelColorVisionTracking(controlPanel));

    // drivetrain.setDefaultCommand(new TankDrive(() ->
    // leftDriverJoystick.getRawAxis(1) * -1,
    // () -> rightDriverJoystick.getRawAxis(1) * -1, drivetrain));
    // controlPanel.setDefaultCommand(new
    // ControlPanelColorVisionTracking(controlPanel));

    // Show what command your subsystem is running on the SmartDashboard
    SmartDashboard.putData(powerCellSystem);
    SmartDashboard.putData(drivetrain);
    // SmartDashboard.putData(controlPanel);
    SmartDashboard.putData(new ResetOdometry(drivetrain));
    SmartDashboard.putData(new DriveForward(drivetrain, 2));
    SmartDashboard.putData(new RotateDrive(drivetrain, 90));
    // SmartDashboard.putData(new AutoTest1(drivetrain));
    SmartDashboard.putData(new AutoPathFinderTest(drivetrain));
    // SmartDashboard.putData(new AutoManualTest(drivetrain));
    SmartDashboard.putData(new RaiseConveyerDashboard(powerCellSystem));
    SmartDashboard.putData(new LowerConveyerDashboard(powerCellSystem));
    SmartDashboard.putData(new StoreArm(powerCellSystem));
    SmartDashboard.putData(new DeployArm(powerCellSystem));
    // Call log method on all subsystems
    m_autoCommand = new ArcadeDrive(null, null, null, drivetrain);

    // Configure the button bindings
    configurePilotButtonBindings();
    configureDriverButtonBindings();

    usbCamera = CameraServer.getInstance().startAutomaticCapture();
    usbCamera.setVideoMode(PixelFormat.kMJPEG, 320, 240, 30);

    powerCellSystem.setArmUp(true);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configurePilotButtonBindings() {
    // buttons for pilot joystick
    // final JoystickButton aButton = new JoystickButton(coPilotjoystick, 1);
    // final JoystickButton bButton = new JoystickButton(coPilotjoystick, 2);
    // final JoystickButton xButton = new JoystickButton(coPilotjoystick, 3);
    // final JoystickButton yButton = new JoystickButton(coPilotjoystick, 4);
    final JoystickButton leftBumper = new JoystickButton(coPilotjoystick, 5);
    final JoystickButton rightBumper = new JoystickButton(coPilotjoystick, 6);
    final JoystickButton backButton = new JoystickButton(coPilotjoystick, 7);
    final JoystickButton startButton = new JoystickButton(coPilotjoystick, 8);

    // Connect the buttons to commands
    //leftBumper.whileHeld(new GatherPowerCellsAfterDeployArm(powerCellSystem));
    leftBumper.whileHeld(new GatherPowercells(powerCellSystem));
    rightBumper.whileHeld(new DepositPowercells(powerCellSystem));
    // aButton.toggleWhenPressed(new RunControlPanelArmWheel(controlPanel, () ->
    // false, () -> false));
    // leftBumper.whileHeld(new ExtendControlPanelArm(controlPanel));
    // rightBumper.whileHeld(new RetractControlPanelArm(controlPanel));
    startButton.whileHeld(new ElevateClimber(climber));
    backButton.whileHeld(new RetractClimber(climber));
  }

  private void configureDriverButtonBindings() {
    // bubttons being used on controller
      final JoystickButton aButton = new JoystickButton(driverJoystick, 1);
      final JoystickButton bButton = new JoystickButton(driverJoystick, 2);
      // final JoystickButton leftBumper = new JoystickButton(driverJoystick, 5);
      // final JoystickButton rightBumper = new JoystickButton(driverJoystick, 6);
      // final JoystickButton backButton = new JoystickButton(driverJoystick, 7);
      // final JoystickButton startButton = new JoystickButton(driverJoystick, 8);


    // buttons assigned to commands
      aButton.whileHeld(new EngageExtraLift(climber));
      bButton.whileHeld(new DisengageExtraLift(climber));
      // leftBumper.whileHeld(new GatherPowercells(powerCellSystem));
      // rightBumper.whileHeld(new DepositPowercells(powerCellSystem));
      // startButton.whileHeld(new ElevateClimber(climber));
      // backButton.whileHeld(new RetractClimber(climber));
  }

  public void teleopInit() {

    // ConveyerPistonInitilize ConveyerPistonInitilize = new
    // ConveyerPistonInitilize(powerCellSystem);
    // ConveyerPistonInitilize.withTimeout(0.2).schedule(true);
  }

  public void teleopDisable(){
    if(climber.isExtraLiftEngaged())
      climber.DisengageExtraLift();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new AutoManualTest(drivetrain);
  }

}