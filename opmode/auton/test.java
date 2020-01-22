package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Camera;
import org.firstinspires.ftc.teamcode.hardware.Claw;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Hook;
import org.firstinspires.ftc.teamcode.hardware.Lift;

import java.util.concurrent.TimeUnit;

@Autonomous(name="test")

public class test extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private Drivetrain drive = new Drivetrain(this);
//    private Hook hook = new Hook(this);
    private Lift lift = new Lift(this);
    private Claw claw = new Claw(this);
    private Camera camera = new Camera(this);

    @Override
    public void runOpMode() throws InterruptedException {
        claw.init(hardwareMap);
        camera.init(hardwareMap);
        drive.init(hardwareMap);
        lift.init(hardwareMap);

        camera.activateTrackables();
        drive.getCamera(camera);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        claw.front();
        sleep(1400);
        claw.open();
        sleep(1000);
        drive.driveToPos(25.75,0.2);
        drive.strafe(-0.1,0.4);
        claw.close();
        sleep(1200);
        lift.liftUp(0.4);
        sleep(400);
        lift.liftOff();
        sleep(500);
        drive.driveToPos(10, -0.6);
        drive.strafe(-0.5, 2.5);
        lift.liftUp(0.5);
        sleep(400);
        lift.liftOff();
        drive.driveToPos(10,0.6);
        claw.open();
        sleep(1000);
        drive.driveToPos(10, -0.6);
        lift.liftDown(0.5);
        sleep(600);
        lift.liftOff();
        drive.strafe(0.5,3);
        drive.driveToPos(10,0.6);
        claw.close();
        sleep(1000);
        lift.liftUp(0.5);
        sleep(370);
        lift.liftOff();
        drive.driveToPos(10, -0.6);
        drive.strafe(-0.5, 3);
        lift.liftUp(0.5);
        sleep(400);
        lift.liftOff();
        drive.driveToPos(10,0.2);
        claw.open();
    }
}
