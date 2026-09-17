package org.firstinspires.ftc.teamcode.MotorTest;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

public class TestSubsystem extends SubsystemBase {
    //private final Motor testMotor;

    public TestSubsystem(HardwareMap hardwareMap){
        //testMotor = new Motor(hardwareMap, "TestMotor");
    }

    public void setPower(double power) {
        //testMotor.set(power);
    }

    public void stop() {
       // testMotor.stopMotor();
    }
}
