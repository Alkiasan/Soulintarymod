
package net.alkia.soulinmod.item;

@SoulinmodModElements.ModElement.Tag
public class BlueDyeEdibleItem extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:blue_dye_edible")
	public static final Item block = null;

	public BlueDyeEdibleItem(SoulinmodModElements instance) {
		super(instance, 16);
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
			setRegistryName("blue_dye_edible");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A normal but more refiend dye"));
			list.add(new StringTextComponent("you'd probably think twice about"));
			list.add(new StringTextComponent("eating straight up dye but Lily seems to enjoy it"));
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

	}

}
