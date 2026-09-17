package org.firstinspires.ftc.teamcode.MotorTest;

import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;


public class TestCommand extends CommandBase {
    private final TestSubsystem testSubsystem;
    private GamepadEx controller;

    public TestCommand(TestSubsystem testSubsystem, GamepadEx mechanismController){
        this.testSubsystem = testSubsystem;
        this.controller = mechanismController;
        addRequirements(testSubsystem);
    }

    @Override
    public void initialize() {
    }
    @Override
    public void execute(){
        testSubsystem.setPower(1.0);
    }
    @Override
    public void end(boolean interrupted) {
        testSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}

