package frc.robot.subsystems.climb;

import static frc.robot.Constants.ClimbConstatns.*;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.revrobotics.PersistMode; // WAS import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.ResetMode; // WAS import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {
  private final SparkMax climberMotor;
  private final CANBus bus = new CANBus("Default Name");
  private final Pigeon2 climberPigeon2 = new Pigeon2(20, bus); // 20 is the CAN ID
  private final StatusSignal<Double> xgravSignal = climberPigeon2.getGravityVectorX();
  private final StatusSignal<Double> ygravSignal = climberPigeon2.getGravityVectorY();
  private final StatusSignal<Double> zgravSignal = climberPigeon2.getGravityVectorZ();

  /** Creates a new CANBallSubsystem. */
  public ClimberSubsystem() {
    // create brushed motors for each of the motors on the launcher mechanism
    climberMotor = new SparkMax(CLIMBER_MOTOR_ID, MotorType.kBrushless);

    // create the configuration for the climb moter, set a current limit and apply
    // the config to the controller
    SparkMaxConfig climbConfig = new SparkMaxConfig();
    climbConfig.smartCurrentLimit(CLIMBER_MOTOR_CURRENT_LIMIT);
    climbConfig.idleMode(IdleMode.kBrake);
    climberMotor.configure(
        climbConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public double climberAngle() {

    // Get gravity vector components
    boolean connected =
        BaseStatusSignal.refreshAll(xgravSignal, ygravSignal, zgravSignal).equals(StatusCode.OK);
    double x = (xgravSignal.getValueAsDouble());
    double y = (ygravSignal.getValueAsDouble());
    double z = (zgravSignal.getValueAsDouble());

    SmartDashboard.putNumber("zgrav", z);
    SmartDashboard.putNumber("xgrav", y);

    return (Math.toDegrees(Math.atan2(z, y)));
  }

  // A method to set the percentage of the climber
  public void setClimber(double power) {
    climberMotor.set(power);
  }

  // A method to stop the climber
  public void stop() {
    climberMotor.set(0);
  }

  @Override
  public void periodic() {

    SmartDashboard.putNumber("climber angle", climberAngle());

    // This method will be called once per scheduler run
  }
}
