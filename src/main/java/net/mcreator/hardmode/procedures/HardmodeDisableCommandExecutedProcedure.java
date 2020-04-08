package net.mcreator.hardmode.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.hardmode.HardmodeVariables;
import net.mcreator.hardmode.HardmodeElements;

@HardmodeElements.ModElement.Tag
public class HardmodeDisableCommandExecutedProcedure extends HardmodeElements.ModElement {
	public HardmodeDisableCommandExecutedProcedure(HardmodeElements instance) {
		super(instance, 9);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HardmodeDisableCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HardmodeDisableCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		HardmodeVariables.MapVariables.get(world).IsHardmode = (boolean) (false);
		HardmodeVariables.MapVariables.get(world).syncData(world);
		{
			java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("world", world);
			HardmodeQueryCommandExecutedProcedure.executeProcedure($_dependencies);
		}
	}
}
