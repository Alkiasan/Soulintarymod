package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class NectarBucketPlaceProcedure extends SoulinmodModElements.ModElement {

	public NectarBucketPlaceProcedure(SoulinmodModElements instance) {
		super(instance, 84);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NectarBucketPlace!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NectarBucketPlace!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NectarBucketPlace!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NectarBucketPlace!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NectarBucketPlace!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), NectarBlock.block.getDefaultState(), 3);
			if ((new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
					} else if (_ent instanceof ClientPlayerEntity) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(Items.BUCKET, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory
							.clearMatchingItems(p -> new ItemStack(NectarBucketItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
			}
		}

	}

}
