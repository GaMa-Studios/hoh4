
package gama.studios.hoh4core.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BackCrystalBlock extends FallingBlock {
	public BackCrystalBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST_CLUSTER).strength(-1, 3600000).lightLevel(s -> 5));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		BackCrystalPriShchielchkiePKMPoBlokuProcedure.execute(entity);
		return InteractionResult.SUCCESS;
	}
}