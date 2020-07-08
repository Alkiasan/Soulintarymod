
package net.alkia.soulinmod.item;

@SoulinmodModElements.ModElement.Tag
public class MemoryOfTheLostItem extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:memory_of_the_lost")
	public static final Item block = null;

	public MemoryOfTheLostItem(SoulinmodModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, SoulinmodModElements.sounds.get(new ResourceLocation("soulinmod:memoryofthelost")),
					new Item.Properties().group(SoulintaryMusicItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("memory_of_the_lost");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Arc Completion Reward:"));
			list.add(new StringTextComponent("A music disc that plays a"));
			list.add(new StringTextComponent("sombre melody"));
		}

	}

}
