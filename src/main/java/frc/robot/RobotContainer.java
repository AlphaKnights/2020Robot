/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OI_Constants;
import frc.robot.Constants.robotLiftSubsystem;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LowerLift;
import frc.robot.commands.RiseLift;
import frc.robot.commands.TankDriveCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.RobotLiftSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrainSubsystem m_DriveTrainSubsystem = DriveTrainSubsystem.getInstance();
  private final TankDriveCommand m_TankDriveCommand = new TankDriveCommand(m_DriveTrainSubsystem);
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final Joystick m_Joystick = new Joystick(OI_Constants.joystickPort);
  private final JoystickButton m_driveButton = new JoystickButton(m_Joystick, OI_Constants.driveJoystickButtonID);
  private final ArcadeDriveCommand m_ArcadeDriveCommand = new ArcadeDriveCommand(m_DriveTrainSubsystem);
  private final JoystickButton m_liftButton = new JoystickButton(m_Joystick, robotLiftSubsystem.liftJoystickButtonID);
  private final RobotLiftSubsystem m_RobotLiftSubsystem = new RobotLiftSubsystem();
  private final RiseLift m_RiseLiftCommand = new RiseLift(m_RobotLiftSubsystem);
  private final LowerLift m_LowerLiftCommand = new LowerLift(m_RobotLiftSubsystem);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_DriveTrainSubsystem.setDefaultCommand(m_ArcadeDriveCommand);
    m_liftButton.whenHeld(m_RiseLiftCommand);
    m_liftButton.whenReleased(m_LowerLiftCommand);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
