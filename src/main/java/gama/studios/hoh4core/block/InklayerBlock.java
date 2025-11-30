
package gama.studios.hoh4core.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class InklayerBlock extends FallingBlock {
	public InklayerBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SLIME_BLOCK).strength(1f, 7.5f).noCollission().friction(0.5f).speedFactor(0.5f).jumpFactor(0.5f));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.DANGER_FIRE;
	}
}