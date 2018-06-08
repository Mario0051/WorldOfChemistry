package mario3264.mod.init;

import java.util.ArrayList;
import java.util.List;

import mario3264.mod.objects.items.ItemBase;
import mario3264.mod.objects.items.ItemCurativePotion;
import mario3264.mod.objects.items.ItemUnstackableBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	

	public static final Item ANTIDOTE = new ItemCurativePotion("antidote", 19);
	public static final Item BLEACH = new ItemUnstackableBase("bleach");
	public static final Item ELIXIR = new ItemCurativePotion("elixir", 18);
	public static final Item EYE_DROPS = new ItemCurativePotion("eye_drops", 15);
	public static final Item TONIC = new ItemCurativePotion("tonic", 9);
}

