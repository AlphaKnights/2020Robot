
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.IntakeConstants.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
  CANSparkMax actuatingMotor = new CANSparkMax(IntakeConstants.actuateMotorID, MotorType.kBrushless);
  WPI_TalonSRX IntakingMotor = new WPI_TalonSRX(IntakeConstants.intakeMotorID);
  DigitalInput topMagneticLimitSwitch = new DigitalInput(IntakeConstants.actuatingSensorTopDIOChannel);
  DigitalInput bottomMagneticLimitSwitch = new DigitalInput(IntakeConstants.actuatingSensorBottomDIOChannel);
  private int motorDirection = 1;
  private int intakeState = 0;
  private boolean test = true;//test for github commit
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {
      
    
  }

  void actuateIntake(){
    if(motorDirection == 1){
      if(bottomMagneticLimitSwitch.get()){
        motorDirection = motorDirection*-1;
      }
      else{
        actuatingMotor.set(.2*motorDirection);
      }
    }
    if(motorDirection == -1){
      if(topMagneticLimitSwitch.get()){
        motorDirection = motorDirection*-1;
      }
      else{
        actuatingMotor.set(.2*motorDirection);
      }
    }
  }

  void intakeChangeState(){
    //if()
  }
  
  void Extend(){

  }

  @Override
  public void periodic() {
    if(intakeState == 1){
      //IntakingMotor.set(1,1);
    }
    // This method will be called once per scheduler run
  }
}