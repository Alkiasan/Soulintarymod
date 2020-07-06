package net.alkia.soulinmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.alkia.soulinmod.SoulinmodModElements;

@SoulinmodModElements.ModElement.Tag
public class SpookyblockPlayerStartsToDestroyProcedure extends SoulinmodModElements.ModElement {
	public SpookyblockPlayerStartsToDestroyProcedure(SoulinmodModElements instance) {
		super(instance, 39);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SpookyblockPlayerStartsToDestroy!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 100, (int) 3));
	}
}
