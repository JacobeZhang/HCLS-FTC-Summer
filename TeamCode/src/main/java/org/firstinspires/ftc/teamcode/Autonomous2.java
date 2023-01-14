package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Autonomous2 extends LinearOpMode {

    public DcMotor FLmotor;
    public DcMotor FRmotor;
    public DcMotor BLmotor;
    public DcMotor BRmotor;

    @Override
    public void runOpMode() throws InterruptedException {
        FLmotor = hardwareMap.get(DcMotor.class, "FL_DCmotor");
        FRmotor = hardwareMap.get(DcMotor.class, "FR_DCmotor");
        BLmotor = hardwareMap.get(DcMotor.class, "BL_DCmotor");
        BRmotor = hardwareMap.get(DcMotor.class, "BR_DCmotor");

        //code that runs when you hit init
        waitForStart();
        //code that runs when you hit the start button

    }
}