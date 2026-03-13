// Copyright (c) 2021-2026 Littleton Robotics
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by a BSD
// license that can be found in the LICENSE file
// at the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * This class defines the runtime mode used by AdvantageKit. The mode is always "real" when running
 * on a roboRIO. Change the value of "simMode" to switch between "sim" (physics sim) and "replay"
 * (log replay from a file).
 */
public final class Constants {
  public static final Mode simMode = Mode.SIM;
  public static final Mode currentMode = RobotBase.isReal() ? Mode.REAL : simMode;

  public static enum Mode {
    /** Running on a real robot. */
    REAL,

    /** Running a physics simulator. */
    SIM,

    /** Replaying from a log file. */
    REPLAY
  }

  public static final class DriveConstants {
    // Motor controller IDs for drivetrain motors
    public static final int LEFT_LEADER_ID = 1;
    public static final int LEFT_FOLLOWER_ID = 3;
    public static final int RIGHT_LEADER_ID = 2;
    public static final int RIGHT_FOLLOWER_ID = 4;

    // Current limit for drivetrain motors. 60A is a reasonable maximum to reduce
    // likelihood of tripping breakers or damaging CIM motors
    public static final int DRIVE_MOTOR_CURRENT_LIMIT = 60;
  }

  public static final class FuelConstants {
    // Motor controller IDs for Fuel Mechanism motors
    public static final int LEFT_INTAKE_LAUNCHER_MOTOR_ID = 14; // 5;
    public static final int RIGHT_INTAKE_LAUNCHER_MOTOR_ID = 17; // 6;
    public static final int INDEXER_MOTOR_ID = 12; // 8;

    // Current limit for fuel mechanism motors.
    public static final int INDEXER_MOTOR_CURRENT_LIMIT = 80;
    public static final int LAUNCHER_MOTOR_CURRENT_LIMIT = 80;

    // All values likely need to be tuned based on your robot
    public static final double INDEXER_INTAKING_PERCENT = -0.4; // -.8;
    public static final double INDEXER_LAUNCHING_PERCENT = 0.2; // 0.6;
    public static final double INDEXER_SPIN_UP_PRE_LAUNCH_PERCENT = -0.15; // -0.5;

    public static final double INTAKE_INTAKING_PERCENT = 0.2; // 0.6;
    public static final double LAUNCHING_LAUNCHER_PERCENT = 0.75; // .85;
    public static final double INTAKE_EJECT_PERCENT = -0.35; // -0.8;

    public static final double SPIN_UP_SECONDS = 0.75;
  }

  public static final class ClimbConstatns {
    // Motor controller IDs for Climb motor
    public static final int CLIMBER_MOTOR_ID = 16; // 7;

    // Current limit for climb motor
    public static final int CLIMBER_MOTOR_CURRENT_LIMIT = 40;
    // Percentage to power the motor both up and down
    public static final double CLIMBER_MOTOR_DOWN_PERCENT = -0.8;
    public static final double CLIMBER_MOTOR_UP_PERCENT = 0.8;
  }

  public static final class OperatorConstants {

    // Port constants for driver and operator controllers. These should match the
    // values in the Joystick tab of the Driver Station software
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;

    // This value is multiplied by the joystick value when rotating the robot to
    // help avoid turning too fast and beign difficult to control
    public static final double DRIVE_SCALING = 0.7;
    public static final double ROTATION_SCALING = 0.8;
  }
}
