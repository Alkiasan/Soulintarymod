package net.alkia.soulinmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.alkia.soulinmod.SoulinmodModElements;

@SoulinmodModElements.ModElement.Tag
public class VoidAnimatedEntityCollidesInTheBlockProcedure extends SoulinmodModElements.ModElement {
	public VoidAnimatedEntityCollidesInTheBlockProcedure(SoulinmodModElements instance) {
		super(instance, 81);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VoidAnimatedEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 1));
	}
}
