package mario3264.mod.objects.items;

import mario3264.mod.Main;
import mario3264.mod.init.ItemInit;
import mario3264.mod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemUnstackableBase extends Item implements IHasModel
{
	public ItemUnstackableBase(String name)
	{
        this.setMaxStackSize(1);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
