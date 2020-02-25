/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.colorWheelConstants;

import static frc.robot.Constants.colorWheelConstants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
 
public class ColorWheelSubsystem extends SubsystemBase {
    // WPI_TalonSRX ActuatingMotor = new WPI_TalonSRX(ActuatingMotorID);
    WPI_TalonSRX RotatingMotor = new WPI_TalonSRX(RotatingMotorID);
    AnalogInput colorSensor = new AnalogInput(colorWheelConstants.colorSensorDIOChannel);
    private int color = 0;

    static ColorWheelSubsystem INSTANCE = new ColorWheelSubsystem();

    // public void Actuate(int direction) {
    //     if (direction == 1) {
    //         if (ActuatingMotor.getSelectedSensorPosition() < ColorWheelHeight) {
    //             ActuatingMotor.set(ActuatorPower);

    //         } else if (ActuatingMotor.getSelectedSensorPosition() > 0) {
    //             ActuatingMotor.set(-ActuatorPower);
    //         }
    //     }
    // }

    public void Rotate(int state) {
        if (state == 1) {
            if (RotatingMotor.getSelectedSensorPosition() < RotateDistance) {
                RotatingMotor.set(.2);
            }
        }
        else if(state == 2){
            if (colorSensor.getValue() != color) {
                RotatingMotor.set(.2);
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

    public static ColorWheelSubsystem getInstance() {
        return INSTANCE;
      }
}
