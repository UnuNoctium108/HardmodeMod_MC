package net.mcreator.hardmode.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.mcreator.hardmode.block.EmeliteOreBlock;
import net.mcreator.hardmode.block.AniteOreBlock;
import net.mcreator.hardmode.HardmodeVariables;
import net.mcreator.hardmode.HardmodeElements;

@HardmodeElements.ModElement.Tag
public class MisteriousRockUpdateTickProcedure extends HardmodeElements.ModElement {
	public MisteriousRockUpdateTickProcedure(HardmodeElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MisteriousRockUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MisteriousRockUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MisteriousRockUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MisteriousRockUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((HardmodeVariables.MapVariables.get(world).IsHardmode) == (true))) {
			if (((1 * Math.random()) == 0)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), EmeliteOreBlock.block.getDefaultState(), 3);
			} else if (((1 * Math.random()) == 1)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), AniteOreBlock.block.getDefaultState(), 3);
			}
		}
	}
}
