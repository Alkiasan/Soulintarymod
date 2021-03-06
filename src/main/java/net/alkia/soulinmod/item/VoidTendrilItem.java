
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
public class VoidTendrilItem extends SoulinmodModElements.ModElement {
	@ObjectHolder("soulinmod:void_tendril")
	public static final Item block = null;
	public VoidTendrilItem(SoulinmodModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SoulItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("void_tendril");
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
			list.add(new StringTextComponent("Holding onto a single tendril, it wraps around your fingers"));
			list.add(new StringTextComponent("and squeezes. There isn't much for it to do"));
			list.add(new StringTextComponent(",although the thought of it still being active is..."));
			list.add(new StringTextComponent("unsettling to say the least."));
		}
	}
}
