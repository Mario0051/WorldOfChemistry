package mario3264.mod.objects.items;

import javax.annotation.Nonnull;

import mario3264.mod.Main;
import mario3264.mod.init.ItemInit;
import mario3264.mod.util.IHasModel;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;

public class ItemCurativePotion extends Item implements IHasModel
{
	private static int potionID;

	public ItemCurativePotion(String name, int id)
	{
		this.setMaxStackSize(1);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BREWING);
		potionID = id;
		
		ItemInit.ITEMS.add(this);
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
    
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }
    
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
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
    
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}