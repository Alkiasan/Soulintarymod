
package net.alkia.soulinmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.alkia.soulinmod.procedures.AntiVoidDEATHProcedure;
import net.alkia.soulinmod.itemgroup.SoulItemsItemGroup;
import net.alkia.soulinmod.item.AntiVoidClumpItem;
import net.alkia.soulinmod.SoulinmodModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@SoulinmodModElements.ModElement.Tag
public class AntiVoidStairsBlock extends SoulinmodModElements.ModElement {
	@ObjectHolder("soulinmod:anti_void_stairs")
	public static final Block block = null;
	public AntiVoidStairsBlock(SoulinmodModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(SoulItemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK)).getDefaultState(), Block.Properties.create(Material.ROCK).sound(SoundType.SNOW)
					.hardnessAndResistance(2f, 50f).lightValue(15).harvestLevel(1).harvestTool(ToolType.PICKAXE));
			setRegistryName("anti_void_stairs");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack itemstack, IBlockReader world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Holding onto the mass of light... you almost don't"));
			list.add(new StringTextComponent("feel it at all. You feel the weight on your arms yet"));
			list.add(new StringTextComponent("feel nothing in your hands. It is extremely warm"));
			list.add(new StringTextComponent("to the touch."));
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(AntiVoidClumpItem.block, (int) (2)));
		}

		@Override
		public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
			super.onEntityCollision(state, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				AntiVoidDEATHProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onEntityWalk(World world, BlockPos pos, Entity entity) {
			super.onEntityWalk(world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				AntiVoidDEATHProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
