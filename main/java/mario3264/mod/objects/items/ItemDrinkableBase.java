package mario3264.mod.objects.items;

import mario3264.mod.Main;
import mario3264.mod.util.IHasModel;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDrinkableBase extends Item implements IHasModel
{
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }
    
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }
    
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
