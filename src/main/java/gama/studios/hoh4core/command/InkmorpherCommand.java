
package gama.studios.hoh4core.command;

@Mod.EventBusSubscriber
public class InkmorpherCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("ink_morpher").requires(s -> s.hasPermission(4)).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();

			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();

			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);

			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			InkMorphProcedure.execute(entity);
			return 0;
		}));
	}

}
