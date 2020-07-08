
package net.alkia.soulinmod.item;

@SoulinmodModElements.ModElement.Tag
public class BadappleItem extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:badapple")
	public static final Item block = null;

	public BadappleItem(SoulinmodModElements instance) {
		super(instance, 91);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, SoulinmodModElements.sounds.get(new ResourceLocation("soulinmod:badapple")),
					new Item.Properties().group(SoulintaryMusicItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("badapple");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Arc Completion Reward:"));
			list.add(new StringTextComponent("A music disc that plays a"));
			list.add(new StringTextComponent("self-reflecting melody"));
		}

	}

}
