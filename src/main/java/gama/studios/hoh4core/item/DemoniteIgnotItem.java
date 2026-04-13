
package gama.studios.hoh4core.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DemoniteIgnotItem extends Item {
	public DemoniteIgnotItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON));
	}
}
