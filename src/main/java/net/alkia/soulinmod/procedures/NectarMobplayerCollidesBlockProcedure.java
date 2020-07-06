package net.alkia.soulinmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.alkia.soulinmod.potion.NectardPotion;
import net.alkia.soulinmod.SoulinmodModElements;

@SoulinmodModElements.ModElement.Tag
public class NectarMobplayerCollidesBlockProcedure extends SoulinmodModElements.ModElement {
	public NectarMobplayerCollidesBlockProcedure(SoulinmodModElements instance) {
		super(instance, 52);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NectarMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(NectardPotion.potion, (int) 10, (int) 1));
	}
}
