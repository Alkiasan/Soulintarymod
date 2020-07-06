
package net.alkia.soulinmod.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.Minecraft;

import net.alkia.soulinmod.potion.EnglishPotionPotion;
import net.alkia.soulinmod.SoulinmodModElements;

import java.util.Collection;

import com.mojang.blaze3d.platform.GlStateManager;

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
	@SubscribeEvent(priority = EventPriority.NORMAL)
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
							if (effect.getPotion() == EnglishPotionPotion.potion)
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
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("soulinmod:textures/englishwithibrahim.png"));
				Minecraft.getInstance().ingameGUI.blit(posX + -110, posY + 64, 0, 0, 256, 256);
				GlStateManager.depthMask(true);
				GlStateManager.enableDepthTest();
				GlStateManager.enableAlphaTest();
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}
