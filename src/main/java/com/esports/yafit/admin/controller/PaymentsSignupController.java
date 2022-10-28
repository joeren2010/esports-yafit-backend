package com.esports.yafit.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esports.yafit.admin.dao.PaymentsDao;
import com.esports.yafit.admin.dto.ResponseDto;
import com.esports.yafit.admin.model.Payments;
import com.google.gson.Gson;


@WebServlet("/payments-signup")
public class PaymentsSignupController extends HttpServlet {
	// used by jvm to identify the state of an object
	private static final long serialVersionUID = 1L;
	
	// instantiate pojo object
	Payments payment = new Payments();
	
	// instantiate dao object
	PaymentsDao paymentDao = new PaymentsDao();
	
	// create doPost method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and save new sign-up 
		try {
			// add set-methods for mapping: use dao file as ref
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
			// save data
			paymentDao.save(payment);
			dto.setMessage("Payment created successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to create Payment!");
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
