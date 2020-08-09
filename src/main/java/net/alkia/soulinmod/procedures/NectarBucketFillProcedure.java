package net.alkia.soulinmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.alkia.soulinmod.item.NectarBucketItem;
import net.alkia.soulinmod.item.BucketemptynectarItem;
import net.alkia.soulinmod.SoulinmodModElements;

import java.util.Map;

@SoulinmodModElements.ModElement.Tag
public class NectarBucketFillProcedure extends SoulinmodModElements.ModElement {
	public NectarBucketFillProcedure(SoulinmodModElements instance) {
		super(instance, 85);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NectarBucketFill!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NectarBucketFill!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NectarBucketFill!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NectarBucketFill!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NectarBucketFill!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(BucketemptynectarItem.block, (int) (1)).getItem())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory
						.clearMatchingItems(p -> new ItemStack(BucketemptynectarItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(NectarBucketItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
