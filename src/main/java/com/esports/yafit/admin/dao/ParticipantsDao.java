package com.esports.yafit.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.esports.yafit.admin.model.Participants;
import com.esports.yafit.dao.Dao;
import com.esports.yafit.utility.DbUtility;

public class ParticipantsDao implements Dao<Participants> {
	// instantiate db-utility using a get method
	DbUtility db = DbUtility.getDbUtility();
	
	
	// validate login
	public void login(Participants participant) {
		try {
			// sql query to select data from the table based on conditions
			String sql = "SELECT * FROM participants WHERE partEmail='" + participant.getPartEmail() + "' AND partPassword ='"
					+ participant.getPartPassword() + "'";
			ResultSet prt = db.executeQuery(sql);
			// object "pojo" mapping
			if (prt.next()) {
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				participant.setPartId(prt.getInt("partId"));
				participant.setPartName(prt.getString("partName"));
				participant.setPartEmail(prt.getString("partEmail"));
				participant.setPartPassword(prt.getString("partPassword"));
				//participant.setLoginType(prt.getInt("loginType"));
				String date = prt.getString("addedOn");
				Date addedOn = format.parse(date);
				participant.setAddedOn(addedOn);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}
	
	
	public List<Participants> getAll() {
		List<Participants> participantsList = new ArrayList<>();
		try {
			// sql query to select all data from the table
			String sql = "SELECT * FROM participants";
			ResultSet prt = db.executeQuery(sql);
			while (prt.next()) {
				// instantiate participants object called "participant"
				Participants participant = new Participants();
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				participant.setPartId(prt.getInt("partId"));
				participant.setPartName(prt.getString("partName"));
				participant.setPartEmail(prt.getString("partEmail"));
				participant.setPartPassword(prt.getString("partPassword"));
				participant.setPartStreet(prt.getString("partStreet"));
				participant.setPartCity(prt.getString("partCity"));
				participant.setPartState(prt.getString("partState"));
				participant.setPartCountry(prt.getString("partCountry"));
				participant.setPartZipcode(prt.getInt("partZipcode"));
				participant.setPartAge(prt.getInt("partAge"));
				participant.setPartGender(prt.getString("partGender"));
				participant.setPartImage(prt.getString("partImage"));
				participant.setPartPhone(prt.getString("partPhone"));
				participant.setEmergPhone(prt.getString("emergPhone"));
				participant.setPartType(prt.getString("partType"));
				participant.setPartActive(prt.getInt("partActive"));
				Date addedOn = format.parse(prt.getString("addedOn"));
				participant.setAddedOn(addedOn);
				// add participant into participantsList
				participantsList.add(participant);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
		return participantsList;
	}


	public Participants getOne(long id) {
		// instantiate participants object called "participant"
		Participants participant = new Participants();
		try {
			// sql query to select data from the table based on conditions
			String sql = "SELECT * FROM participants WHERE partId = " + id;
			ResultSet prt = db.executeQuery(sql);
			if (prt.next()) {
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				participant.setPartId(prt.getInt("partId"));
				participant.setPartName(prt.getString("partName"));
				participant.setPartEmail(prt.getString("partEmail"));
				participant.setPartPassword(prt.getString("partPassword"));
				participant.setPartStreet(prt.getString("partStreet"));
				participant.setPartCity(prt.getString("partCity"));
				participant.setPartState(prt.getString("partState"));
				participant.setPartCountry(prt.getString("partCountry"));
				participant.setPartZipcode(prt.getInt("partZipcode"));
				participant.setPartAge(prt.getInt("partAge"));
				participant.setPartGender(prt.getString("partGender"));
				participant.setPartImage(prt.getString("partImage"));
				participant.setPartPhone(prt.getString("partPhone"));
				participant.setEmergPhone(prt.getString("emergPhone"));
				participant.setPartType(prt.getString("partType"));
				participant.setPartActive(prt.getInt("partActive"));
				String date = prt.getString("addedOn");
				Date addedOn = format.parse(date);
				participant.setAddedOn(addedOn);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
		return participant;
	}


	public void save(Participants obj) {
		try {
			// date formatting
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOn = format.format(obj.getAddedOn());
			// sql query to add data into the table
			String sql = String.format("INSERT INTO participants VALUES(null, '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, %d, '%s', '%s', '%s', '%s', '%s', %d, '%s')",
			obj.getPartName(), 
			obj.getPartEmail(), 
			obj.getPartPassword(), 
			obj.getPartStreet(), 
			obj.getPartCity(),
			obj.getPartState(), 
			obj.getPartCountry(), 
			obj.getPartZipcode(), 
			obj.getPartAge(), 
			obj.getPartGender(), 
			obj.getPartImage(), 
			obj.getPartPhone(), 
			obj.getEmergPhone(), 
			obj.getPartType(),
			obj.getPartActive(),
			addedOn);
			String message = (db.executeUpdate(sql) > 0) ? "Participants data saved successfully" : "Unable to save Participants data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}


	public void update(Participants obj) {
		try {
			// date formatting
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String addedOn = format.format(obj.getAddedOn());
			// sql query to update data in the table
			String sql = String.format("UPDATE participants SET partName='%s', partEmail='%s', partPassword='%s', partStreet='%s', partCity='%s', partState='%s', partCountry='%s', partZipcode='%s', partAge='%s', partGender='%s', partImage='%s', partPhone='%s', emergPhone='%s', partType='%s', partActive='%d', addedOn='%s' WHERE partId=%d",
			obj.getPartName(), 
			obj.getPartEmail(), 
			obj.getPartPassword(), 
			obj.getPartStreet(), 
			obj.getPartCity(),
			obj.getPartState(), 
			obj.getPartCountry(), 
			obj.getPartZipcode(),
			obj.getPartAge(),
			obj.getPartGender(), 
			obj.getPartImage(), 
			obj.getPartPhone(), 
			obj.getEmergPhone(), 
			obj.getPartType(),
			obj.getPartActive(),
			addedOn,
			obj.getPartId());
			String message = (db.executeUpdate(sql) > 0) ? "Participants data updated successfully" : "Unable to update Participants data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}

	
	public void delete(long id) {
		try {
			// sql query to delete data from the table based on conditions
			String sql = "DELETE FROM participants WHERE partId = " + id;
			String message = (db.executeUpdate(sql) > 0) ? "Participants data deleted successfully" : "Unable to delete Participants data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}
}
