
package net.mcreator.hardmode.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.hardmode.procedures.AnitePickaxeBlockDestroyedWithToolProcedure;
import net.mcreator.hardmode.HardmodeElements;

@HardmodeElements.ModElement.Tag
public class AniteSwordItem extends HardmodeElements.ModElement {
	@ObjectHolder("hardmode:anitesword")
	public static final Item block = null;
	public AniteSwordItem(HardmodeElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 7436;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 24f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity entity2) {
				boolean retval = super.hitEntity(itemstack, entity, entity2);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				World world = entity.world;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					AnitePickaxeBlockDestroyedWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("anitesword"));
	}
}
