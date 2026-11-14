package org.firstinspires.ftc.teamcode.Hardware;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Launch {
    public DcMotor launch;
    public void init(HardwareMap hwMap) {
        launch = hwMap.get(DcMotor.class, "bob");
    }

    public void launch(double rTrigger){
        launch.setPower(rTrigger);
    }
}
