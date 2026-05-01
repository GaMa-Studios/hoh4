
package gama.studios.hoh4core.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class UnbreakableStoneBricksWallBlock extends WallBlock {
	public UnbreakableStoneBricksWallBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1, 3600000).forceSolidOn());
	}
}
