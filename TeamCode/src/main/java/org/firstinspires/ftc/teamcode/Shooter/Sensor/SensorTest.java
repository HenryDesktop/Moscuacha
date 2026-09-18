package org.firstinspires.ftc.teamcode.Shooter.Sensor;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SensorColor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SensorTest extends SubsystemBase {
    private SensorColor colorSensor;
    public SensorTest(HardwareMap hwMap, Telemetry telemetry){
        colorSensor = new SensorColor(hwMap, "CS1");
    }

    public int alpha(){
        return colorSensor.alpha();
    }
    public int blue(){
        return colorSensor.blue();
    }
    public int green(){
        return colorSensor.green();
    }
    public int red(){
        return colorSensor.red();
    }
    @Override
    public void periodic() {
    }
}
