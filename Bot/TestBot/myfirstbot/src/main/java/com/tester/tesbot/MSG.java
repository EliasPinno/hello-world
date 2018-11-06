package com.tester.tesbot;

import java.util.*;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import commands.*;

public class MSG implements MessageCreateListener{
	//each command must be added by name to this arraylist, serves as a reference for the handler
    static ArrayList<commands> cList = new ArrayList<>(Arrays.asList(
    		new add(),
    		new ping()
    		));
    
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		//first grab the message as a string and the author as MessageAuthor
		String message = event.getMessage().getContent();
		MessageAuthor author = event.getMessage().getAuthor();
		
		//boolean checks if the message begins with the prefix, first
		boolean prefix = message.startsWith(Constants.prefix);
		//this checks if there are words beyond the first word but I haven't made the code to deal with this case yet
		boolean hasParams = (message.split(" ").length-1 > 0);
		
		if (!prefix) return;
    	if (author.isYourself()) return;
    	
		String commandName = message.split(" ")[0];
		
		String[] parameters = new String[message.split(" ").length-1];
		for(int i=0; i<message.split(" ").length-1; i++) {
			parameters[i] = message.split(" ")[i+1];
		}
		
		for(commands c: cList) {
			boolean match = commandName.equals(
					Constants.prefix + c.getName().toLowerCase());
			
			for(int i = 0; !match && i<c.getAliases().length; i++) {
				match = commandName.equals(
						Constants.prefix + c.getAliases()[i].toLowerCase());
			}
			
			if(match) {
				if(!userHasPerms(event, c, author.asUser().get())) {
					event.getChannel().sendMessage(Constants.userNoPerms);
					return;
				}
				if(!botHasPerms(event, c, event.getApi().getCachedUserById(Constants.testbotID).get() ) ) {
					event.getChannel().sendMessage(Constants.botNoPerms);
					return;
				}
				if( (c.minArgs() > parameters.length) || (c.maxArgs() < parameters.length) ) {
					event.getChannel().sendMessage(Constants.invalidArgs);
					return;
				}
				c.run(event, parameters);
			};
		}		
	}
	
	public boolean userHasPerms(MessageCreateEvent event, commands c, User user) {
		PermissionType[] p = c.getReqPerms();
		return event.getServer().get().hasPermissions(user, p);
	}
	
	public boolean botHasPerms(MessageCreateEvent event, commands c, User bot) {
		PermissionType[] p = c.getBotPerms();
		return event.getServer().get().hasPermissions(bot, p);
	}
}
