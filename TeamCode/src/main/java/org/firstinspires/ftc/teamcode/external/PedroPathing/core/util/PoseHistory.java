package org.firstinspires.ftc.teamcode.external.PedroPathing.core.util;

import org.firstinspires.ftc.teamcode.external.PedroPathing.core.localization.PoseTracker;

/**
 * This is the PoseHistory class. This tracks the pose history of the robot through a
 * PoseTracker, adding to the pose history at specified increments of time and storing the history
 * for a specified length of time.
 *
 * @author Anyi Lin - 10158 Scott's Bots
 * @version 1.0, 5/13/2024
 */
public class PoseHistory {
    private double[] xPositions;
    private double[] yPositions;
    private PoseTracker poseUpdater;
    private long lastUpdateTime;
    private final int TRACKING_LENGTH = 1500;
    private final long UPDATE_TIME = 50;
    private final int TRACKING_SIZE = TRACKING_LENGTH / (int) UPDATE_TIME;

    /**
     * This creates a new PoseHistory from a PoseTracker.
     *
     * @param poseUpdater the PoseTracker
     */
    public PoseHistory(PoseTracker poseUpdater) {
        this.poseUpdater = poseUpdater;
        xPositions = new double[TRACKING_SIZE];
        yPositions = new double[TRACKING_SIZE];

        for (int i = 0; i < TRACKING_SIZE; i++) {
            xPositions[i] = poseUpdater.getPose().getX();
            yPositions[i] = poseUpdater.getPose().getY();
        }

        lastUpdateTime = System.currentTimeMillis() - UPDATE_TIME;
    }

    /**
     * This updates the PoseHistory. When the specified update time has passed from the last
     * pose history log, another pose can be logged. The least recent log is also removed.
     */
    public void update() {
        if (System.currentTimeMillis() - lastUpdateTime > UPDATE_TIME) {
            lastUpdateTime = System.currentTimeMillis();
            for (int i = TRACKING_SIZE - 1; i > 0; i--) {
                xPositions[i] = xPositions[i - 1];
                yPositions[i] = yPositions[i - 1];
            }
            xPositions[0] = poseUpdater.getPose().getX();
            yPositions[0] = poseUpdater.getPose().getY();
        }
    }

    /**
     * This returns the x positions of the pose history as an Array of doubles.
     *
     * @return returns the x positions of the pose history
     */
    public double[] getXPositionsArray() {
        return xPositions;
    }

    /**
     * This returns the y positions of the pose history as an Array of doubles.
     *
     * @return returns the y positions of the pose history
     */
    public double[] getYPositionsArray() {
        return yPositions;
    }
}
