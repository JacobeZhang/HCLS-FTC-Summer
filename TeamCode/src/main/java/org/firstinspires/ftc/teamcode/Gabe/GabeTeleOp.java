package org.firstinspires.ftc.teamcode.Gabe;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class GabeTeleOp extends LinearOpMode {

    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontright;
    public DcMotor backright;
    public DcMotor slidesmotor;

    @Override
    public void runOpMode() throws InterruptedException {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backleft");
        frontright = hardwareMap.get(DcMotor.class, "frontright");
        backright = hardwareMap.get(DcMotor.class, "backright");
        slidesmotor = hardwareMap.get(DcMotor.class, "slidesmotor");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        slidesmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        waitForStart();

        while (opModeIsActive()) {

            double y = gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double r = gamepad1.right_stick_x;

            frontLeft.setPower(y + x + r);
            frontright.setPower(y - x - r);
            backLeft.setPower(y - x + r);
            backright.setPower(y + x - r);

            if (gamepad2.y) {
                slidesmotor.setPower(0.75);
            } else if (slidesmotor.getCurrentPosition() > 100) {

            }
            if(gamepad2.dpad_left){
                emote(false);
            }else if(gamepad2.dpad_right){
                emote(true);
            }

        }
    }
    public void emote(boolean direction){
            //false = left true = right
            ElapsedTime NazarTimer = new ElapsedTime();
            while (NazarTimer.milliseconds()< 1000){
                if(direction){
                    frontLeft.setPower(1);
                    frontright.setPower(-1);
                    backLeft.setPower(1);
                    backright.setPower(-1);


                }else{
                    frontLeft.setPower(-1);
                    frontright.setPower(1);
                    backLeft.setPower(-1);
                    backright.setPower(1);

                }
            }

        }


}
