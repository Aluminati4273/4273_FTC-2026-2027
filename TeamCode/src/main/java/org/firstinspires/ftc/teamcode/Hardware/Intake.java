package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Intake {

    public DcMotor intake;
    public void init(HardwareMap hwMap) {
        intake = hwMap.get(DcMotor.class, "james");
    }

    public void intake(boolean button){
        if(button) {
            intake.setPower(1);
        }
    }
}
