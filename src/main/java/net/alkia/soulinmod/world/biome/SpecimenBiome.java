
package net.alkia.soulinmod.world.biome;

@SoulinmodModElements.ModElement.Tag
public class SpecimenBiome extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:specimen")
	public static final CustomBiome biome = null;

	public SpecimenBiome(SoulinmodModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.FOREST).waterColor(-12291626).waterFogColor(-12291626)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));

			setRegistryName("specimen");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);

			DefaultBiomeFeatures.addLakes(this);

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DEFAULT_FLOWER,
					IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(7)));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS,
					new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(7)));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR,
							new MultipleRandomFeatureConfig(new Feature[]{Feature.FANCY_TREE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG},
									new float[]{0.1F}, Feature.NORMAL_TREE, IFeatureConfig.NO_FEATURE_CONFIG),
							Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(3, 0.1F, 1)));

			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.ZOMBIE, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COD, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.DONKEY, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.DOLPHIN, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.FOX, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.LLAMA, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.RABBIT, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SALMON, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SQUID, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.TROPICAL_FISH, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.TURTLE, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.WOLF, 15, 1, 15));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(BlockPos pos) {
			return -11423895;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor(BlockPos pos) {
			return -11423895;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -5916161;
		}

	}

}
