
package net.alkia.soulinmod.item;

@SoulinmodModElements.ModElement.Tag
public class NectarBottleItem extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:nectar_bottle")
	public static final Item block = null;

	public NectarBottleItem(SoulinmodModElements instance) {
		super(instance, 88);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(SoulItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("nectar_bottle");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
