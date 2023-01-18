package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="ClawServoTeleOp")
public class SampleTeleOp extends LinearOpMode {

    public Servo clawServo;
    //Initialize 4 motor variables
    // like this: public DcMotor (variable name);

    @Override
    public void runOpMode() {
        // Hardware Map 4 motors named "FL_DCmotor", "FR_DCmotor", "BL_DCmotor", and "BR_DCmotor"
        clawServo = hardwareMap.get(Servo.class, "clawServo");
        waitForStart();

        //add some telemetry

        while (opModeIsActive()) {
            // use setPower to set gamepad input from gamepad1.left_stick_x to motor power
            clawServo.setPosition(gamepad1.right_stick_y);
        }
    }
}
