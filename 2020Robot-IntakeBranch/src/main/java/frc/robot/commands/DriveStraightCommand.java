/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveStraightCommand extends CommandBase {
  
  Joystick throttleJoystick;
  JoystickButton straightButton;
  
  DriveTrainSubsystem driveTrainSubSystem;

  boolean notSimpleStraightMode = true;

  /**
   * Creates a new DriveStraightCommand.
   */
  public DriveStraightCommand(DriveTrainSubsystem driveTrainSubsystem, Joystick throttleJoystick, JoystickButton straightButton) {
    // Use addRequirements() here to declare subsystem dependencies.
    
    this.throttleJoystick = throttleJoystick;
    this.straightButton = straightButton;
    this.driveTrainSubSystem = driveTrainSubSystem;

    addRequirements(driveTrainSubSystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrainSubSystem.setNavXZero();

    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (straightButton.get()) {
      if (notSimpleStraightMode) {
        driveTrainSubSystem.setNavXZero();
        notSimpleStraightMode = false;
      }

    }







  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
