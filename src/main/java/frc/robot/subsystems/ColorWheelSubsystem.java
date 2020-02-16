/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.colorWheelConstants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
 
public class ColorWheelSubsystem extends SubsystemBase {
    WPI_TalonSRX ActuatingMotor = new WPI_TalonSRX(ActuatingMotorID);

    public void Actuate(int direction) {
        if (direction == 1) {
            if (ActuatingMotor.() < colorWheelConstants.ColorWheelHeight) {
                ActuatingMotor.set(.2);

            } else if (ActuatingMotor.getSelectedSensorPosition() > 0) {
                ActuatingMotor.set(-.2);
            }
        }
    }

    /**
     * Creates a new ColorWheelSubsystem.
     */
    public ColorWheelSubsystem() {

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
