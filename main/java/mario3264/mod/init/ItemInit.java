package mario3264.mod.init;

import java.util.ArrayList;
import java.util.List;

import mario3264.mod.objects.items.ItemAntidote;
import mario3264.mod.objects.items.ItemBase;
import mario3264.mod.objects.items.ItemElixir;
import mario3264.mod.objects.items.ItemEyeDrops;
import mario3264.mod.objects.items.ItemTonic;
import mario3264.mod.objects.items.ItemUnstackableBase;
import net.minecraft.item.Item;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item ALUMINUM_OXIDE = new ItemBase("aluminum_oxide");
	public static final Item AMMONIA = new ItemBase("ammonia");
	public static final Item ANTIDOTE = new ItemAntidote("antidote");
	public static final Item BARIUM_SULFATE = new ItemBase("barium_sulfate");
	public static final Item BENZENE = new ItemBase("benzene");
	public static final Item BLEACH = new ItemUnstackableBase("bleach");
	public static final Item BORON_TRIOXIDE = new ItemBase("boron_trioxide");
	public static final Item CALCIUM_BROMIDE = new ItemBase("calcium_bromide");
	public static final Item CALCIUM_CHLORIDE = new ItemBase("calcium_chloride");
	public static final Item CERIUM_CHLORIDE = new ItemBase("cerium_chloride");
	public static final Item CRUDE_OIL = new ItemBase("crude_oil");
	public static final Item ELIXIR = new ItemElixir("elixir");
	public static final Item EYE_DROPS = new ItemEyeDrops("eye_drops");
	public static final Item GARBAGE = new ItemBase("garbage");
	public static final Item GLUE = new ItemBase("glue");
	public static final Item HYDROGEN_PEROXIDE = new ItemBase("hydrogen_peroxide");
	public static final Item IRON_SULFIDE = new ItemBase("iron_sulfide");
	public static final Item LATEX = new ItemBase("latex");
	public static final Item LITHIUM_HYDRIDE = new ItemBase("lithium_hydride");
	public static final Item LUMINOL = new ItemBase("luminol");
	public static final Item LYE = new ItemBase("lye");
	public static final Item MAGNESIUM_NITRATE = new ItemBase("magnesium_nitrate");
	public static final Item MAGNESIUM_OXIDE = new ItemBase("magnesium_oxide");
	public static final Item MERCURIC_CHLORIDE = new ItemBase("mercuric_chloride");
	public static final Item POLYETHYLENE = new ItemBase("polyethylene");
	public static final Item POTASSIUM_CHLORIDE = new ItemBase("potassium_chloride");
	public static final Item POTASSIUM_IODIDE = new ItemBase("potassium_iodide");
	public static final Item SALT = new ItemBase("salt");
	public static final Item SOAP = new ItemBase("soap");
	public static final Item SODIUM_ACETATE = new ItemBase("sodium_acetate");
	public static final Item SODIUM_FLUORIDE = new ItemBase("sodium_fluoride");
	public static final Item SODIUM_HYDRIDE = new ItemBase("sodium_hydride");
	public static final Item SODIUM_HYPOCHLORITE = new ItemBase("sodium_hypochlorite");
	public static final Item SODIUM_OXIDE = new ItemBase("sodium_oxide");
	public static final Item SULFATE = new ItemBase("sulfate");
	public static final Item TONIC = new ItemTonic("tonic");
	public static final Item TUNGSTEN_CHLORIDE = new ItemBase("tungsten_chloride");
	public static final Item WATER = new ItemBase("water");
}

