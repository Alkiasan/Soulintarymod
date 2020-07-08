package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class NectarBottlefillProcedure extends SoulinmodModElements.ModElement {

	public NectarBottlefillProcedure(SoulinmodModElements instance) {
		super(instance, 89);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NectarBottlefill!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NectarBottlefill!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NectarBottlefill!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NectarBottlefill!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NectarBottlefill!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == NectarBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(NectarBottleEmptyItem.block, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory
							.clearMatchingItems(p -> new ItemStack(NectarBottleEmptyItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(NectarBottleItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		}

	}

}
