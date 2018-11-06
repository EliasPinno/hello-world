package com.tester.tesbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.user.User;
import org.javacord.api.entity.user.*;

import java.util.ArrayList;
import java.util.List;

import org.javacord.api.*;
import org.javacord.api.entity.server.*;

import com.tester.tesbot.*;

public class Main {
	public static void main(String args[]) {
		final String TOKEN = "";
		final String testTOKEN = "";
		
		DiscordApi api = new DiscordApiBuilder().setToken(testTOKEN).login().join();
        System.out.println("Logged in!");
        
        api.addListener(new MSG());
        
      
        api.addMessageCreateListener(event -> {
            if (event.getMessage().getContent().equalsIgnoreCase("+shutdown")) {
            	MessageAuthor author = event.getMessage().getAuthor();
            	if (!author.isYourself()) {
            		System.exit(0);
            	}
            }
        });

	}
}
