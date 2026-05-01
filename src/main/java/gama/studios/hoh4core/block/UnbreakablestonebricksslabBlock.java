
package gama.studios.hoh4core.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class UnbreakablestonebricksslabBlock extends SlabBlock {
	public UnbreakablestonebricksslabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1, 3600000));
	}
}
