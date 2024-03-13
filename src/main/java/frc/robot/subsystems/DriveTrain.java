// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.driverconstants;



public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */

  
 
  CANSparkMax Leftfront = new CANSparkMax (driverconstants.Left_Front, MotorType.kBrushless);
    CANSparkMax Rightfront = new CANSparkMax (driverconstants.Right_Front, MotorType.kBrushless);
    CANSparkMax Leftback = new CANSparkMax (driverconstants.Left_Back, MotorType.kBrushless); 
    CANSparkMax Rightback = new CANSparkMax (driverconstants.Right_Back, MotorType.kBrushless);
    
 public DifferentialDrive drive = new DifferentialDrive(Leftback, Rightback);
 
 public DriveTrain() {
        Leftback.setInverted(true);

    Leftfront.follow(Leftback); 
     Rightfront.follow(Rightback);
   

      
    };

    public void driveWithJoystick (PS4Controller m_driverPs4Controller,  double speed){
      drive.arcadeDrive(m_driverPs4Controller.getRawAxis(driverconstants.yaxis)*speed, m_driverPs4Controller.getRawAxis(driverconstants.xaxis)*speed );
      
    }

public void driveforwad(double speed){
  drive.tankDrive(speed, speed);
  
}

public void stop() {
  drive.stopMotor();
  drive.stopMotor();
}


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
