// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
 import frc.robot.RobotContainer;
 import frc.robot.Constants.Intakeconstants;
 import frc.robot.subsystems.Intake;

 public class Intakeball extends Command {
  /** Creates a new Intakeball. */
   Intake intake;
   public Intakeball(Intake i) {
    intake = i;
     addRequirements(intake);
     // Use addRequirements() here to declare subsystem dependencies.
   }

  // Called when the command is initially scheduled.
   @Override
  public void initialize() {
    
  }

   // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {intake.intakeball(RobotContainer.shootercontroller,Intakeconstants.intakespeed);}

//   // Called once the command ends or is interrupted.
//   @Override
  public void end(boolean interrupted) {
    intake.stop();
  }

//   // Returns true when the command should end.
//   @Override
  public boolean isFinished() {
   return false;
   }
 }
