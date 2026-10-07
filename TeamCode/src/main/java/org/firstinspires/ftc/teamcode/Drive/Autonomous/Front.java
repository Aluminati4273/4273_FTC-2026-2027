package org.firstinspires.ftc.teamcode.Drive.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.Mecanum;

@Autonomous
public class Front extends LinearOpMode {

    Mecanum drive = new Mecanum();
    Intake launch = new Intake();
    public void runOpMode(){
        drive.init(hardwareMap);
        launch.init(hardwareMap);

        // Wait for the game to start (driver presses START)
        waitForStart();
        resetRuntime();

        while (opModeIsActive()) {
            launch.sl.setPosition(.5);
            launch.sr.setPosition(.5);

            double newTime = getRuntime();
            double testTime = getRuntime();

            telemetry.addData("Time: ", newTime);
            telemetry.addData("Time: ", getRuntime());
            telemetry.update();

            //launch.sl.setPosition(0);
            //launch.sr.setPosition(0);

            while (newTime <= testTime + 2) {
                launch.launch(1530);
                newTime = getRuntime();

                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.addData("Launch: ", "1");
                telemetry.update();
            }
            testTime = getRuntime();
            while(newTime <= testTime+1){
                launch.sl.setPosition(0.5);
                launch.sr.setPosition(0.5);

                launch.intake(.5);

                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.update();

                newTime = getRuntime();
            }

            launch.intake(0);
            //launch.sl.setPosition(0);
            //launch.sr.setPosition(0);

            for(int i=2; i<=3; i++){
                testTime = getRuntime();
                while(newTime <= testTime+2){
                    launch.launch(1500);
                    newTime = getRuntime();

                    telemetry.addData("Time: ", newTime);
                    telemetry.addData("Time: ", getRuntime());
                    telemetry.addData("Launch: ", i);
                    telemetry.update();
                }

                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.update();

                //launch.sl.setPosition(.5);
                //launch.sr.setPosition(.5);

                sleep(100);

                testTime = getRuntime();
                newTime = getRuntime();
                while (newTime <= testTime+3){
                    launch.intake(1);

                    telemetry.addData("Time: ", newTime);
                    telemetry.addData("Time: ", getRuntime());
                    telemetry.update();

                    newTime = getRuntime();
                }

                //launch.sl.setPosition(0);
                //launch.sr.setPosition(0);

                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.update();

                sleep(100);
            }
            testTime = getRuntime();
            newTime = getRuntime();

            while (newTime <= testTime+.25){
                drive.backward(1);
                newTime = getRuntime();
                telemetry.addData("Time: ", newTime);
                telemetry.addData("Time: ", getRuntime());
                telemetry.update();
            }

            drive.forward(0);
            sleep(100);
            break;
        }


    }
}
