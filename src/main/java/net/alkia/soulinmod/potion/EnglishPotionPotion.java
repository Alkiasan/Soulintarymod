
package net.alkia.soulinmod.potion;

@SoulinmodModElements.ModElement.Tag
public class EnglishPotionPotion extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:english_potion")
	public static final Effect potion = null;

	@ObjectHolder("soulinmod:english_potion")
	public static final Potion potionType = null;

	public EnglishPotionPotion(SoulinmodModElements instance) {
		super(instance, 59);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	@SubscribeEvent
	public void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}

	public static class PotionCustom extends Potion {

		public PotionCustom() {
			super(new EffectInstance(potion, 3600));
			setRegistryName("english_potion");
		}

	}

	public static class EffectCustom extends Effect {

		private final ResourceLocation potionIcon;

		public EffectCustom() {
			super(EffectType.HARMFUL, -1);
			setRegistryName("english_potion");
			potionIcon = new ResourceLocation("soulinmod:textures/tempicon.png");
		}

		@Override
		public String getName() {
			return "effect.english_potion";
		}

		@Override
		public boolean isBeneficial() {
			return false;
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}

	}

}
