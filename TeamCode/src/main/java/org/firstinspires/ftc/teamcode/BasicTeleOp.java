package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Yassin's TeleOp")

public class BasicTeleOp extends LinearOpMode {

    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;

    public void runOpMode(){

        frontLeft = hardwareMap.get(DcMotor.class, "FL_DCmotor");
        backLeft = hardwareMap.get(DcMotor.class, "RL_DCmotor");
        frontRight = hardwareMap.get(DcMotor.class, "FR_DCmotor");
        backRight = hardwareMap.get(DcMotor.class, "RR_DCmotor");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()){
            frontLeft.setPower(gamepad1.left_stick_y);
            frontRight.setPower(gamepad1.left_stick_y);
            backRight.setPower(gamepad1.left_stick_y);
            backLeft.setPower(gamepad1.left_stick_y);

            frontLeft.setPower(gamepad1.right_stick_x);
            frontRight.setPower(gamepad1.right_stick_x);
            backRight.setPower(gamepad1.right_stick_x);
            backLeft.setPower(gamepad1.right_stick_x);

        }
    }
}
