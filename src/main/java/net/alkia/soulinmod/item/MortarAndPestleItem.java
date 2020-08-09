
package net.alkia.soulinmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.alkia.soulinmod.itemgroup.SoulItemsItemGroup;
import net.alkia.soulinmod.SoulinmodModElements;

import java.util.List;

@SoulinmodModElements.ModElement.Tag
public class MortarAndPestleItem extends SoulinmodModElements.ModElement {
	@ObjectHolder("soulinmod:mortar_and_pestle")
	public static final Item block = null;
	public MortarAndPestleItem(SoulinmodModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SoulItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("mortar_and_pestle");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(this);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A Mortar and Pestle, meant to grind objects into"));
			list.add(new StringTextComponent("dust, and dust to something more refined..."));
			list.add(new StringTextComponent("If you have the strength for it that is"));
		}
	}
}
