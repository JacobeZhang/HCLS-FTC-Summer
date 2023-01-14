package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="LinearSlideTest")
public class LinearSlideTest extends LinearOpMode {

    public DcMotor motor;
    public Servo ClawServoL;
    public Servo ClawServoR;
    public Servo PivotServo;
    //Initialize 4 motor variables
    // like this: public DcMotor (variable name);

    @Override
    public void runOpMode() {
        // Hardware Map 4 motors named "FL_DCmotor", "FR_DCmotor", "BL_DCmotor", and "BR_DCmotor"
        motor = hardwareMap.get(DcMotor.class, "SlideMotor");
        ClawServoL = hardwareMap.get(Servo.class, "ClawServoL");
        ClawServoR = hardwareMap.get(Servo.class, "ClawServoR");
        PivotServo = hardwareMap.get(Servo.class, "PivotServo");
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        waitForStart();

        //add some telemetry

        while (opModeIsActive()) {
            // use setPower to set gamepad input from gamepad1.left_stick_x to motor power
            motor.setPower(gamepad1.left_stick_x*0.6);

            if (gamepad1.a) {
                ClawServoL.setPosition(0.5);
                ClawServoR.setPosition(1);
            }
            if (gamepad1.b) {
                ClawServoL.setPosition(.9);
                ClawServoR.setPosition(0.6);
            }
            if (gamepad1.right_bumper) {
                PivotServo.setPosition(0.7);
            }
            if (gamepad1.left_bumper) {
                PivotServo.setPosition(0);
            }
        }
    }
}
