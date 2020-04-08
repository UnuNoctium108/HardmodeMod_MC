package net.mcreator.hardmode.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.Entity;

import net.mcreator.hardmode.HardmodeVariables;
import net.mcreator.hardmode.HardmodeElements;

@HardmodeElements.ModElement.Tag
public class HardmodeTriggerProcedure extends HardmodeElements.ModElement {
	public HardmodeTriggerProcedure(HardmodeElements instance) {
		super(instance, 6);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HardmodeTrigger!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HardmodeTrigger!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((entity instanceof EnderDragonEntity)) {
			HardmodeVariables.MapVariables.get(world).IsHardmode = (boolean) (true);
			HardmodeVariables.MapVariables.get(world).syncData(world);
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;
			World world = entity.world;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
