package net.alkia.soulinmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;

import net.alkia.soulinmod.item.NectarBucketItem;
import net.alkia.soulinmod.block.NectarBlock;
import net.alkia.soulinmod.SoulinmodModElements;

import java.util.Map;

@SoulinmodModElements.ModElement.Tag
public class NectarBucketPlaceProcedure extends SoulinmodModElements.ModElement {
	public NectarBucketPlaceProcedure(SoulinmodModElements instance) {
		super(instance, 84);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NectarBucketPlace!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NectarBucketPlace!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NectarBucketPlace!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NectarBucketPlace!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NectarBucketPlace!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), NectarBlock.block.getDefaultState(), 3);
			if ((new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(Items.BUCKET, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory
							.clearMatchingItems(p -> new ItemStack(NectarBucketItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
			}
		}
	}
}
