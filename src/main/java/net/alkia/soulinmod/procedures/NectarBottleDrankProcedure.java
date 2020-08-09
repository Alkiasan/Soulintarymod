package net.alkia.soulinmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.alkia.soulinmod.item.NectarBottleEmptyItem;
import net.alkia.soulinmod.SoulinmodModElements;

import java.util.Map;

@SoulinmodModElements.ModElement.Tag
public class NectarBottleDrankProcedure extends SoulinmodModElements.ModElement {
	public NectarBottleDrankProcedure(SoulinmodModElements instance) {
		super(instance, 94);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NectarBottleDrank!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 600, (int) 2));
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(NectarBottleEmptyItem.block, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
