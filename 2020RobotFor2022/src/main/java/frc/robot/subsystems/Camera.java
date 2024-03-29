/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoMode;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera extends SubsystemBase {
	private UsbCamera frontCamera;
	private UsbCamera rearCamera;
	private CvSink frontCameraCvSink;
	private CvSink rearCameraCvSink;
	private boolean UseFrontCamera = true;

	public Camera() {
		frontCamera = CameraServer.startAutomaticCapture(0);
		rearCamera = CameraServer.startAutomaticCapture(1);
		frontCameraCvSink = new CvSink("cam1cv");
		frontCameraCvSink.setSource(frontCamera);
		frontCameraCvSink.setEnabled(true);

		rearCameraCvSink = new CvSink("cam2cv");
		rearCameraCvSink.setSource(rearCamera);
		rearCameraCvSink.setEnabled(true);
		SmartDashboard.putBoolean("UseFrontCamera", UseFrontCamera);
	}

	public void SwitchCamera() {

		if (UseFrontCamera == true) {
			UseFrontCamera = false;
			CameraServer.getServer().setSource(rearCamera);
			SmartDashboard.putBoolean("UseFrontCamera", UseFrontCamera);
		} else {
			UseFrontCamera = true;
			CameraServer.getServer().setSource(frontCamera);
			SmartDashboard.putBoolean("UseFrontCamera", UseFrontCamera);
		}
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
