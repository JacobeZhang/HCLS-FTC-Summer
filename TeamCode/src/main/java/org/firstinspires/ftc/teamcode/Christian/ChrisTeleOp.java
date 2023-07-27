package org.firstinspires.ftc.teamcode.Christian;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


public class ChrisTeleOp extends LinearOpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    @Override
    public void runOpMode() throws InterruptedException {

       frontLeft = hardwareMap.get(DcMotor.class,"frontLeft");
       frontRight = hardwareMap.get(DcMotor.class,"frontRight");
       backLeft  = hardwareMap.get(DcMotor.class,"backLeft") ;
       backRight = hardwareMap.get(DcMotor.class,"backRight");

       frontLeft.setDirection( DcMotorSimple.Direction.REVERSE );
       backLeft.setDirection( DcMotorSimple.Direction.REVERSE );

    waitForStart();

        while (opModeIsActive()) {

            double y = gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;

            frontLeft.setPower (y+x);
            frontRight.setPower(y-x);
            backLeft.setPower(y-x);
            backRight.setPower(y+x);



        }

    }

}
