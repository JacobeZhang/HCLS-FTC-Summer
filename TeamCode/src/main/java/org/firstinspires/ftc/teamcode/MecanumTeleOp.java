package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="MecanumTeleOp")
public class MecanumTeleOp extends LinearOpMode {

    //Initialize drive motor variables
    //FL = Front Left, FR = Front Right, BL = Back Left, BR = Back Right
    public DcMotor FLmotor;
    public DcMotor FRmotor;
    public DcMotor BLmotor;
    public DcMotor BRmotor;

    @Override
    public void runOpMode() {
        //Map names on phone's robot configuration with motor variables we initialized
        FLmotor = hardwareMap.get(DcMotor.class, "FL_DCmotor");
        FRmotor = hardwareMap.get(DcMotor.class, "FR_DCmotor");
        BLmotor = hardwareMap.get(DcMotor.class, "BL_DCmotor");
        BRmotor = hardwareMap.get(DcMotor.class, "BR_DCmotor");

        waitForStart();

        while (opModeIsActive()) {
            //Map gamepad values to variables
            double drive = gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            //Do some simple math to set power for motors
            double FLPower = Range.clip(drive + strafe + turn, -1.0, 1.0);
            double FRPower = Range.clip(drive - strafe - turn, -1.0, 1.0);
            double BLPower = Range.clip(drive - strafe + turn, -1.0, 1.0);
            double BRPower = Range.clip(drive + strafe - turn, -1.0, 1.0);

            //Set power
            FLmotor.setPower(FLPower);
            FRmotor.setPower(FRPower);
            BLmotor.setPower(BLPower);
            BRmotor.setPower(BRPower);



        }
    }
}