package mario3264.mod.util.handlers;

import mario3264.mod.init.BlockInit;
import mario3264.mod.init.ItemInit;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class DemBrewing
{	
	public static ItemStack antidote = new ItemStack(ItemInit.ANTIDOTE);
	public static ItemStack elixir = new ItemStack(ItemInit.ELIXIR);
	public static ItemStack eyeDrops = new ItemStack(ItemInit.EYE_DROPS);
	public static ItemStack tonic = new ItemStack(ItemInit.TONIC);
	public static ItemStack awkwardPotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), getVanillaType("awkward"));
	
	public static void init()
	{
		BrewingRecipeRegistry.addRecipe(awkwardPotion, new ItemStack(BlockInit.ELEMENT_47), antidote);
		BrewingRecipeRegistry.addRecipe(awkwardPotion, new ItemStack(BlockInit.ELEMENT_27), elixir);
		BrewingRecipeRegistry.addRecipe(awkwardPotion, new ItemStack(BlockInit.ELEMENT_20), eyeDrops);
		BrewingRecipeRegistry.addRecipe(awkwardPotion, new ItemStack(BlockInit.ELEMENT_83), tonic);
	}
	
	public static PotionType getVanillaType(String name)
	{
		return PotionType.REGISTRY.getObject(new ResourceLocation(name));
	}
}