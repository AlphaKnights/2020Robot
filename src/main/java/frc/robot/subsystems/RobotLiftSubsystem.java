/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.robotLiftSubsystem;
 

public class RobotLiftSubsystem extends SubsystemBase {
  /**
   * Creates a new RobotLiftSubsystem.
   */
  WPI_TalonSRX Scafolding = new WPI_TalonSRX(robotLiftSubsystem.ScfoldingTalonID);
  WPI_TalonSRX WinchLeft = new WPI_TalonSRX(robotLiftSubsystem.WinchLeftTalonID);
  WPI_TalonSRX WinchRight = new WPI_TalonSRX(robotLiftSubsystem.WinchRightTalonID);
  
  public RobotLiftSubsystem() {

  }

  public void LiftHooks(){
    if(Scafolding.getSelectedSensorPosition()<robotLiftSubsystem.RotationsValue){
      Scafolding.set(robotLiftSubsystem.ScfoldingSpeed);
    }
  }

  public void RetractScafolding(){
    if(Scafolding.getSelectedSensorPosition()>0){
      Scafolding.set((robotLiftSubsystem.ScfoldingSpeed)*-1);
    }
    else if(Scafolding.getSelectedSensorPosition()<=10){
      if(WinchLeft.getSelectedSensorPosition()<robotLiftSubsystem.StartLiftHeight){
        WinchLeft.set(robotLiftSubsystem.WinchingSpeed);
      }
      if(WinchRight.getSelectedSensorPosition()<robotLiftSubsystem.StartLiftHeight){
        WinchRight.set(robotLiftSubsystem.WinchingSpeed);
      }
    }
  }

  void Balance()  {

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
