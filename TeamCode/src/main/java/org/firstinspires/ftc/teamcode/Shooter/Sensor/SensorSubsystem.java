package org.firstinspires.ftc.teamcode.Shooter.Sensor;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SensorColor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SensorSubsystem extends SubsystemBase {
    private SensorColor colorSensor;
    private boolean sensorActive;
    public SensorSubsystem(HardwareMap hwMap, Telemetry telemetry){
        colorSensor = getOrNull(hwMap, SensorColor.class, "CS1", telemetry);
        sensorActive = colorSensor != null;
    }

    private <T> T getOrNull(HardwareMap hwMap, Class<T> tClass, String name, Telemetry telemetry){
        try {
            return hwMap.get(tClass, name);
        }
        catch (Exception e) {
            telemetry.addData("NO SE ENCONTRO:", name);
            return null;
        }
    }
    public int[] getARGB() {
        if (!sensorActive){
            return new int[] {-1,-1,-1,-1};
        }
        return new int[] {alpha(),blue(),green(),red()};
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
        if (!sensorActive) return;
    }
}
