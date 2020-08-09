
package net.alkia.soulinmod.item;

@SoulinmodModElements.ModElement.Tag
public class RocketSwordItem extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:rocket_sword")
	public static final Item block = null;

	public RocketSwordItem(SoulinmodModElements instance) {
		super(instance, 101);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 0;
			}

			public float getEfficiency() {
				return 1f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.5f, new Item.Properties().group(ItemGroup.TOOLS)) {

			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.posX;
				double y = entity.posY;
				double z = entity.posZ;
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();

					$_dependencies.put("entity", entity);

					RocketSwordToolInHandTickProcedure.executeProcedure($_dependencies);
				}
			}

		}.setRegistryName("rocket_sword"));
	}

}
