
package net.alkia.soulinmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.alkia.soulinmod.SoulinmodModElements;

@SoulinmodModElements.ModElement.Tag
public class SoulintaryMusicItemGroup extends SoulinmodModElements.ModElement {
	public SoulintaryMusicItemGroup(SoulinmodModElements instance) {
		super(instance, 52);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsoulintary_music") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.MUSIC_DISC_13, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
