package commands;

import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.event.message.MessageEvent;

public class add implements commands {
	public final String name = "add";
	public final String[] aliases = {"addnum", "addition"};
	public static PermissionType[] reqPerms = {PermissionType.SEND_MESSAGES};
	public static PermissionType[] botPerms = {PermissionType.ADMINISTRATOR};
	public static int minArgs = 2;
	public static int maxArgs = 2;

	@Override
	public void run(MessageEvent event, String[] params) {
		int i1 = Integer.parseInt(params[0]);
		int i2 = Integer.parseInt(params[1]);
		event.getChannel().sendMessage("Answer is " + (i1 + i2));
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String[] getAliases() {
		return aliases;
	}

	@Override
	public PermissionType[] getReqPerms() {
		return reqPerms;
	}

	@Override
	public PermissionType[] getBotPerms() {
		return botPerms;
	}

	@Override
	public int minArgs() {
		return minArgs;
	}
	
	@Override
	public int maxArgs() {
		return maxArgs;
	}
}
