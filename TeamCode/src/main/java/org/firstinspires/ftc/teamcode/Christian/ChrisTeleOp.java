package org.firstinspires.ftc.teamcode.Christian;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


public class ChrisTeleOp extends LinearOpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor sliderMotor;
    @Override
    public void runOpMode() throws InterruptedException {

       frontLeft = hardwareMap.get(DcMotor.class,"frontLeft");
       frontRight = hardwareMap.get(DcMotor.class,"frontRight");
       backLeft  = hardwareMap.get(DcMotor.class,"backLeft") ;
       backRight = hardwareMap.get(DcMotor.class,"backRight");
       sliderMotor = hardwareMap.get(DcMotor.class, "sliderMotor ")

       frontLeft.setDirection( DcMotorSimple.Direction.REVERSE );
       backLeft.setDirection( DcMotorSimple.Direction.REVERSE );
       sliderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    waitForStart();

        while (opModeIsActive()) {

            double y = gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double r = gamepad1.right_stick_x;

            frontLeft.setPower (y+x+r);
            frontRight.setPower(y-x-r);
            backLeft.setPower(y-x+r);
            backRight.setPower(y+x-r);

            if(gamepad2.y) {
                sliderMotor.setPower( 0.75 );
            } else if (sliderMotor.getCurrentPosition() > 100){
                sliderMotor.setPower( -0.75 );
            }

        }



    }

}
