package net.alkia.soulinmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.alkia.soulinmod.SoulinmodModElements;

import java.util.Map;

@SoulinmodModElements.ModElement.Tag
public class AntiVoidDEATHProcedure extends SoulinmodModElements.ModElement {
	public AntiVoidDEATHProcedure(SoulinmodModElements instance) {
		super(instance, 82);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AntiVoidDEATH!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.MAGIC, (float) 10);
		entity.attackEntityFrom(DamageSource.MAGIC, (float) 10);
		entity.attackEntityFrom(DamageSource.MAGIC, (float) 10);
		entity.attackEntityFrom(DamageSource.MAGIC, (float) 10);
	}
}
