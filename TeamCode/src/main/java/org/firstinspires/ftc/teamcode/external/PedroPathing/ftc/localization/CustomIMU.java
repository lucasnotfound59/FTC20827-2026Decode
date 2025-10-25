package org.firstinspires.ftc.teamcode.external.PedroPathing.ftc.localization;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;

public interface CustomIMU {
    /**
     * Initializes the IMU using the hardwareMap and hubOrientation.
     */
    void initialize(HardwareMap hardwareMap, String hardwareMapName, RevHubOrientationOnRobot hubOrientation);

    /**
     * Gets the IMU's reading for the heading of the robot in radians
     * @return the heading of the robot in radians
     */
    double getHeading();

    /**
     * Resets the IMU's yaw to 0.
     */
    void resetYaw();
}


