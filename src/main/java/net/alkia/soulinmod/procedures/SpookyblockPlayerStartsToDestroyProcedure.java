package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class SpookyblockPlayerStartsToDestroyProcedure extends SoulinmodModElements.ModElement {

	public SpookyblockPlayerStartsToDestroyProcedure(SoulinmodModElements instance) {
		super(instance, 48);

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
