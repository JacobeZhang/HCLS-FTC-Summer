package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Random;

@Autonomous
public class MockFSM extends LinearOpMode {

    public DcMotor FLmotor;
    public DcMotor FRmotor;
    public DcMotor BLmotor;
    public DcMotor BRmotor;

    @Override
    public void runOpMode() {
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

        /* The FSM tells the robot to do the following:
        Move forward for 2 seconds
        Move backward for 1 second
        Turn right for 1 second

        Keep in mind that during Autonomous it is better to use encoders to move the robot for better accuracy
        */
        int thing = FLmotor.getCurrentPosition();
        int value = FRmotor.getCurrentPosition();
        int value2 = 0;

        while( thing == 1) {
	        System.out.print(thing);
        }

        while(value < 10) {
            value++; //Increases Value by 1
        }

        while(value == 10) {
            value2++;
            if (value2 < 5) {
                value = 10;
            }
        }




        ElapsedTime timey = new ElapsedTime();
        while (timey.time() < 4.0) {
            if (timey.time() > 0 && timey.time() < 2.0) {
                FLmotor.setPower(0.5);
                FRmotor.setPower(0.5);
                BLmotor.setPower(0.5);
                BRmotor.setPower(0.5);
            } if (timey.time() > 2.0 && timey.time() < 3.0) {
                FLmotor.setPower(-0.5);
                FRmotor.setPower(-0.5);
                BLmotor.setPower(-0.5);
                BRmotor.setPower(-0.5);
            } if (timey.time() > 3.0 && timey.time() < 4.0) {
                FLmotor.setPower(0.5);
                FRmotor.setPower(-0.5);
                BLmotor.setPower(0.5);
                BRmotor.setPower(-0.5);
            }
        }
    }
}
