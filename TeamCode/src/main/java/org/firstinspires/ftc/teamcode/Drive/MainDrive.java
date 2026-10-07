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

        telemetry.update();

    }

}
