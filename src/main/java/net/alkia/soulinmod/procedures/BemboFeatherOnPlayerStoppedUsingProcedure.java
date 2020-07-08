package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class BemboFeatherOnPlayerStoppedUsingProcedure extends SoulinmodModElements.ModElement {

	public BemboFeatherOnPlayerStoppedUsingProcedure(SoulinmodModElements instance) {
		super(instance, 46);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BemboFeatherOnPlayerStoppedUsing!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 5, (int) 1));

	}

}
