
package net.alkia.soulinmod.item;

@SoulinmodModElements.ModElement.Tag
public class BucketemptynectarItem extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:bucketemptynectar")
	public static final Item block = null;

	public BucketemptynectarItem(SoulinmodModElements instance) {
		super(instance, 87);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(SoulItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("bucketemptynectar");
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
