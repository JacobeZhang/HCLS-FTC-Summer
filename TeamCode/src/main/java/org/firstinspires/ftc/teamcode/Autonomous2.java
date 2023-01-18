package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class Autonomous2 extends LinearOpMode {

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

        FLmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BLmotor.setDirection(DcMotorSimple.Direction.REVERSE);

        //code that runs when you hit init
        waitForStart();
        //code that runs when you hit the start button

        int encoderCounts = InchesToEC(24);

        FLmotor.setTargetPosition(encoderCounts);
        FRmotor.setTargetPosition(encoderCounts);
        BLmotor.setTargetPosition(encoderCounts);
        BRmotor.setTargetPosition(encoderCounts);

        FLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BLmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        FLmotor.setPower(1);
        FRmotor.setPower(1);
        BLmotor.setPower(1);
        BRmotor.setPower(1);
    }

    public int InchesToEC(int inches){
        double ticksPerRevolution = 537.7;
        int diameter = 96;
        double circumference = (diameter * Math.PI)/25.4;   //25.4 mm in an inch

        return (int) (inches * (ticksPerRevolution/circumference));
    }
}