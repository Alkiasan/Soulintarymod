
package net.alkia.soulinmod.item;

@SoulinmodModElements.ModElement.Tag
public class DarkMatterItem extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:dark_matter")
	public static final Item block = null;

	public DarkMatterItem(SoulinmodModElements instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, SoulinmodModElements.sounds.get(new ResourceLocation("soulinmod:darkmattermusic")),
					new Item.Properties().group(SoulintaryMusicItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("dark_matter");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Arc Completion Reward:"));
			list.add(new StringTextComponent("A music disc that plays a confused melody."));
		}

	}

}
