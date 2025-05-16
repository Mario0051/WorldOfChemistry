package mario.worldofchemistry.init;

import mario.worldofchemistry.handler.ElementConstructorScreenOpeningData;
import mario.worldofchemistry.handler.ElementConstructorScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static mario.worldofchemistry.WorldOfChemistry.MOD_ID;

public class ScreenHandlerInit {

    public static ScreenHandlerType<ElementConstructorScreenHandler> ELEMENT_CONSTRUCTOR_SCREEN_HANDLER_TYPE;

    public static void initialize() {

        ELEMENT_CONSTRUCTOR_SCREEN_HANDLER_TYPE = new ExtendedScreenHandlerType<>(
                ElementConstructorScreenHandler::new,
                ElementConstructorScreenOpeningData.PACKET_CODEC
        );


        Registry.register(
                Registries.SCREEN_HANDLER,
                Identifier.of(MOD_ID, "element_constructor"),
                ELEMENT_CONSTRUCTOR_SCREEN_HANDLER_TYPE
        );
    }
}