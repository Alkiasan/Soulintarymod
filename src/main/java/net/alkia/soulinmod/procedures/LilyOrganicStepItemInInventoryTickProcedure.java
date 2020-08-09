package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class LilyOrganicStepItemInInventoryTickProcedure extends SoulinmodModElements.ModElement {

	public LilyOrganicStepItemInInventoryTickProcedure(SoulinmodModElements instance) {
		super(instance, 100);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure LilyOrganicStepItemInInventoryTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure LilyOrganicStepItemInInventoryTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure LilyOrganicStepItemInInventoryTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure LilyOrganicStepItemInInventoryTick!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.DIRT.getDefaultState().getBlock())) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.COMPOSTER, x, y, z, (int) 5, 1, 1, 1, 1);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
				BlockState _bs = Blocks.GRASS_BLOCK.getDefaultState();

				world.setBlockState(_bp, _bs, 3);

			}
		}

	}

}
