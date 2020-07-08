package net.alkia.soulinmod.procedures;

@SoulinmodModElements.ModElement.Tag
public class AntiVoidDEATHProcedure extends SoulinmodModElements.ModElement {

	public AntiVoidDEATHProcedure(SoulinmodModElements instance) {
		super(instance, 82);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
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
