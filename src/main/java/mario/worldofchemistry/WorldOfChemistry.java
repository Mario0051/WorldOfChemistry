package mario.worldofchemistry;

import mario.worldofchemistry.init.*;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorldOfChemistry implements ModInitializer {
	public static final String MOD_ID = "woc";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BlockInit.initialize();
		ItemInit.initialize();
		EntityInit.initialize();
		BlockEntityInit.initialize();
		ScreenHandlerInit.initialize();
	}
}