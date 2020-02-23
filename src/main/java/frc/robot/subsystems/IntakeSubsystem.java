/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
  // CANSparkMax actuatingMotor = new CANSparkMax(IntakeConstants.actuateMotorID, MotorType.kBrushless);
  WPI_TalonSRX IntakingMotor = new WPI_TalonSRX(IntakeConstants.intakeMotorID);
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {
      topMagneticLimitSwitch = new DigitalInput();
      bottomMagneticLimitSwitch = new DigitalInput();
      
    
  }


  void Extend(){

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
