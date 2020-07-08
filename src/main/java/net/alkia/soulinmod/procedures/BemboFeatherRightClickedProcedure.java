package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class BemboFeatherRightClickedProcedure extends SoulinmodModElements.ModElement {

	public BemboFeatherRightClickedProcedure(SoulinmodModElements instance) {
		super(instance, 45);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BemboFeatherRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BemboFeatherRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BemboFeatherRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BemboFeatherRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BemboFeatherRightClicked!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		double tickvar = 0;
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, x, y, z, (int) 10, 2, 2, 2, 4);
		}
		entity.setMotion(0, 2, 0);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 2, (int) 1));

	}

}
