package com.esports.yafit.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esports.yafit.admin.dao.ParticipantsDao;
import com.esports.yafit.admin.dto.ResponseDto;
import com.esports.yafit.admin.model.Participants;
import com.google.gson.Gson;


@WebServlet("/participants-crud")
public class ParticipantsCrudController extends HttpServlet {
	// used by jvm to identify the state of an object
	private static final long serialVersionUID = 1L;
	
	// instantiate pojo object
	Participants participant = new Participants();
	
	// instantiate dao object
	ParticipantsDao participantDao = new ParticipantsDao();
	
	// create doGet method
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// create id as a request parameter
		String id = request.getParameter("id");
		
		// map admins object list
		List<Participants> participantList = new ArrayList<Participants>();

		// add and validate list
		if (id != null) {
			Participants participant = participantDao.getOne(Long.parseLong(id));
			participantList.add(participant);
		} 
		else {
			participantList = participantDao.getAll();
		}
		
		// printing or displaying the response
		String jsonResponse = new Gson().toJson(participantList);	//convert java object to json string
		PrintWriter out = response.getWriter();  		//instantiate print-writer object called "out"
		response.setContentType("application/json");  	//sets the content type of the response sent to client
		response.setCharacterEncoding("UTF-8");  		//sets the character encoding of the response sent to client
		out.print(jsonResponse);  						//displays json string as text
		out.flush();  									//clears all elements from the print-writer stream 
	}
	
	
	// create doPut method
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and update info 
		try {
			// add set-methods for mapping: use dao file as ref
			participant.setPartId(Integer.parseInt(request.getParameter("partId")));
			participant.setPartName(request.getParameter("partName"));
			participant.setPartEmail(request.getParameter("partEmail"));
			participant.setPartPassword(request.getParameter("partPassword"));
			participant.setPartStreet(request.getParameter("partStreet"));
			participant.setPartCity(request.getParameter("partCity"));
			participant.setPartState(request.getParameter("partState"));
			participant.setPartCountry(request.getParameter("partCountry"));
			participant.setPartZipcode(Integer.parseInt(request.getParameter("partZipcode")));
			participant.setPartAge(Integer.parseInt(request.getParameter("partAge")));
			participant.setPartGender(request.getParameter("partGender"));
			participant.setPartImage(request.getParameter("partImage"));
			participant.setPartPhone(request.getParameter("partPhone"));
			participant.setEmergPhone(request.getParameter("emergPhone"));
			participant.setPartType(request.getParameter("partType"));
			participant.setPartActive(Integer.parseInt(request.getParameter("partActive")));
			participant.setAddedOn(new Date());
			//update data
			participantDao.update(participant);
			dto.setMessage("Participant updated successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to update Participant!");
			dto.setError(e.toString());
		}
		
		// printing or displaying the response
		String jsonResponse = new Gson().toJson(dto);	//convert java object to json string
		PrintWriter out = response.getWriter();  		//instantiate print-writer object called "out"
		response.setContentType("application/json");  	//sets the content type of the response sent to client
		response.setCharacterEncoding("UTF-8");  		//sets the character encoding of the response sent to client
		out.print(jsonResponse);  						//displays json string as text
		out.flush();  									//clears all elements from the print-writer stream 
	}
	
	
	// create doDelete method
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// create id as a request parameter
		String id = request.getParameter("id");
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and delete info 
		try {
			participantDao.delete(Integer.parseInt(id));
			dto.setMessage("Participant deleted successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to delete Participant!");
			dto.setError(e.toString());
		}
		
		// printing or displaying the response
		String jsonResponse = new Gson().toJson(dto);	//convert java object to json string
		PrintWriter out = response.getWriter();  		//instantiate print-writer object called "out"
		response.setContentType("application/json");  	//sets the content type of the response sent to client
		response.setCharacterEncoding("UTF-8");  		//sets the character encoding of the response sent to client
		out.print(jsonResponse);  						//displays json string as text
		out.flush();  									//clears all elements from the print-writer stream 
	}
}
