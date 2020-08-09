package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class RocketSwordToolInHandTickProcedure extends SoulinmodModElements.ModElement {

	public RocketSwordToolInHandTickProcedure(SoulinmodModElements instance) {
		super(instance, 102);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RocketSwordToolInHandTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.IRON_HELMET, (int) (1)).getItem()) == (false))) {
			if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.IRON_CHESTPLATE, (int) (1)).getItem()) == (false))) {
				if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(Items.IRON_LEGGINGS, (int) (1)).getItem()) == (false))) {
					if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
							.getItem() == new ItemStack(Items.IRON_BOOTS, (int) (1)).getItem()) == (false))) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 15));
					}
				}
			}
		}

	}

}
