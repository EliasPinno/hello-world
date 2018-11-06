package commands;

import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.event.message.MessageEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class copy implements commands{
	public final String name = "copy";
	public final String[] aliases = {"c"};
	public static PermissionType[] reqPerms = {PermissionType.SEND_MESSAGES};
	public static PermissionType[] botPerms = {PermissionType.ADMINISTRATOR};
	public static int minArgs = 0;
	public static int maxArgs = 1000;
	
	@Override
	public void run(MessageEvent event, String[] params) {
		String response = "";
		for (int i = 1; i<params.length ; i++) {
			response += params[i] + " ";
		}
		event.getChannel().sendMessage(response);
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