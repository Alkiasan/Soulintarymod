
package net.alkia.soulinmod.itemgroup;

@SoulinmodModElements.ModElement.Tag
public class SoulItemsItemGroup extends SoulinmodModElements.ModElement {

	public SoulItemsItemGroup(SoulinmodModElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsoul_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(VoidEssenseItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
