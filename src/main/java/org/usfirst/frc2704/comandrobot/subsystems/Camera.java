package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.cscore.*;


public class Camera extends Subsystem {
    private CameraServer server;
    private UsbCamera camera;

    public void initDefaultCommand() {}

    public Camera() {
            
            server = CameraServer.getInstance();
            enableStreaming();
    }
    public void enableStreaming() {
        camera = server.startAutomaticCapture();
        camera.setResolution(640, 480);
    }

}