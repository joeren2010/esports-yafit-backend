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

import com.esports.yafit.admin.dao.PaymentsDao;
import com.esports.yafit.admin.dto.ResponseDto;
import com.esports.yafit.admin.model.Payments;
import com.google.gson.Gson;


@WebServlet("/payments-crud")
public class PaymentsCrudController extends HttpServlet {
	// used by jvm to identify the state of an object
	private static final long serialVersionUID = 1L;
	
	// instantiate pojo object
	Payments payment = new Payments();
	
	// instantiate dao object
	PaymentsDao paymentDao = new PaymentsDao();
	
	// create doGet method
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// create id as a request parameter
		String id = request.getParameter("id");
		
		// map admins object list
		List<Payments> paymentList = new ArrayList<Payments>();

		// add and validate list
		if (id != null) {
			Payments payment = paymentDao.getOne(Long.parseLong(id));
			paymentList.add(payment);
		} 
		else {
			paymentList = paymentDao.getAll();
		}
		
		// printing or displaying the response
		String jsonResponse = new Gson().toJson(paymentList);	//convert java object to json string
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
			payment.setPaymentId(Integer.parseInt(request.getParameter("paymentId")));
			payment.setPartId(Integer.parseInt(request.getParameter("partId")));
			payment.setPartName(request.getParameter("partName"));
			payment.setPartEmail(request.getParameter("partEmail"));
			payment.setPartPhone(request.getParameter("partPhone"));
			payment.setPartType(request.getParameter("partType"));
			payment.setPaymentPlan(request.getParameter("paymentPlan"));
			payment.setBillingDay(Integer.parseInt(request.getParameter("billingDay")));
			payment.setPaymentStatus(request.getParameter("paymentStatus"));
			payment.setPaymentAmount(Integer.parseInt(request.getParameter("paymentAmount")));
			payment.setPartActive(Integer.parseInt(request.getParameter("partActive")));
			payment.setAddedOn(new Date());
			//update data
			paymentDao.update(payment);
			dto.setMessage("Payment updated successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to update Payment!");
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
			paymentDao.delete(Integer.parseInt(id));
			dto.setMessage("Payment deleted successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to delete Payment!");
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
