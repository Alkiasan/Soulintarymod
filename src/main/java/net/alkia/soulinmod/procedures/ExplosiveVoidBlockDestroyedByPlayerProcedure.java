package net.alkia.soulinmod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.world.Explosion;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.alkia.soulinmod.SoulinmodModElements;

import java.util.Map;

@SoulinmodModElements.ModElement.Tag
public class ExplosiveVoidBlockDestroyedByPlayerProcedure extends SoulinmodModElements.ModElement {
	public ExplosiveVoidBlockDestroyedByPlayerProcedure(SoulinmodModElements instance) {
		super(instance, 71);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ExplosiveVoidBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ExplosiveVoidBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ExplosiveVoidBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ExplosiveVoidBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ExplosiveVoidBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
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
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null, (int) x, (int) y, (int) z, (float) 5, Explosion.Mode.BREAK);
			}
			entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 12);
		}
	}
}
