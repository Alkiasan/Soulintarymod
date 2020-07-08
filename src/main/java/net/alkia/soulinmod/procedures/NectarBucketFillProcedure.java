package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class NectarBucketFillProcedure extends SoulinmodModElements.ModElement {

	public NectarBucketFillProcedure(SoulinmodModElements instance) {
		super(instance, 85);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NectarBucketFill!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NectarBucketFill!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NectarBucketFill!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NectarBucketFill!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NectarBucketFill!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(BucketemptynectarItem.block, (int) (1)).getItem())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory
						.clearMatchingItems(p -> new ItemStack(BucketemptynectarItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(NectarBucketItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}

	}

}
