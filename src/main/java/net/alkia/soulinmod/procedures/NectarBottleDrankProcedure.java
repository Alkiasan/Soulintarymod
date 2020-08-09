package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class NectarBottleDrankProcedure extends SoulinmodModElements.ModElement {

	public NectarBottleDrankProcedure(SoulinmodModElements instance) {
		super(instance, 94);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NectarBottleDrank!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 600, (int) 2));
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(NectarBottleEmptyItem.block, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}

	}

}
