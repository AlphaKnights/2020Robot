/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.sql.Driver;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.driveTrain;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

public class DriveTrainSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(driveTrain.leftTalonMotor1ID);
  WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(driveTrain.leftTalonMotor2ID);
  WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(driveTrain.rightTalonMotor1ID);
  WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(driveTrain.rightTalonMotor2ID);
  
  private final AHRS navX = new AHRS(SerialPort.Port.kUSB);
 
  DifferentialDrive m_driveTrain = new DifferentialDrive(new SpeedControllerGroup(leftMotor1, leftMotor2), new SpeedControllerGroup(rightMotor1, rightMotor2));
  
  static DriveTrainSubsystem INSTANCE = new DriveTrainSubsystem();

  private void DriveTrainSubsystem() {
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_driveTrain.tankDrive(leftSpeed, rightSpeed);
  }

  public void arcadeDrive(double power, double rotation) {
    m_driveTrain.arcadeDrive(power, rotation);
  }

  public double getNavXAngle() {
    return navX.getAngle();
  }

  public void setNavXZero() {
    navX.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static DriveTrainSubsystem getInstance() {
    return INSTANCE;
  }
}
