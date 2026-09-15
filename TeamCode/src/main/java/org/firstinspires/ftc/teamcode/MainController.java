package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.button.Trigger;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Chasis.ChasisCommand;
import org.firstinspires.ftc.teamcode.Chasis.ChasisSusbystem;

@TeleOp
public class MainController extends CommandOpMode {
    ChasisSusbystem chasisSusbystem;
    ConfigureIMU configureIMU;
    GamepadEx driverController;
    GamepadEx mechanismController;
    @Override
    public void initialize() {

        driverController = new GamepadEx(gamepad1);
        mechanismController = new GamepadEx(gamepad2);

        configureIMU = new ConfigureIMU(hardwareMap);
        chasisSusbystem = new ChasisSusbystem(hardwareMap);

        new Trigger(() ->
                driverController.wasJustPressed(GamepadKeys.Button.X)
        ).whenActive(new InstantCommand(() -> configureIMU.resetImu()));

        chasisSusbystem.setDefaultCommand(
                new ChasisCommand(chasisSusbystem, driverController));

        chasisSusbystem.setDefaultCommand(
                new ChasisCommand(chasisSusbystem, driverController)
        );

    }

    public void run() {

        /*

            Metodo creado que se ejecuta siempre

            Se encarga de actualizar constantemente
            para ver si hay algun cambio en los botones
            y posteriormente designarlos con comandos despues

         */

        driverController.readButtons();
        mechanismController.readButtons();
        super.run();
    }
}
