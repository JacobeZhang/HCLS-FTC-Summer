package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class MoveWithEncoder extends LinearOpMode {

    public DcMotor FLmotor;
    public DcMotor FRmotor;
    public DcMotor BLmotor;
    public DcMotor BRmotor;

    @Override
    public void runOpMode() throws InterruptedException {
        FLmotor = hardwareMap.get(DcMotor.class, "FL_DCmotor");
        FRmotor = hardwareMap.get(DcMotor.class, "FR_DCmotor");
        BLmotor = hardwareMap.get(DcMotor.class, "BL_DCmotor");
        BRmotor = hardwareMap.get(DcMotor.class, "BR_DCmotor");

        FLmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        FLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        FRmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        BLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BRmotor.setDirection(DcMotorSimple.Direction.FORWARD);

        FLmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FRmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BLmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BRmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        FLmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BLmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BRmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FLmotor.setTargetPosition(400);
        FRmotor.setTargetPosition(400);
        BLmotor.setTargetPosition(400);
        BRmotor.setTargetPosition(400);

        FLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        FLmotor.setPower(0.8);
        FRmotor.setPower(0.8);
        BLmotor.setPower(0.8);
        BRmotor.setPower(0.8);

        while (FLmotor.isBusy() || FRmotor.isBusy() || BLmotor.isBusy() || BRmotor.isBusy()) {

        }

        FLmotor.setPower(0);
        FRmotor.setPower(0);
        BLmotor.setPower(0);
        BRmotor.setPower(0);
    }
}