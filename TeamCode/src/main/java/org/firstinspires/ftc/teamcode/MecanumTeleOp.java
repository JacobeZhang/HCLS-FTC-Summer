package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="FinalTeleOp")
public class MecanumTeleOp extends LinearOpMode {

    //Initialize drive motor variables
    //FL = Front Left, FR = Front Right, BL = Back Left, BR = Back Right
    public DcMotor FLmotor;
    public DcMotor FRmotor;
    public DcMotor BLmotor;
    public DcMotor BRmotor;
    public Servo coolServo;

    @Override
    public void runOpMode() {
        //Map names on phone's robot configuration with motor variables we initialized
        FLmotor = hardwareMap.get(DcMotor.class, "FL_DCmotor");
        FRmotor = hardwareMap.get(DcMotor.class, "FR_DCmotor");
        BLmotor = hardwareMap.get(DcMotor.class, "BL_DCmotor");
        BRmotor = hardwareMap.get(DcMotor.class, "BR_DCmotor");
        coolServo = hardwareMap.get(Servo.class, "coolServo");

        FLmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



        FLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        FRmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        BLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BRmotor.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {
            //Map gamepad values to variables
            double drive = gamepad1.left_stick_y * -0.4;
            double strafe = gamepad1.left_stick_x * -0.4;
            double turn = gamepad1.right_stick_x * 0.4;

            //Do some simple math to set power for motors
            double FLPower = Range.clip(drive + strafe + turn, -1.0, 1.0);
            double FRPower = Range.clip(drive - strafe - turn, -1.0, 1.0);
            double BLPower = Range.clip(drive - strafe + turn, -1.0, 1.0);
            double BRPower = Range.clip(drive + strafe - turn, -1.0, 1.0);

            FLmotor.getCurrentPosition();

            coolServo.getPosition();

            //Set power
            FLmotor.setPower(FLPower);
            FRmotor.setPower(FRPower);
            BLmotor.setPower(BLPower);
            BRmotor.setPower(BRPower);

        }
    }
}