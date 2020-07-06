
package net.alkia.soulinmod.potion;

@SoulinmodModElements.ModElement.Tag
public class NectardPotion extends SoulinmodModElements.ModElement {

	@ObjectHolder("soulinmod:nectard")
	public static final Effect potion = null;

	public NectardPotion(SoulinmodModElements instance) {
		super(instance, 60);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	public static class EffectCustom extends Effect {

		private final ResourceLocation potionIcon;

		public EffectCustom() {
			super(EffectType.HARMFUL, -1);
			setRegistryName("nectard");
			potionIcon = new ResourceLocation("soulinmod:textures/tempicon.png");
		}

		@Override
		public String getName() {
			return "effect.nectard";
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