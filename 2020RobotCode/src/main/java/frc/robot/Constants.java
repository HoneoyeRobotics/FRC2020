/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //can bus IDs
    public static final int CANID_PCM = 10;
    public static final int CANID_FrontLeftDriveMotor = 27;
    public static final int CANID_RearLeftDriveMotor = 28;

    public static final int CANID_FrontRightDriveMotor = 26;
    public static final int CANID_RearRightDriveMotor = 25;
    public static final int CANID_ConveyerMotor = 34;
    public static final int CANID_IntakeMotor = 33;
    public static final int CANID_ArmWheelMotor = 23;
    public static final int CANID_Spare = 22;

    //PCM relay IDS 0-7
    public static final int PCMID_ConveyerSoleniodForward = 2;
    public static final int PCMID_ConveyerSoleniodBackward = 3;
    public static final int PCMID_ControlPanelSoleniodForward = 3;
    public static final int PCMID_ContorlPanelSoleniodBackward = 5;
    public static final int PCMID_ScissorLiftForward = 0;
    public static final int PCMID_ScissorLiftBackward = 1;

    public static final int leftEncoderA = 1;
    public static final int leftEncoderB = 0;
    public static final int rightEncoderA = 4;
    public static final int rightEncoderB = 5;
}