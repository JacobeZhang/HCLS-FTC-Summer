package org.firstinspires.ftc.teamcode.ty;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class TyTeleOp extends LinearOpMode {

    public DcMotor frontLeft, backLeft, frontRight, backRight, slidesMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        slidesMotor = hardwareMap.get(DcMotor.class, "slidesMotor");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()) {

            double y = gamepad1.left_stick_y, x = gamepad1.left_stick_x, r = gamepad1.right_stick_x;

            frontLeft.setPower(y+x+r);
            backLeft.setPower(y-x-r);
            frontRight.setPower(y-x+r);
            backRight.setPower(y+x-r);

            slidesMotor.setPower(gamepad2.dpad_down ? 0.75 : gamepad2.dpad_up ? -0.75 : 0);
        }

    }

}