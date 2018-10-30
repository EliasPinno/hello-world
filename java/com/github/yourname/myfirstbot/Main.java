package com.github.yourname.myfirstbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.*;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;
import java.util.Scanner;

public class Main {	
	public static boolean messageSentByBot(Message test) 
	{
		if(test.getAuthor().getId() == 501669104965386240l)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		final String Token = input.next();
		input.close();
		
		DiscordApi api = new DiscordApiBuilder().setToken(Token).login().join();
		System.out.println("Dunno what i'm doing");
		
		ListenerManager<MessageCreateListener> remove = api.addMessageCreateListener(event -> 
		{
			if(event.getMessage().getContent().equals("!clone") && !messageSentByBot(event.getMessage())) 
			{
				event.getChannel().sendMessage("!clone");
			}
			
			if(event.getMessage().getContent().substring(0,5).equals("!gay ")) 
			{
				event.getChannel().sendMessage(event.getMessage().getContent().substring(5, event.getMessage().getContent().length()) + " is gay.");
			}
			
			if(event.getMessage().getContent().equals("/kill")) 
			{
				event.getChannel().sendMessage(event.getMessage().getAuthor().getName() + " died.");
			}
			if(event.getMessage().getContent().equals("testingABC")) 
			{
				CommandHandler what = new CommandHandler(event.getMessage());
				what.printTest();
			}
			if(event.getMessage().getContent().toLowerCase().contains("liberal")) 
			{
				event.getChannel().sendMessage("(((globalists)))");
				event.getChannel().sendMessage("https://www.youtube.com/watch?v=buD2RM0xChM");
			}
			if(event.getMessage().getContent().toLowerCase().contains("taste")|| event.getMessage().getContent().toLowerCase().contains("hamburger helper")) 
			{
				event.getChannel().sendMessage("https://www.youtube.com/channel/UCekQr9znsk2vWxBo3YiLq2w");
			}
			if(event.getMessage().getContent().toLowerCase().contains("help")) 
			{
				event.getChannel().sendMessage("no its not");
				event.getChannel().sendMessage("]help");
			}
			
		});
	}

}
