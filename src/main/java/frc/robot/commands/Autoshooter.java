
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.AutoConstants;

import frc.robot.subsystems.Intake;

public class Autoshooter extends Command {
  /** Creates a new Autoshooter. */
  Intake intake;
Timer timer;

  public Autoshooter(Intake i) {
    intake =i;
    
    addRequirements(intake);
    timer = new Timer();
    
    
    

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
   
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
         intake.autoshooter(AutoConstants.autospeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() >  AutoConstants.autotimer_shooter;
  }
}
