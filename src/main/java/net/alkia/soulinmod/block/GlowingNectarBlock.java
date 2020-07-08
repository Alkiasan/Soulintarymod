
package net.alkia.soulinmod.block;

@SoulinmodModElements.ModElement.Tag
public class GlowingNectarBlock extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:glowing_nectar")
	public static final FlowingFluidBlock block = null;

	@ObjectHolder("soulinmod:glowing_nectar_bucket")
	public static final Item bucket = null;

	private FlowingFluid flowing = null;
	private FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;

	public GlowingNectarBlock(SoulinmodModElements instance) {
		super(instance, 33);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerFluids(RegistryEvent.Register<Fluid> event) {
		event.getRegistry().register(still);
		event.getRegistry().register(flowing);
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing, FluidAttributes
				.builder(new ResourceLocation("soulinmod:blocks/nectarglowingblue"), new ResourceLocation("soulinmod:blocks/nectar_glow_flowv2"))
				.luminosity(15).density(30).viscosity(2))

						.block(() -> block);

		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("glowing_nectar");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("glowing_nectar_flowing");

		elements.blocks.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.WATER)) {

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
		}.setRegistryName("glowing_nectar"));

	}

}
