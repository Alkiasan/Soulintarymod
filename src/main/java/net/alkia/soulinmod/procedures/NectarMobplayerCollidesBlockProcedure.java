package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class NectarMobplayerCollidesBlockProcedure extends SoulinmodModElements.ModElement {

	public NectarMobplayerCollidesBlockProcedure(SoulinmodModElements instance) {
		super(instance, 68);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NectarMobplayerCollidesBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 1));

	}

}
