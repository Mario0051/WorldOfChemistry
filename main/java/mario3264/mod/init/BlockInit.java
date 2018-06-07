package mario3264.mod.init;

import java.util.ArrayList;
import java.util.List;

import mario3264.mod.objects.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ELEMENT_1 = new BlockBase("element_1", Material.ROCK);
	public static final Block ELEMENT_83 = new BlockBase("element_83", Material.ROCK);
}
