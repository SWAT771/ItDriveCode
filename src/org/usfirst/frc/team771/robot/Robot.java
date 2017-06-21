package org.usfirst.frc.team771.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Joystick djoystick;
    CANTalon fltalon;
    CANTalon frtalon;
    CANTalon bltalon;
    CANTalon brtalon;
    CANTalon mltalon;
    CANTalon mrtalon;
    
    public void robotInit() {
        
/*    CANTalon drivetalon[] = new CANTalon[6];
        for(int i = 1; i < 6; i++){
            drivetalon[i] = new CANTalon(i + 1);        }
*/
        
        djoystick = new Joystick(1);
        fltalon = new CANTalon(1);
        frtalon = new CANTalon(2);
        bltalon = new CANTalon(3);
        brtalon = new CANTalon(4);
        mltalon = new CANTalon(5);
        mrtalon = new CANTalon(6);
    }
    
    public void autonomousInit() {
        
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    
    public void teleopPeriodic() {
        mainDriveCommand(1);
    }
    
    public void mainDriveCommand(double factor) {
        double x = (double) -djoystick.getY();
        double y = (double) djoystick.getX();
//        double z1 = (double) djoystick.getThrottle();
//        double z2 = (double) djoystick.getZ();
        
        double leftMotorValue = leftMotorCalculations(x, y);
        double rightMotorValue = rightMotorCalculations(x, y);
        leftMotorSet(leftMotorValue, factor);
        rightMotorSet(rightMotorValue, factor);
//        middleMotorSet((z2-z1), factor);   
    }  

    public void rightMotorSet(double value, double factor) {
        fltalon.set(-value * factor);
        bltalon.set(-value * factor);
        mltalon.set(-value * factor);
    }

    public void leftMotorSet(double value, double factor) {
        frtalon.set(value * factor);
        brtalon.set(value * factor);
        mrtalon.set(value * factor);
    }

//    public void middleMotorSet(double value, double factor){
//        middleMotor.set(value * factor); //setting the middle motor
//    }

    public double leftMotorCalculations(double x, double y) {
        if (x <= 0.08 && x >= -0.08) {
            x = 0;
        }
        if (y <= 0.08 && y >= -0.08) {
            y = 0;
        }
        return (y * y * y + x * x * x);
    }

    public double rightMotorCalculations(double x, double y) {
        if (x <= 0.08 && x >= -0.08) {
            x = 0;
        }
        if (y <= 0.08 && y >= -0.08) {
        }
        return (-y * y * y + x * x * x);
    }
    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
    }
}