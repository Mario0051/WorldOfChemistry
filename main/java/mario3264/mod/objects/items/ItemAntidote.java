package mario3264.mod.objects.items;

import mario3264.mod.init.ItemInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemAntidote extends ItemDrinkableBase
{
	int potionID = 19;

	public ItemAntidote(String name)
	{
        this.setMaxStackSize(1);
		setRegistryName(name);
        setTranslationKey(name);
		setCreativeTab(CreativeTabs.BREWING);
		
		ItemInit.ITEMS.add(this);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		if (playerIn.getActivePotionEffect(Potion.getPotionById(potionID))!=null)
		{
			playerIn.setActiveHand(handIn);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		}
		else
		{
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		}
	}
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	{
		if (entityLiving instanceof EntityPlayerMP)
		{
		EntityPlayerMP entityplayermp = (EntityPlayerMP)entityLiving;
		CriteriaTriggers.CONSUME_ITEM.trigger(entityplayermp, stack);
		entityplayermp.addStat(StatList.getObjectUseStats(this));
		}

		if (entityLiving instanceof EntityPlayer && !((EntityPlayer)entityLiving).capabilities.isCreativeMode)
		{
		stack.shrink(1);
		}

		if (!worldIn.isRemote)
		{
		entityLiving.removePotionEffect(Potion.getPotionById(potionID));
		}

		return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
	}
}