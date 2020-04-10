package net.mcreator.hardmode.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.Material;

import net.mcreator.hardmode.HardmodeElements;

@HardmodeElements.ModElement.Tag
public class BriteGemItemInInventoryTickProcedure extends HardmodeElements.ModElement {
	public BriteGemItemInInventoryTickProcedure(HardmodeElements instance) {
		super(instance, 26);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BriteGemItemInInventoryTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BriteGemItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		double x = 0;
		double y = 0;
		double z = 0;
		x = (double) (Math.round((1 * Math.random())) - 1);
		y = (double) (Math.round((1 * Math.random())) - 1);
		z = (double) (Math.round((1 * Math.random())) - 1);
		if (((world.getBlockState(new BlockPos((int) (x), (int) (y), (int) (y)))).getMaterial() == Material.PLANTS)) {
			if (entity instanceof PlayerEntity) {
				BlockPos _bp = new BlockPos((int) (x), (int) (y), (int) (z));
				world.getBlockState(_bp).getBlock().onBlockActivated(world.getBlockState(_bp), world, _bp, (PlayerEntity) entity, Hand.MAIN_HAND,
						BlockRayTraceResult.createMiss(new Vec3d(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
			}
		}
	}
}
