
package net.alkia.soulinmod.gui.overlay;

@SoulinmodModElements.ModElement.Tag
public class NectarOverlayOverlay extends SoulinmodModElements.ModElement {

	public NectarOverlayOverlay(SoulinmodModElements instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void eventHandler(RenderGameOverlayEvent event) {

		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {

			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;

			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;

			if ((new Object() {
				boolean check() {
					if (entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == NectardPotion.potion)
								return true;
						}
					}
					return false;
				}
			}.check())) {
				GlStateManager.disableDepthTest();
				GlStateManager.depthMask(false);
				GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				GlStateManager.disableAlphaTest();

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("soulinmod:textures/nectaroverlay.png"));
				Minecraft.getInstance().ingameGUI.blit(0, 0, 0, 0, 256, 256, event.getWindow().getScaledWidth(), event.getWindow().getScaledHeight());

				GlStateManager.depthMask(true);
				GlStateManager.enableDepthTest();
				GlStateManager.enableAlphaTest();
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

				GlStateManager.disableDepthTest();
				GlStateManager.depthMask(false);
				GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				GlStateManager.disableAlphaTest();

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("soulinmod:textures/nectaroverlay.png"));
				Minecraft.getInstance().ingameGUI.blit(posX + -214, posY + 48, 0, 0, 256, 256);

				GlStateManager.depthMask(true);
				GlStateManager.enableDepthTest();
				GlStateManager.enableAlphaTest();
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				GlStateManager.disableDepthTest();
				GlStateManager.depthMask(false);
				GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				GlStateManager.disableAlphaTest();

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("soulinmod:textures/nectaroverlay.png"));
				Minecraft.getInstance().ingameGUI.blit(posX + 34, posY + 48, 0, 0, 256, 256);

				GlStateManager.depthMask(true);
				GlStateManager.enableDepthTest();
				GlStateManager.enableAlphaTest();
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				Minecraft.getInstance().fontRenderer.drawString("Graphic design is my passion", posX + -78, posY + -77, -1);
			}
		}

	}

}
