
package net.alkia.soulinmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;

import net.alkia.soulinmod.itemgroup.SoulintaryMusicItemGroup;
import net.alkia.soulinmod.SoulinmodModElements;

import java.util.List;

@SoulinmodModElements.ModElement.Tag
public class DarkMatterItem extends SoulinmodModElements.ModElement {
	@ObjectHolder("soulinmod:dark_matter")
	public static final Item block = null;
	public DarkMatterItem(SoulinmodModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, SoulinmodModElements.sounds.get(new ResourceLocation("soulinmod:darkmattermusic")),
					new Item.Properties().group(SoulintaryMusicItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("dark_matter");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("??5A music disc that plays a confused melody."));
		}
	}
}
