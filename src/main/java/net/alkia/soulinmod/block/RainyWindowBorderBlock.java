
package net.alkia.soulinmod.block;

@SoulinmodModElements.ModElement.Tag
public class RainyWindowBorderBlock extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:rainy_window_border")
	public static final Block block = null;

	public RainyWindowBorderBlock(SoulinmodModElements instance) {
		super(instance, 35);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(SoulItemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.REDSTONE_LIGHT).sound(SoundType.GLASS).hardnessAndResistance(0.3f, 0.3f).lightValue(7)
							.slipperiness(1.5f));

			setRegistryName("rainy_window_border");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack itemstack, IBlockReader world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("template"));
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
