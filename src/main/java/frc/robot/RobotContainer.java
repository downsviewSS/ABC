// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.Constants.driverconstants;
import frc.robot.commands.Autoshooter;
import frc.robot.commands.Autoshooter2;

import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.Driveforwardtime;
import frc.robot.commands.Elevatorball;
import frc.robot.commands.Intakeball;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;

import frc.robot.subsystems.Intake;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 
  private final DriveTrain drivetrain;
  private final DriveWithJoysticks driveWithJoysticks;
  private final Command driveforwardtime;
  private final Autoshooter2 autoshooter2;
  // Replace with CommandPS4Controller or CommandJoystick if needed
  // The driver's controller
  public static PS4Controller shootercontroller;
  public static PS4Controller m_driverController;
  
  
  private final Elevator elevator;
  private final Elevatorball elevatorball;

  private final Intake intake;
  private final Intakeball intakeball;
  private final Autoshooter autoshooter;
  
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_driverController = new PS4Controller(driverconstants.kDriverControllerPort);
    shootercontroller = new PS4Controller(driverconstants.shootercontrollerPort);
    intake = new Intake();
    intakeball = new Intakeball(intake);
    intakeball.addRequirements(intake);
    intake.setDefaultCommand(intakeball);
    autoshooter = new Autoshooter(intake);
     autoshooter.addRequirements(intake);
      autoshooter2 = new Autoshooter2(intake);
      autoshooter2.addRequirements(intake);
   
      drivetrain = new DriveTrain();
      driveWithJoysticks = new DriveWithJoysticks(drivetrain);
      driveWithJoysticks.addRequirements(drivetrain);
      drivetrain.setDefaultCommand(driveWithJoysticks);
      
      driveforwardtime = new SequentialCommandGroup(
        autoshooter2, new Autoshooter(intake),
        new Driveforwardtime(drivetrain)
      );

    elevator = new Elevator();
    elevatorball = new Elevatorball(elevator);
    elevatorball.addRequirements(elevator);
    elevator.setDefaultCommand(elevatorball);

// Auto commands for shooting and driving


    
    

    





      UsbCamera camera2UsbCamera = CameraServer.startAutomaticCapture();
      camera2UsbCamera.setResolution(230, 230);



    // Configure the trigger bindings
    configureBindings(); 
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return driveforwardtime;
  }
}
