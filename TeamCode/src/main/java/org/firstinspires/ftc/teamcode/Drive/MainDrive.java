package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Hardware.Lights.Prism.PrismAnimations;
import org.firstinspires.ftc.teamcode.Hardware.Mecanum;

@TeleOp
public class MainDrive extends OpMode{
    Mecanum mecanum = new Mecanum();
    PrismAnimations.Solid solid = new PrismAnimations.Solid();
    @Override
    public void init() {
        mecanum.init(hardwareMap);
        telemetry.addData("Status", "Initialized");

    }



    @Override
    public void loop(){
        if(gamepad1.left_bumper){
            mecanum.playerDrive(-gamepad1.right_stick_x/2, -gamepad1.right_stick_y/2, gamepad1.left_stick_x/2);

        }
        else{
            mecanum.playerDrive(-gamepad1.right_stick_x, -gamepad1.right_stick_y, gamepad1.left_stick_x);
        }
        if(gamepad1.triangle){
            mecanum.forward(1);
        }
        if(gamepad1.x){
            mecanum.backward(1);
        }if(gamepad1.square){
            mecanum.left(1);
        }if(gamepad1.square){
            mecanum.right(1);
        }if(gamepad1.dpad_up){
            mecanum.turnLeft(1);
        }if(gamepad1.dpad_right){
            mecanum.right(1);
        }

        telemetry.update();

    }

}
