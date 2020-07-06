
package net.alkia.soulinmod.item;

@SoulinmodModElements.ModElement.Tag
public class GlitterAndGoldItem extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:glitter_and_gold")
	public static final Item block = null;

	public GlitterAndGoldItem(SoulinmodModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, SoulinmodModElements.sounds.get(new ResourceLocation("soulinmod:glitterandgold")),
					new Item.Properties().group(SoulintaryMusicItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("glitter_and_gold");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("??5A music disc that plays a invigorating melody"));
			list.add(new StringTextComponent("??5that makes you want to work hard!"));
		}

	}

}
