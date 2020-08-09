
package net.alkia.soulinmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.alkia.soulinmod.itemgroup.SoulItemsItemGroup;
import net.alkia.soulinmod.SoulinmodModElements;

@SoulinmodModElements.ModElement.Tag
public class FlowerCrownItem extends SoulinmodModElements.ModElement {
	@ObjectHolder("soulinmod:flower_crown_helmet")
	public static final Item helmet = null;
	@ObjectHolder("soulinmod:flower_crown_chestplate")
	public static final Item body = null;
	@ObjectHolder("soulinmod:flower_crown_leggings")
	public static final Item legs = null;
	@ObjectHolder("soulinmod:flower_crown_boots")
	public static final Item boots = null;
	public FlowerCrownItem(SoulinmodModElements instance) {
		super(instance, 98);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 5;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place"));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.POPPY, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "flower_crown";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(SoulItemsItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "soulinmod:textures/models/armor/falower__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("flower_crown_helmet"));
	}
}
