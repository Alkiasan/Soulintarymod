
package net.alkia.soulinmod.item;

@SoulinmodModElements.ModElement.Tag
public class LightBlueDyeEdibleItem extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:light_blue_dye_edible")
	public static final Item block = null;

	public LightBlueDyeEdibleItem(SoulinmodModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(SoulItemsItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).setAlwaysEdible()

							.build()));
			setRegistryName("light_blue_dye_edible");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("??5An edible variant of light blue dye."));
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

	}

}
