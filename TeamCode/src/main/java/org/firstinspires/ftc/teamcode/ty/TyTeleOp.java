package org.firstinspires.ftc.teamcode.ty;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class TyTeleOp extends LinearOpMode {


    public DcMotor frontLeft, backLeft, frontRight, backRight;


    @Override
    public void runOpMode() throws InterruptedException {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()) {

            double y = gamepad1.left_stick_y, x = gamepad1.left_stick_x;
            frontLeft.setPower(y+x);
            backLeft.setPower(y-x);
            frontRight.setPower(y-x);
            backRight.setPower(y+1);
        }

    }

}