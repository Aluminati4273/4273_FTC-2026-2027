package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.Lights.Prism.Color;
import org.firstinspires.ftc.teamcode.Hardware.Lights.Prism.GoBildaPrismDriver;
import org.firstinspires.ftc.teamcode.Hardware.Lights.Prism.PrismAnimations;
import org.firstinspires.ftc.teamcode.Hardware.Mecanum;
import org.firstinspires.ftc.teamcode.Hardware.Intake;

@TeleOp
public class MainDrive extends OpMode{
    Mecanum mecanum = new Mecanum();
    Intake intake = new Intake();
    PrismAnimations.Solid solid = new PrismAnimations.Solid();
    @Override
    public void init() {
        mecanum.init(hardwareMap);
        intake.init(hardwareMap);
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
        intake.playerIntakeLaunch(gamepad1.right_trigger, gamepad1.left_trigger, gamepad1.right_bumper);
        telemetry.addData("Left Velocity: ", intake.ll.getVelocity());
        telemetry.addData("Right Velocity: ", intake.rl.getVelocity());
        telemetry.update();

    }

}
