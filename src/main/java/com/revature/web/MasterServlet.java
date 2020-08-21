package com.revature.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AvengerController;
import com.revature.models.Avenger;

public class MasterServlet extends HttpServlet {
	
	private static AvengerController ac = new AvengerController();
	
	public MasterServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/HelloJackson/", "");
		
		String[] portions = URI.split("/");
		
		// better to log
		System.out.println(Arrays.toString(portions));
		try {
			switch(portions[0]) {
				case "avenger":
					if (req.getMethod().equals("GET")) {
						if (portions.length == 2) {
							int id = Integer.parseInt(portions[1]);
							 ac.getAvenger(res, id);
							
						}
					} else if (req.getMethod().equals("POST")) {
						
					}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("the id you provided is not an integer");
			res.setStatus(400);
		}
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
