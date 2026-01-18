
package gama.studios.hoh4core.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class OakCollumnBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

	public OakCollumnBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
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
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(0, 0, 0, 16, 3, 4), box(0, 3, 0, 16, 5, 4), box(0, 0, 12, 16, 3, 16), box(0, 3, 12, 16, 5, 16), box(0, 0, 8, 16, 3, 12), box(0, 0, 4, 16, 3, 8));
				case WALL -> Shapes.or(box(0, 12, 0, 16, 16, 3), box(0, 12, 3, 16, 16, 5), box(0, 0, 0, 16, 4, 3), box(0, 0, 3, 16, 4, 5), box(0, 4, 0, 16, 8, 3), box(0, 8, 0, 16, 12, 3));
				case CEILING -> Shapes.or(box(0, 13, 0, 16, 16, 4), box(0, 11, 0, 16, 13, 4), box(0, 13, 12, 16, 16, 16), box(0, 11, 12, 16, 13, 16), box(0, 13, 8, 16, 16, 12), box(0, 13, 4, 16, 16, 8));
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(0, 0, 12, 16, 3, 16), box(0, 3, 12, 16, 5, 16), box(0, 0, 0, 16, 3, 4), box(0, 3, 0, 16, 5, 4), box(0, 0, 4, 16, 3, 8), box(0, 0, 8, 16, 3, 12));
				case WALL -> Shapes.or(box(0, 12, 13, 16, 16, 16), box(0, 12, 11, 16, 16, 13), box(0, 0, 13, 16, 4, 16), box(0, 0, 11, 16, 4, 13), box(0, 4, 13, 16, 8, 16), box(0, 8, 13, 16, 12, 16));
				case CEILING -> Shapes.or(box(0, 13, 12, 16, 16, 16), box(0, 11, 12, 16, 13, 16), box(0, 13, 0, 16, 16, 4), box(0, 11, 0, 16, 13, 4), box(0, 13, 4, 16, 16, 8), box(0, 13, 8, 16, 16, 12));
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(0, 0, 0, 4, 3, 16), box(0, 3, 0, 4, 5, 16), box(12, 0, 0, 16, 3, 16), box(12, 3, 0, 16, 5, 16), box(8, 0, 0, 12, 3, 16), box(4, 0, 0, 8, 3, 16));
				case WALL -> Shapes.or(box(0, 12, 0, 3, 16, 16), box(3, 12, 0, 5, 16, 16), box(0, 0, 0, 3, 4, 16), box(3, 0, 0, 5, 4, 16), box(0, 4, 0, 3, 8, 16), box(0, 8, 0, 3, 12, 16));
				case CEILING -> Shapes.or(box(0, 13, 0, 4, 16, 16), box(0, 11, 0, 4, 13, 16), box(12, 13, 0, 16, 16, 16), box(12, 11, 0, 16, 13, 16), box(8, 13, 0, 12, 16, 16), box(4, 13, 0, 8, 16, 16));
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(12, 0, 0, 16, 3, 16), box(12, 3, 0, 16, 5, 16), box(0, 0, 0, 4, 3, 16), box(0, 3, 0, 4, 5, 16), box(4, 0, 0, 8, 3, 16), box(8, 0, 0, 12, 3, 16));
				case WALL -> Shapes.or(box(13, 12, 0, 16, 16, 16), box(11, 12, 0, 13, 16, 16), box(13, 0, 0, 16, 4, 16), box(11, 0, 0, 13, 4, 16), box(13, 4, 0, 16, 8, 16), box(13, 8, 0, 16, 12, 16));
				case CEILING -> Shapes.or(box(12, 13, 0, 16, 16, 16), box(12, 11, 0, 16, 13, 16), box(0, 13, 0, 4, 16, 16), box(0, 11, 0, 4, 13, 16), box(4, 13, 0, 8, 16, 16), box(8, 13, 0, 12, 16, 16));
			};
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, FACE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACE, faceForDirection(context.getNearestLookingDirection())).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	private AttachFace faceForDirection(Direction direction) {
		if (direction.getAxis() == Direction.Axis.Y)
			return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
		else
			return AttachFace.WALL;
	}
}
