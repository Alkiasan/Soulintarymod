
package net.alkia.soulinmod.block;

@SoulinmodModElements.ModElement.Tag
public class PlantCoreCBlock extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:plant_core_c")
	public static final Block block = null;

	public PlantCoreCBlock(SoulinmodModElements instance) {
		super(instance, 31);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(SoulItemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.AXE));

			setRegistryName("plant_core_c");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack itemstack, IBlockReader world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A large ball of leaves all held together by"));
			list.add(new StringTextComponent("some strange moving vines. The vines"));
			list.add(new StringTextComponent("slither down into the center devouring what looks"));
			list.add(new StringTextComponent("like some kind of meat... it smells of flowers"));
			list.add(new StringTextComponent("and rotting meat."));
		}

		@Override
		public int tickRate(IWorldReader world) {
			return 0;
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 20;
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.AIR, (int) (1)));
		}

	}

}
