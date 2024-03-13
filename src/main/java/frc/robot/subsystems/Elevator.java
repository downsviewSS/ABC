// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.elevatorconstants;

public class Elevator extends SubsystemBase {
 
/** Creates a new Elevator. */

  private final CANSparkMax m_elevatorSparkMax;
  public Elevator() {
     m_elevatorSparkMax = new CANSparkMax(elevatorconstants.elevator, MotorType.kBrushless);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void elevatorball(PS4Controller shootercontroller, double speed) {
    m_elevatorSparkMax.set(shootercontroller.getRawAxis(elevatorconstants.elevatorstick)*speed);

    

  }
  public void stop(){
    m_elevatorSparkMax.set(0);
  }
}
