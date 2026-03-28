package frc.robot.commands;

import static frc.robot.Constants.ClimbConstatns.*;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.climb.ClimberSubsystem;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.fuel.CANFuelSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ExampleAuto extends SequentialCommandGroup {
  /** Creates a new ExampleAuto. */
  public ExampleAuto(
      Drive driveSubsystem, CANFuelSubsystem ballSubsystem, ClimberSubsystem climberSubsystem) {
    /**
     * addCommands( new ClimbDown(climberSubsystem).withTimeout(3), // 3 Seconds. Climb Down Hooks
     * in Seconds. new AutoDrive(driveSubsystem, 2.75, 0.0).withTimeout(3.2), // 2.75 m/s new
     * LaunchSequence(ballSubsystem).withTimeout(5), new WaitCommand(4.75), // Wait 4.75 seconds to
     * put Climb at End Of Auto to Look Super Cool. new ClimbUp(climberSubsystem)
     * .withTimeout(3.5)); // 3.5 Seconds. Climber Up Hooks to Climb tower in Seconds. }
     */
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
        new ClimbDown(climberSubsystem), // 3 Seconds. Climb Down Hooks in Seconds.
        new LaunchSequence(ballSubsystem).withTimeout(4),
        new WaitCommand(4.75), // Wait 4.75 seconds to put Climb at End Of Auto to Look Super Cool.
        new ClimbUp(climberSubsystem)
            .withTimeout(4)); // 3.5 Seconds. Climber Up Hooks to Climb tower in Seconds.
  }
}
