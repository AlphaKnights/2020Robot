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
  WPI_TalonSRX Talon1 = new WPI_TalonSRX(robotLiftSubsystem.Talon1);
  WPI_TalonSRX Talon2 = new WPI_TalonSRX(robotLiftSubsystem.Talon2);
  WPI_TalonSRX Talon3 = new WPI_TalonSRX(robotLiftSubsystem.Talon3);
  
  public RobotLiftSubsystem() {

  }

  void extendArm(){
  Talon1.set(0.3);
  }

  void liftUp()  { 

  }

  void unextendArm()  {

  }

  void goDown()  {

  }

  void balance()  {

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
