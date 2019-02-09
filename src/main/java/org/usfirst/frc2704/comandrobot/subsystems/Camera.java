package org.usfirst.frc2704.comandrobot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {
    private UsbCamera camera;
    private CameraServer server;

    public void initDefaultCommand() {}

    public Camera() {
            //camera = new UsbCamera("camera",UsbCamera.enumerateUsbCameras()[0].path);
            server = CameraServer.getInstance();
    }
    public void enableStreaming() {
            //server.addCamera(camera);
            server.startAutomaticCapture();
    }

}