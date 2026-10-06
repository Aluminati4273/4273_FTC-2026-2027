package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

public class Mecanum {
    public DcMotor fl;
    public DcMotor fr;
    public DcMotor bl;
    public DcMotor br;
    public void init(HardwareMap hwMap) {
        fl = hwMap.get(DcMotor.class, "Front_Left");
        fr = hwMap.get(DcMotor.class, "Front_Right");
        bl = hwMap.get(DcMotor.class, "Back_Left");
        br = hwMap.get(DcMotor.class, "Back_Right");

        fr.setDirection(DcMotor.Direction.REVERSE);
        br.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.FORWARD);
        bl.setDirection(DcMotor.Direction.FORWARD);
    }

    public void playerDrive(double inputX, double inputY, double inputTurn) {
//user Inputs
        double x = inputX;
        double y = -inputY;
        double turn = inputTurn;

// Turning the imports into actual movement
        double theta = Math.atan2(y, x);
        double power = Math.hypot(x, y);
        double sin = Math.sin(theta - Math.PI / 4);
        double cos = Math.cos(theta - Math.PI / 4);
        double max = Math.max(Math.abs(sin), Math.abs(cos));
//This is the conversion to motors currently we need to create the names for the motors

        double leftFront = power * cos / max - turn;
        double rightFront = power * sin / max + turn;
        double leftBack = power * sin / max - turn;
        double rightBack = power * cos / max + turn;

// This is because some of the motors will go over 1 so to stop that this if statement is there.
        // Don't worry all the wheel stuff is here.


        if ((power + Math.abs(turn)) > 1) {
            leftFront /= power - turn;
            rightFront /= power + turn;
            leftBack /= power - turn;
            rightBack /= power + turn;
        }

            //This will set the direction and power to the motors
        fl.setPower(leftFront);
        fr.setPower(rightFront);
        bl.setPower(leftBack);
        br.setPower(rightBack);
    }
    //For this section It is Important to
    // know that the values for the speeds have to be between 0-1
    //If above the value 1 it won't work; negatives will have the opposite effect
    // than intendedand, also below -1 will also stop wo

    //My hope with this is to make the robot turn 90 degrees. will need to be paired with a -
    //Time so that it will actually turn 90 degrees. Input time found from testing here:
    public void turnLeft(double speed){
        this.playerDrive(0,0,-speed);
    }

    //Input time found from testing here along with corrisponding speed:
    //All that applies to leftTurn applies here
    public void turnRight(double speed){
        this.playerDrive(0,0,speed);
    }

    //Basic Directions
    public void forward(double speed){this.playerDrive(0,-speed,0);}

    public void backward(double speed){this.playerDrive(0,speed,0);}

    public void left(double speed){this.playerDrive(speed,0,0);}

    public void right(double speed){this.playerDrive(-speed,0,0);}
}


