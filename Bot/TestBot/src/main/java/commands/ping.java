package commands;

import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.event.message.MessageEvent;

public class ping implements commands{
	public final String name = "ping";
	public final String[] aliases = {"p"};
	public static PermissionType[] reqPerms = {PermissionType.SEND_MESSAGES};
	public static PermissionType[] botPerms = {PermissionType.ADMINISTRATOR};
	public static int minArgs = 0;
	public static int maxArgs = 0;
	
	@Override
	public void run(MessageEvent event, String[] params) {
		event.getChannel().sendMessage("Pong!");
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