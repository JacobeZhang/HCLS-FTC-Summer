package org.firstinspires.ftc.teamcode.Nazar;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class NazarTeleOp extends LinearOpMode {

    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor frontRight;
    public DcMotor slidesMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        slidesMotor = hardwareMap.get(DcMotor.class, "slidesMotor");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();

        while(opModeIsActive()){

            double y = gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double r = gamepad1.right_stick_x;
            double u = gamepad1.right_trigger;
            double d = gamepad1.left_trigger;

            frontLeft.setPower(y+x+r);
            frontRight.setPower(y-x-r);
            backLeft.setPower(y-x+r);
            backRight.setPower(y+x-r);
            slidesMotor.setPower(u-d);



            }


        }

    }


