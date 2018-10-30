package commands;

import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.event.message.MessageEvent;

public interface commands {
	//TODO try to make this a normal superclass, since all the methods return the same values for each command
	
	void run(MessageEvent event, String[] params); 
	
	String getName();
	
	String[] getAliases();
	
	PermissionType[] getReqPerms();
	
	PermissionType[] getBotPerms();
	
	int minArgs();
	
	int maxArgs();
}
