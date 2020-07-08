
package net.alkia.soulinmod.block;

@SoulinmodModElements.ModElement.Tag
public class GlowingNectarPlacableBlock extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:glowing_nectar_placable")
	public static final Block block = null;

	public GlowingNectarPlacableBlock(SoulinmodModElements instance) {
		super(instance, 90);

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

			setRegistryName("glowing_nectar_placable");
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

				GlowingNectarMobplayerCollidesBlockProcedure.executeProcedure($_dependencies);
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

				GlowingNectarMobplayerCollidesBlockProcedure.executeProcedure($_dependencies);
			}
		}

	}

}
