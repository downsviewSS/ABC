// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class elevatorconstants {
    public static final int elevator = 7;  // Sparkmax for elevator
    public static final double elevatorspeed = 0.8;
    
    public static final int elevatorstick = 0;  // y-axis for shooter joystick
  }

  public static class driverconstants{

    public static final int Left_Front = 40;
    public static final int Right_Front = 30;
    public static final int Left_Back = 43;
    public static final int Right_Back = 33;
    public static final int kDriverControllerPort = 0;
    public static final int shootercontrollerPort = 1;
    public static final int yaxis = 1;
    public static final int xaxis = 0;
    public static final double drivespeed = 1.00;


  }
  public static class AutoConstants {
// auto shooter information
    public static final double autotimer_shooter = 3;
    public static final double autospeed = -1;
    public static final double autospeed2=-1.0;

//auto driving information 
    public static final double autotimer_driving = 2;
    public static final double autodrivespeed = 0.55;
  }

  public static class Intakeconstants {
    public static final int intake2CanSparkMax = 6;// sparkmax for intake rear motor
    public static final int intakeCanSparkMax = 5; // sparkmax for intake front motor
    public static final int intaketriger = 4;  // x-axis for shooter joytsick back motor
    public static final double intakespeed = 1.0;
    public static final int intaketriger2 = 1;  // axis for front motor
    


  }
}
