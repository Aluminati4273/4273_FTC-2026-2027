package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

public class Mecanum {
    public double strafe;
    public double twist;
    public double drive;
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

    public void playerDrive(double strafe, double drive, double twist) {
//user Inputs
        this.strafe = strafe;
        this.drive = drive;
        this.twist = twist;

        double[] speeds = {
                (drive + strafe + twist),
                (drive - strafe - twist),
                (drive - strafe + twist),
                (drive + strafe - twist)
        };

        double max = Math.abs(speeds[0]);
        for(int i = 0; i < speeds.length; i++) {
            if ( max < Math.abs(speeds[i]) ) max = Math.abs(speeds[i]);
        }

        // If and only if the maximum is outside of the range we want it to be,
        // normalize all the other speeds based on the given speed value.
        if (max > 1) {
            for (int i = 0; i < speeds.length; i++) speeds[i] /= max;
        }

        // apply the calculated values to the motors.
        fl.setPower(speeds[0]);
        fr.setPower(speeds[1]);
        bl.setPower(speeds[2]);
        br.setPower(speeds[3]);

    }
    //For this section It is Important to
    // know that the values for the speeds have to be between 0-1
    //If above the value 1 it won't work; negatives will have the opposite effect
    // than intendedand, also below -1 will also stop wo

    public double getflPower(){
        return fl.getPower();
    }
    public double getfrPower(){
        return fr.getPower();
    }
    public double getblPower(){
        return bl.getPower();
    }
    public double getbrPower(){
        return br.getPower();
    }

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


