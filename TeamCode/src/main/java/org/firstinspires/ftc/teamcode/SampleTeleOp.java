package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="SampleTeleOp")
public class SampleTeleOp extends LinearOpMode {

    public DcMotor motor;
    //Initialize 4 motor variables
    // like this: public DcMotor (variable name);

    @Override
    public void runOpMode() {
        // Hardware Map 4 motors named "FL_DCmotor", "FR_DCmotor", "BL_DCmotor", and "BR_DCmotor"
        waitForStart();

        //add some telemetry

        while (opModeIsActive()) {
            // use setPower to set gamepad input from gamepad1.left_stick_x to motor power
            motor.setPower(gamepad1.left_stick_x);
        }
    }
}
