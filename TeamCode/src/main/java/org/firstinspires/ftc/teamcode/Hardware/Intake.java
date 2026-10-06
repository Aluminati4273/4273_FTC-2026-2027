package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Hardware.Lights.Prism.Color;
import org.firstinspires.ftc.teamcode.Hardware.Lights.Prism.PrismAnimations;
import org.firstinspires.ftc.teamcode.Hardware.Lights.Prism.GoBildaPrismDriver;


public class Intake {
    public DcMotor li;
    public DcMotor ri;
    public DcMotorEx ll;
    public DcMotorEx rl;
    public Servo sl;
    public Servo sr;
    public boolean hold = false;
    public static int pressCount;
    GoBildaPrismDriver prism;
    PrismAnimations.Solid solid = new PrismAnimations.Solid(Color.TRANSPARENT);

    public void init(HardwareMap hwMap){
        //launchState = LaunchState.IDLE;

        li = hwMap.get(DcMotor.class, "Left_Intake");
        ri = hwMap.get(DcMotor.class, "Right_Intake");
        ll = hwMap.get(DcMotorEx.class, "Left_Launcher");
        rl = hwMap.get(DcMotorEx.class, "Right_Launcher");
        sl = hwMap.get(Servo.class, "stopLeft");
        sr = hwMap.get(Servo.class, "stopRight");

        li.setDirection(DcMotor.Direction.FORWARD);
        ll.setDirection(DcMotorEx.Direction.REVERSE);
        ri.setDirection(DcMotor.Direction.REVERSE);
        rl.setDirection(DcMotorEx.Direction.FORWARD);
        sl.setDirection(Servo.Direction.REVERSE);
        sr.setDirection(Servo.Direction.FORWARD);

        ll.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        prism = hwMap.get(GoBildaPrismDriver.class,"prism");

        solid.setBrightness(50);
        solid.setStartIndex(0);
        solid.setStopIndex(12);

    }

    public void playerIntakeLaunch(float rightTrigger, float leftTrigger,boolean bumper){

        li.setPower(leftTrigger);
        ri.setPower(leftTrigger);

        if(rightTrigger > 0) {
            if(bumper){
                rl.setVelocity(1500);
                ll.setVelocity(1500);
                sl.setPosition(0.5);
                sr.setPosition(0.5);
            }
            else{
                rl.setVelocity(1325);
                ll.setVelocity(1325);
                sl.setPosition(0.5);
                sr.setPosition(0.5);
            }
            if(rl.getVelocity() >= 1300 && ll.getVelocity() >= 1300){
                solid.setPrimaryColor(Color.GREEN);
                prism.insertAndUpdateAnimation(GoBildaPrismDriver.LayerHeight.LAYER_0, solid);
            }

        }
        else{
            solid.setPrimaryColor(Color.RED);
            prism.insertAndUpdateAnimation(GoBildaPrismDriver.LayerHeight.LAYER_0, solid);
            ll.setVelocity(0.0);
            rl.setVelocity(0.0);
            sl.setPosition(0.0);
            sr.setPosition(0.0);
        }
    }

    public void intake(double speed){
        li.setPower(speed);
        ri.setPower(speed);
    }
    public void launch(double speed){
        ll.setVelocity(speed);
        rl.setVelocity(speed);
    }
}
