package net.mcreator.hardmode.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.hardmode.HardmodeElements;

@HardmodeElements.ModElement.Tag
public class BriteHoeRightClickedInAirProcedure extends HardmodeElements.ModElement {
	public BriteHoeRightClickedInAirProcedure(HardmodeElements instance) {
		super(instance, 47);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BriteHoeRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BriteHoeRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BriteHoeRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BriteHoeRightClickedInAir!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), Blocks.FARMLAND.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)), Blocks.FARMLAND.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.FARMLAND.getDefaultState(), 3);
	}
}
