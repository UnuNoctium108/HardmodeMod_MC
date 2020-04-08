package net.mcreator.hardmode.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.hardmode.HardmodeElements;

@HardmodeElements.ModElement.Tag
public class EmelitePotionPotionExpiresProcedure extends HardmodeElements.ModElement {
	public EmelitePotionPotionExpiresProcedure(HardmodeElements instance) {
		super(instance, 15);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EmelitePotionPotionExpires!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.allowFlying = (false);
			((PlayerEntity) entity).sendPlayerAbilities();
		}
	}
}
