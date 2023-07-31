package org.firstinspires.ftc.teamcode.Christian;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


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
       sliderMotor = hardwareMap.get(DcMotor.class, "sliderMotor");

       frontLeft.setDirection( DcMotorSimple.Direction.REVERSE );
       backLeft.setDirection( DcMotorSimple.Direction.REVERSE );
       sliderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


       frontLeft.setMode( DcMotor.RunMode.RUN_TO_POSITION);
       frontRight.setMode( DcMotor.RunMode.RUN_TO_POSITION );
       backLeft.setMode( DcMotor.RunMode.RUN_TO_POSITION );
       backRight.setMode( DcMotor.RunMode.RUN_TO_POSITION );



       waitForStart();

        while (opModeIsActive()) {

            double y = gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double r = gamepad1.right_stick_x;

            frontLeft.setPower (y+x+r);
            frontRight.setPower(y-x-r);
            backLeft.setPower(y-x+r);
            backRight.setPower(y+x-r);


                sliderMotor.setPower( 0.75 );
        } else if(sliderMotor.getCurrentPosition() > 100){
                sliderMotor.setPower( -0.75 );
            }

        }

        public void emote(boolean direction){
            //false = left,true = right
            ElapsedTime NazarTimer = new ElapsedTime();
            while (NazarTimer.milliseconds() < 1000) {
                if (direction) {
                    frontLeft.setPower (1);
                    frontRight.setPower(-1);
                    backLeft.setPower(1);
                    backRight.setPower(-1);


                } else {
                    frontLeft.setPower (-1);
                    frontRight.setPower(1);
                    backLeft.setPower(-1);
                    backRight.setPower(1);
                }
            }
        }

    }
