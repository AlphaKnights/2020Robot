/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not public final int Jacksgirlfirends = 0 be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class colorWheelConstants{
        public final static double ActuatorPower = .2;
        public final static double RotatingPower = .2;
        public final static int ActuatingMotorID = 0;
        public final static int RotatingMotorID = 1;
        public final static int ColorWheelRadius = 16; // in inches
        public final static int MotorWheelRadius = 2; // in inches
        public final static int EncoderValuePerRotation = 4096;
        public final static int EncoderValuePerColorWheelRotation = (ColorWheelRadius/MotorWheelRadius)*EncoderValuePerRotation;
        public final static int AmountOfRotations = 4;
        public final static int RotateDistance = EncoderValuePerColorWheelRotation*AmountOfRotations;// rotates color wheel 4 times
        public final static int ColorWheelHeight = 8492;// rotates roughly 2 revs
        public final static int RotationDistance = 8492;// rotates roughly 2 revs
        public final static int colorSensorDIOChannel = 0;
        public final static String sensorColorValueBlue = "Blue";//fix this value when we can test this
        public final static String sensorColorValueYellow = "Yellow";//fix this value when we can test this
        public final static String sensorColorValueRed = "Red";//fix this value when we can test this
        public final static String sensorColorValueGreen = "Green";//fix this value when we can test this
        public final static String sensorColorNeeded = sensorColorValueBlue;//change this based off of color needed
    }
    public final class OI_Constants{
        public static final int joystickPort = 0;
        public static final int driveJoystickButtonID = 3;
    }

    public final class IntakeConstants{
        public static final int actuateMotorID = 0;
        public static final int intakeMotorID = 1;
    }

    public final class driveTrain{
        public static final int leftTalonMotor1ID = 0;
        public static final int leftTalonMotor2ID = 1;
        public static final int rightTalonMotor1ID = 2;
        public static final int rightTalonMotor2ID = 3;
        public static final int x_axis = 0;
        public static final int y_axis = 1;
    }
    
    public final class turretSubsystemConstants {
        public static final int turretRotatorTalonID = 0;
    }

    public final class robotLiftSubsystem{
        public static final double ScfoldingSpeed = 0.3;
        public static final double WinchingSpeed = 0.2;
        public static final int ScfoldingTalonID = 0;
        public static final int WinchLeftTalonID = 1;
        public static final int WinchRightTalonID = 2;
        public static final int OneRotationValue = 4096;
        public static final int ScafoldingRotationsToTop = 8;
        public static final int RotationsValue = OneRotationValue*ScafoldingRotationsToTop;
        public static final int RotationsToStart = 2;
        public static final int StartLiftHeight = RotationsToStart*OneRotationValue;
        public static final int liftJoystickButtonID = 1;
    }

}
