
package net.alkia.soulinmod.world.biome;

@SoulinmodModElements.ModElement.Tag
public class ProtectedBiomeBiome extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:protected_biome")
	public static final CustomBiome biome = null;

	public ProtectedBiomeBiome(SoulinmodModElements instance) {
		super(instance, 49);
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
					.category(Biome.Category.FOREST).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));

			setRegistryName("protected_biome");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);

			DefaultBiomeFeatures.addLakes(this);

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DEFAULT_FLOWER,
					IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(14)));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS,
					new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(4)));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR,
							new MultipleRandomFeatureConfig(new Feature[]{Feature.BIRCH_TREE, Feature.FANCY_TREE},
									new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F, 0.1F},
									Feature.NORMAL_TREE, IFeatureConfig.NO_FEATURE_CONFIG),
							Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(3, 0.1F, 1)));

		}

	}

}
