package net.mcreator.hardmode.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;

import net.mcreator.hardmode.item.BriteShovelItem;
import net.mcreator.hardmode.HardmodeElements;

@HardmodeElements.ModElement.Tag
public class BriteShovelRightClickedOnBlockProcedure extends HardmodeElements.ModElement {
	public BriteShovelRightClickedOnBlockProcedure(HardmodeElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BriteShovelRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BriteShovelRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BriteShovelRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BriteShovelRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double xC = 0;
		double zC = 0;
		double yC = 0;
		double tries = 0;
		xC = (double) (x + (Math.round((2 * Math.random())) - 1));
		yC = (double) (y + (Math.round((2 * Math.random())) - 1));
		zC = (double) (z + (Math.round((2 * Math.random())) - 1));
		while (((!(new ItemStack(BriteShovelItem.block, (int) (1)).getItem()
				.canHarvestBlock((world.getBlockState(new BlockPos((int) (xC), (int) (yC), (int) (zC))))))) && ((tries) <= 256))) {
			xC = (double) (x + (Math.round((2 * Math.random())) - 1));
			yC = (double) (y + (Math.round((2 * Math.random())) - 1));
			zC = (double) (z + (Math.round((2 * Math.random())) - 1));
			tries = (double) ((tries) + 1);
		}
		Block.spawnDrops(world.getBlockState(new BlockPos((int) (xC), (int) (yC), (int) (zC))), world,
				new BlockPos((int) (xC), (int) (yC), (int) (zC)));
		world.destroyBlock(new BlockPos((int) (xC), (int) (yC), (int) (zC)), false);
	}
}
