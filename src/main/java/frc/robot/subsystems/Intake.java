// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
 import com.revrobotics.CANSparkLowLevel.MotorType;

  import edu.wpi.first.wpilibj.PS4Controller;
  import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.Intakeconstants;

   public class Intake extends SubsystemBase {
    /** Creates a new Intake. */
     private final CANSparkMax frontintakeCanSparkMax;
     private final CANSparkMax backintakeCanSparkKMax;
   public Intake() {
     frontintakeCanSparkMax = new CANSparkMax(Intakeconstants.intakeCanSparkMax, MotorType.kBrushed);
     backintakeCanSparkKMax = new CANSparkMax(Intakeconstants.intake2CanSparkMax, MotorType.kBrushed);
     backintakeCanSparkKMax.setInverted(true);
     frontintakeCanSparkMax.setInverted(true);
  }

  
  public void intakeball(PS4Controller shootercontroller, double speed){
    frontintakeCanSparkMax.set(shootercontroller.getRawAxis(Intakeconstants.intaketriger2)*speed);
    backintakeCanSparkKMax.set(shootercontroller.getRawAxis(Intakeconstants.intaketriger)*speed);
  }

 
public void autoshooter(double speed){
    
    
frontintakeCanSparkMax.set(speed);
backintakeCanSparkKMax.set(speed);
}
public void autoshooter2(double speed){
 frontintakeCanSparkMax.set(speed);     

}

public void periodic() {
//     // This method will be called once per scheduler run

 }
 public void stop (){
   frontintakeCanSparkMax.set(0);
    backintakeCanSparkKMax.set(0);
  }

 
  }
