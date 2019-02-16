package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {
    private CameraServer server;

    public void initDefaultCommand() {}

    public Camera() {
            server = CameraServer.getInstance();
            enableStreaming();
    }
    public void enableStreaming() {
            server.startAutomaticCapture();
    }

}