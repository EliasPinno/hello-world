package com.github.yourname.myfirstbot;
import java.security.acl.Permission;
import java.util.ArrayList;

import org.javacord.api.entity.message.*;
import org.javacord.api.entity.permission.*;
import org.javacord.api.entity.server.*;
import org.javacord.api.entity.server.*;

public class CommandHandler {
	
	public CommandHandler(Message input) 
	{
		message = input;
		author = input.getAuthor();
		content = input.getContent();
		test = input.canYouDelete();
		ArrayList<Integer> out = new ArrayList<Integer>();
		ArrayList<String> arrayList = new ArrayList<String>();

	}
	
	public void printTest() 
	{
		System.out.println(message);
		System.out.println(author);
		System.out.println(content);
		System.out.println(test);
	}
	
	public Message message;
	public String content;
	public MessageAuthor author;
	public boolean test;

}
