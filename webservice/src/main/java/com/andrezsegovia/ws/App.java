package com.andrezsegovia.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/webservice")
public class App extends HttpServlet
{

	private static final long serialVersionUID = -7099591509869696977L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String message = req.getParameter("message");
		System.out.println(message);
		try(PrintWriter out = resp.getWriter()){
			out.print(message);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String line;
		StringBuffer json = new StringBuffer();
		try(BufferedReader reader = req.getReader()){
			while((line=reader.readLine()) != null){
				json.append(line);
			}
		}
		
		System.out.println(json.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		Post post = mapper.readValue(json.toString(), Post.class);
		System.out.println("This is the tile: "+post.getTitle());
		System.out.println("This is the body: "+post.getBody());
		System.out.println("This is the author: "+post.getAuthor());
	}
    
	
	
}
