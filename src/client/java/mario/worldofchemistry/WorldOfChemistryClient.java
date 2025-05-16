package mario.worldofchemistry;

import mario.worldofchemistry.init.EntityInit;
import mario.worldofchemistry.init.ScreenHandlerInit;
import mario.worldofchemistry.screen.ElementConstructorScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class WorldOfChemistryClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(EntityInit.ICE_BOMB_ENTITY_TYPE, FlyingItemEntityRenderer::new);
		HandledScreens.register(
				ScreenHandlerInit.ELEMENT_CONSTRUCTOR_SCREEN_HANDLER_TYPE, // Your ScreenHandlerType
				ElementConstructorScreen::new // A constructor reference for your Screen class
		);

	}
}