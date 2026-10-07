package org.firstinspires.ftc.teamcode.Drive.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Hardware.Mecanum;

@Autonomous
public class Red_Front extends LinearOpMode {

    Mecanum drive = new Mecanum();
    Intake launch = new Intake();
    @Override
    public void runOpMode(){
        drive.init(hardwareMap);
        launch.init(hardwareMap);
        // Wait for the game to start (driver presses START)
        waitForStart();
        resetRuntime();

        while (opModeIsActive()) {
            double runner = getRuntime();
            double newTime = getRuntime();
            while(newTime < runner + .1){
                drive.left(1);
                newTime = getRuntime();

                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.update();
            }
            drive.right(0);
            break;
        }
    }
}

