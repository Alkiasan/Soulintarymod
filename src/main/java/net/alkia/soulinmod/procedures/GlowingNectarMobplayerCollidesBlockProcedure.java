package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class GlowingNectarMobplayerCollidesBlockProcedure extends SoulinmodModElements.ModElement {

	public GlowingNectarMobplayerCollidesBlockProcedure(SoulinmodModElements instance) {
		super(instance, 70);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GlowingNectarMobplayerCollidesBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 4));

	}

}
