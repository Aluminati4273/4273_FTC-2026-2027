package org.firstinspires.ftc.teamcode.Drive.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.Mecanum;

@Autonomous
public class Red_Back extends LinearOpMode {
    Mecanum drive = new Mecanum();
    Intake launch = new Intake();

    @Override
    public void runOpMode() {
        drive.init(hardwareMap);
        launch.init(hardwareMap);

        // Wait for the game to start (driver presses START)
        waitForStart();
        resetRuntime();

        while (opModeIsActive()) {
            launch.sl.setPosition(.5);
            launch.sr.setPosition(.5);

            double newTime = getRuntime();
            telemetry.addData("Time: ", newTime);
            telemetry.addData("Time: ", getRuntime());
            telemetry.update();

            while (newTime <= .55){
                drive.forward(1);
                newTime = getRuntime();
                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.update();
            }

            drive.backward(0);
            sleep(100);

            double testTime = getRuntime();
            while (newTime <= testTime + 2) {
                launch.launch(1365);
                newTime = getRuntime();

                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.addData("Launch: ", "1");
                telemetry.update();
            }

            newTime = getRuntime();
            testTime = getRuntime();

            while(newTime <= testTime+ 1){

                launch.intake(.5);

                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.update();

                newTime = getRuntime();
            }

            launch.intake(0);

            newTime = getRuntime();
            testTime = getRuntime();


            for(int i=2; i<=3; i++){
                testTime = getRuntime();
                while(newTime <= testTime+1){
                    launch.launch(1320);
                    newTime = getRuntime();

                    telemetry.addData("Time: ", newTime);
                    telemetry.addData("Time: ", getRuntime());
                    telemetry.addData("Launch: ", i);
                    telemetry.update();
                }

                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.update();

                testTime = getRuntime();

                sleep(100);

                time = getRuntime();
                while (newTime <= testTime + 5){

                    launch.intake(1);

                    telemetry.addData("Time: ", newTime);
                    telemetry.addData("Time: ", getRuntime());
                    telemetry.update();

                    newTime = getRuntime();
                }

                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.update();

                sleep(100);
            }
            drive.backward(0);
            launch.launch(0);
            launch.intake(0);
            telemetry.update();

            newTime = getRuntime();
            testTime = getRuntime();

            while (newTime <= testTime + .6){
                drive.right(1);
                newTime = getRuntime();
                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.update();
            }

            drive.left(0);

            sleep(500);
            break;
        }
    }
}