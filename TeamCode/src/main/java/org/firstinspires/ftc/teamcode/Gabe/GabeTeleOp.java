package org.firstinspires.ftc.teamcode.Gabe;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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
        slidesmotor = hardwareMap.get(DcMotor.class,"slidesmotor");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        slidesmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        waitForStart();

        while(opModeIsActive()) {

            double y = gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double r = gamepad1.right_stick_x;

            frontLeft.setPower(y+x+r);
            frontright.setPower(y-x-r);
            backLeft.setPower(y-x+r);
            backright.setPower(y+x-r);

            if(gamepad2.y){
                slidesmotor.setPower(0.75);
            }else if(slidesmotor.getCurrentPosition()>100) {

            }




        }

    }

}
