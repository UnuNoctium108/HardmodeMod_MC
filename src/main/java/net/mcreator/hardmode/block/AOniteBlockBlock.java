
package net.mcreator.hardmode.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.hardmode.item.AOniteItem;
import net.mcreator.hardmode.HardmodeElements;

import java.util.List;
import java.util.Collections;

@HardmodeElements.ModElement.Tag
public class AOniteBlockBlock extends HardmodeElements.ModElement {
	@ObjectHolder("hardmode:aoniteblock")
	public static final Block block = null;
	public AOniteBlockBlock(HardmodeElements instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(22.5f, 10f).lightValue(0).harvestLevel(5)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("aoniteblock");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(AOniteItem.block, (int) (1)));
		}
	}
}
