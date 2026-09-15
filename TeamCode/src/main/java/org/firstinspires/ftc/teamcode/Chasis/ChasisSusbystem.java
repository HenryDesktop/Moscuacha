package org.firstinspires.ftc.teamcode.Chasis;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.ConfigureIMU;

public class ChasisSusbystem extends SubsystemBase {
    private final Motor fl_motor;
    private final Motor fr_motor;
    private final Motor bl_motor;
    private final Motor br_motor;
    private ConfigureIMU heading;


    public ChasisSusbystem(HardwareMap hardwareMap){

        heading = new ConfigureIMU(hardwareMap);

        fl_motor = new Motor(hardwareMap, "FLMotor");
        fr_motor = new Motor(hardwareMap, "FRMotor");
        bl_motor = new Motor(hardwareMap, "BLMotor");
        br_motor = new Motor(hardwareMap, "BRMotor");

        fl_motor.setInverted(false);
        fr_motor.setInverted(true);
        bl_motor.setInverted(false);
        br_motor.setInverted(true);
    }

    public void motorConversions(double x, double y, double rx){

            double botHeading = Math.toRadians(heading.getHeading(AngleUnit.DEGREES));

            double rotx = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            double roty = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

            double FLpower = roty + rotx - rx;
            double BLpower = roty - rotx - rx;
            double FRpower = roty - rotx + rx;
            double BRpower = roty + rotx + rx;

            double maxPower = Math.max(1.0,
                    Math.max(Math.abs(FLpower),
                            Math.max(Math.abs(FRpower),
                                    Math.max(Math.abs(BLpower), Math.abs(BRpower)))
                    ));

            fl_motor.set(FLpower / maxPower);
            fr_motor.set(FRpower / maxPower);
            bl_motor.set(BLpower / maxPower);
            br_motor.set(BRpower / maxPower);
        }
    public void stop() {
        fl_motor.stopMotor();
        fr_motor.stopMotor();
        bl_motor.stopMotor();
        br_motor.stopMotor();
    }

    @Override
    public void periodic() {
    }
}
