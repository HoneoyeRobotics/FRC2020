/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Sample program displaying the value of a quadrature encoder on the SmartDashboard. Quadrature
 * Encoders are digital sensors which can detect the amount the encoder has rotated since starting
 * as well as the direction in which the encoder shaft is rotating. However, encoders can not tell
 * you the absolute position of the encoder shaft (ie, it considers where it starts to be the zero
 * position, no matter where it starts), and so can only tell you how much the encoder has rotated
 * since starting. Depending on the precision of an encoder, it will have fewer or greater ticks per
 * revolution; the number of ticks per revolution will affect the conversion between ticks and
 * distance, as specified by DistancePerPulse. One of the most common uses of encoders is in the
 * drivetrain, so that the distance that the robot drives can be precisely controlled during the
 * autonomous mode.
 */
public class Robot extends TimedRobot {
  /**
   * The Encoder object is constructed with 4 parameters, the last two being optional. The first two
   * parameters (1, 2 in this case) refer to the ports on the roboRIO which the encoder uses.
   * Because a quadrature encoder has two signal wires, the signal from two DIO ports on the roboRIO
   * are used. The third (optional)  parameter is a boolean which defaults to false. If you set this
   *  parameter to true, the direction of the encoder will be reversed, in case it makes more sense
   * mechanically. The final (optional) parameter specifies encoding rate (k1X, k2X, or k4X) and
   * defaults to k4X. Faster (k4X) encoding gives greater positional precision but more noise in the
   * rate.
   */


  //private static final double cpr = 7/4; //if am-2861a
  private static final double cpr = 360; //if am-3132
  // private static final double cpr = 5; //if am-3314a
  // private static final double cpr = 1024; //if am-3445
  // private static final double cpr = 64; //if am-4027

  private static final double whd = 6; // for 6 inch wheel

  private final Encoder m_encoder1 = new Encoder(1,0);//, false, CounterBase.EncodingType.k4X);
  private final Encoder m_encoder2 = new Encoder(3,2);//, false, CounterBase.EncodingType.k4X);

  @Override
  public void robotInit() {
    m_encoder1.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)
    m_encoder2.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)

  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Encoder 1 Distance", m_encoder1.getDistance());
    SmartDashboard.putNumber("Encoder 1 Value", m_encoder1.get());

    SmartDashboard.putNumber("Encoder 2 Distance", m_encoder2.getDistance());
    SmartDashboard.putNumber("Encoder 2 Value", m_encoder2.get());
  }
}
