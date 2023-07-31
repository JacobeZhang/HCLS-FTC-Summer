package org.firstinspires.ftc.teamcode.Nazar;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
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

//        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        waitForStart();

        emote(false);

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

            if(gamepad1.dpad_left){
                emote(false);
            }else if(gamepad1.dpad_right){
                emote(true);
            }


            }




            }
        public void emote(boolean direction){
            //false = left, true = right
            ElapsedTime NazarTimer = new ElapsedTime();
            while(NazarTimer.milliseconds() < 1000){
                if(direction){
                    frontLeft.setPower(1);
                    frontRight.setPower(-1);
                    backLeft.setPower(1);
                    backRight.setPower(-1);

                }else {
                    frontLeft.setPower(-1);
                    frontRight.setPower(1);
                    backLeft.setPower(-1);
                    backRight.setPower(1);

                }
            }
        }

    }


