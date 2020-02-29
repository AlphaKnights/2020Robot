/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.turretSubsystemConstants;

public class TurretSubsystem extends SubsystemBase {
  private final WPI_TalonSRX turretRotatorMotor = new WPI_TalonSRX(turretSubsystemConstants.turretRotatorTalonID);
  
  double unitsPerDegree = 90;
  double turretMotorSpeed = 0.10;
  /**
   * Creates a new TurretSubsystem.
   */
  public TurretSubsystem() {

  }

  public void initializeSelectedSensorPosition() {
    turretRotatorMotor.setSelectedSensorPosition(0);
  }

  public void turretRotator_moveToAngle(int angle) {
    double totalUnits = angle * unitsPerDegree;
    if(turretRotatorMotor.getSelectedSensorPosition() == totalUnits) {
      turretRotatorMotor.set(0);
    }
    else if (turretRotatorMotor.getSelectedSensorPosition() > totalUnits) {
      turretRotatorMotor.set(-.1);
    }
    else if (turretRotatorMotor.getSelectedSensorPosition() < totalUnits){
      turretRotatorMotor.set(.1);
    }
    System.out.println(turretRotatorMotor.getSelectedSensorPosition() / unitsPerDegree); //print current angle
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
