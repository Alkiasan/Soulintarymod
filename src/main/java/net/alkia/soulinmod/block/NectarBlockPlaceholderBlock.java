
package net.alkia.soulinmod.block;

@SoulinmodModElements.ModElement.Tag
public class NectarBlockPlaceholderBlock extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:nectar_block_placeholder")
	public static final Block block = null;

	public NectarBlockPlaceholderBlock(SoulinmodModElements instance) {
		super(instance, 86);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(SoulItemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.WET_GRASS).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.SHOVEL));

			setRegistryName("nectar_block_placeholder");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
			super.onEntityCollision(state, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);

				NectarMobplayerCollidesBlockProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onEntityWalk(World world, BlockPos pos, Entity entity) {
			super.onEntityWalk(world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);

				NectarMobplayerCollidesBlockProcedure.executeProcedure($_dependencies);
			}
		}

	}

}
