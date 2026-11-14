package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.Intake;
import org.firstinspires.ftc.teamcode.Hardware.Launch;
import org.firstinspires.ftc.teamcode.Hardware.Lights.Prism.PrismAnimations;
import org.firstinspires.ftc.teamcode.Hardware.Mecanum_Hope;

@TeleOp
public class MainDrive extends OpMode{
    Mecanum_Hope mecanum = new Mecanum_Hope();
    Intake intake = new Intake();
    Launch launch = new Launch();

    //Setting hardware map
    @Override
    public void init() {
        mecanum.init(hardwareMap);
        intake.init(hardwareMap);
        launch.init(hardwareMap);
        telemetry.addData("Status", "Initialized");

    }


    //TeleOp Mode of the game
    @Override
    public void loop(){

        //drive
        //this is too slow done the speed of the robot for exact aiming to score
        if(gamepad1.left_bumper){
            mecanum.playerDrive(-gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
        }
        //Normal drive
        else{
            mecanum.playerDrive(-gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
        }

        //intake temparary code
        intake.intake(gamepad1.a);

        //launch temaparary code
        launch.launch(gamepad1.right_trigger);

        telemetry.update();

    }

}
