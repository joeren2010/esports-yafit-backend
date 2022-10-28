package com.esports.yafit.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.esports.yafit.admin.model.Payments;
import com.esports.yafit.dao.Dao;
import com.esports.yafit.utility.DbUtility;

public class PaymentsDao implements Dao<Payments> {
	// instantiate db-utility using a get method
	DbUtility db = DbUtility.getDbUtility();

	
	public List<Payments> getAll() {
		List<Payments> paymentsList = new ArrayList<>();
		try {
			// sql query to select all data from the table
			String sql = "SELECT * FROM payments";
			ResultSet pay = db.executeQuery(sql);
			while (pay.next()) {
				// instantiate payments object called "payment"
				Payments payment = new Payments();
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				payment.setPaymentId(pay.getInt("paymentId"));
				payment.setPartId(pay.getInt("partId"));
				payment.setPartName(pay.getString("partName"));
				payment.setPartEmail(pay.getString("partEmail"));
				payment.setPartPhone(pay.getString("partPhone"));
				payment.setPaymentPlan(pay.getString("paymentPlan"));
				payment.setBillingDay(pay.getInt("billingDay"));
				payment.setPaymentStatus(pay.getString("paymentStatus"));
				payment.setPaymentAmount(pay.getInt("paymentAmount"));
				payment.setPartActive(pay.getInt("partActive"));
				Date addedOn = format.parse(pay.getString("addedOn"));
				payment.setAddedOn(addedOn);
				// add payment into paymentsList
				paymentsList.add(payment);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
		return paymentsList;
	}

	
	public Payments getOne(long id) {
		// instantiate payments object called "payment"
		Payments payment = new Payments();
		try {
			// sql query to select data from the table based on conditions
			String sql = "SELECT * FROM payments WHERE paymentId = " + id;
			ResultSet pay = db.executeQuery(sql);
			if (pay.next()) {
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				payment.setPaymentId(pay.getInt("paymentId"));
				payment.setPartId(pay.getInt("partId"));
				payment.setPartName(pay.getString("partName"));
				payment.setPartEmail(pay.getString("partEmail"));
				payment.setPartPhone(pay.getString("partPhone"));
				payment.setPaymentPlan(pay.getString("paymentPlan"));
				payment.setBillingDay(pay.getInt("billingDay"));
				payment.setPaymentStatus(pay.getString("paymentStatus"));
				payment.setPaymentAmount(pay.getInt("paymentAmount"));
				payment.setPartActive(pay.getInt("partActive"));
				String date = pay.getString("addedOn");
				Date addedOn = format.parse(date);
				payment.setAddedOn(addedOn);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
		return payment;
	}


	public void save(Payments obj) {
		try {
			// date formatting
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOn = format.format(obj.getAddedOn());
			// sql query to add data into the table
			String sql = String.format("INSERT INTO payments VALUES(null, %d, '%s', '%s', '%s', '%s', '%s', %d, '%s', %d, %d, '%s')",
			obj.getPartId(), 
			obj.getPartName(), 
			obj.getPartEmail(),  
			obj.getPartPhone(), 
			obj.getPartType(),
			obj.getPaymentPlan(),
			obj.getBillingDay(),
			obj.getPaymentStatus(),
			obj.getPaymentAmount(),
			obj.getPartActive(),
			addedOn);
			String message = (db.executeUpdate(sql) > 0) ? "Payments data saved successfully" : "Unable to save Payments data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}

	
	public void update(Payments obj) {
		try {
			// date formatting
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOn = format.format(obj.getAddedOn());
			// sql query to update data in the table
			String sql = String.format("UPDATE payments SET partId='%d', partName='%s', partEmail='%s', partPhone='%s', partType='%s', paymentPlan='%s', billingDay='%d', paymentStatus='%s', paymentAmount='%d', partActive='%d', addedOn='%s' WHERE paymentId=%d",
			obj.getPartId(), 
			obj.getPartName(), 
			obj.getPartEmail(),  
			obj.getPartPhone(), 
			obj.getPartType(),
			obj.getPaymentPlan(),
			obj.getBillingDay(),
			obj.getPaymentStatus(),
			obj.getPaymentAmount(),
			obj.getPartActive(),
			addedOn,
			obj.getPaymentId());
			String message = (db.executeUpdate(sql) > 0) ? "Payments  data updated successfully" : "Unable to update Payments data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}


	public void delete(long id) {
		try {
			// sql query to delete data from the table based on conditions
			String sql = "DELETE FROM payments WHERE paymentId = " + id;
			String message = (db.executeUpdate(sql) > 0) ? "Payments data deleted successfully" : "Unable to delete Payments data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}

}
