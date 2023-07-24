package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

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
        ElapsedTime time = new ElapsedTime();
        while (time.seconds() < 2) {
            FLmotor.setPower(0.75);
            FRmotor.setPower(0.75);
            BLmotor.setPower(0.75);
            BRmotor.setPower(0.75);
        }
    }

    public int InchesToEC(int inches){
        double ticksPerRevolution = 537.7;
        int diameter = 96;
        double circumference = (diameter * Math.PI)/25.4;   //25.4 mm in an inch

        return (int) (inches * (ticksPerRevolution/circumference));
    }
}