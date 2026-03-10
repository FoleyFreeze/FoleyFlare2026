// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.fuel.CANFuelSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ExampleAuto extends SequentialCommandGroup {
  /** Creates a new ExampleAuto. */
  public ExampleAuto(Drive driveSubsystem, CANFuelSubsystem ballSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
        // Drive backwards for 3 seconds. The driveArcadeAuto command factory
        // intentionally creates a command which does not end which allows us to control
        // the timing using the withTimeout decorator
        new AutoDrive(driveSubsystem, 0.1, 0.0).withTimeout(3), // was 0.5, 0.0
        // Spin up the launcher for 0.75 second and then launch balls for 9.25 seconds, for a
        // total of 10 seconds
        new LaunchSequence(ballSubsystem).withTimeout(10));
  }
}
