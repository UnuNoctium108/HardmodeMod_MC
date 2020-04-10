package net.mcreator.hardmode.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.hardmode.HardmodeVariables;
import net.mcreator.hardmode.HardmodeElements;

import java.util.HashMap;

@HardmodeElements.ModElement.Tag
public class HardmodeCommandExecutedProcedure extends HardmodeElements.ModElement {
	public HardmodeCommandExecutedProcedure(HardmodeElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HardmodeCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HardmodeCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HardmodeCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure HardmodeCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HardmodeCommandExecuted!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		World world = (World) dependencies.get("world");
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("status"))) {
			if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("set"))) {
				if ((((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("2");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText())).equals("true"))) {
					HardmodeVariables.MapVariables.get(world).IsHardmode = (boolean) (true);
					HardmodeVariables.MapVariables.get(world).syncData(world);
					if (!world.isRemote && world.getServer() != null) {
						world.getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
								"tellraw @p [{\"Text\":\"Hardmode status set to: true\"}]");
					}
				} else if ((((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("2");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText())).equals("false"))) {
					HardmodeVariables.MapVariables.get(world).IsHardmode = (boolean) (false);
					HardmodeVariables.MapVariables.get(world).syncData(world);
					if (!world.isRemote && world.getServer() != null) {
						world.getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
								"tellraw @p [{\"Text\":\"Hardmode status set to: false\"}]");
					}
				} else {
					if (!world.isRemote && world.getServer() != null) {
						world.getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
								"tellraw @p [{\"Text\":\"Hardmode status value has to be true or false.\",\"color\":\"red\"}]");
					}
				}
			} else if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("toggle"))) {
				HardmodeVariables.MapVariables.get(world).IsHardmode = (boolean) (!(HardmodeVariables.MapVariables.get(world).IsHardmode));
				HardmodeVariables.MapVariables.get(world).syncData(world);
				if (!world.isRemote && world.getServer() != null) {
					world.getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
							"tellraw @p [{\"Text\":\"Hardmode status toggled.\"}]");
				}
			} else if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("query"))) {
				if (!world.isRemote && world.getServer() != null) {
					world.getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
							"tellraw @p [{\"Text\":\"Hardmode status displayed above hotbar.\"}]");
				}
			} else {
				if (!world.isRemote && world.getServer() != null) {
					world.getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
							"tellraw @p [{\"Text\":\"Subcommands are: set, toggle, query. The entered parameter is invalid.\",\"color\":\"red\"}]");
				}
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("guide"))) {
			if (!world.isRemote && world.getServer() != null) {
				world.getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
						"tellraw @p [{\"Text\":\"Guide is not available yet. Sorry.\",\"color\":\"aqua\"}]");
			}
		} else {
			if (!world.isRemote && world.getServer() != null) {
				world.getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
						"tellraw @p [{\"Text\":\"Subcommands are: status, guide. The entered parameter is invalid.\",\"color\":\"red\"}]");
			}
		}
	}
}
