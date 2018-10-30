package com.github.yourname.myfirstbot;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class clearListener implements MessageCreateListener{

	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		if(event.getMessage().equals("!clear")) 
		{
			
		}
		
	}

}
