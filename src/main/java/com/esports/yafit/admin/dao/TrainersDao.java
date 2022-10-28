package com.esports.yafit.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.esports.yafit.admin.model.Trainers;
import com.esports.yafit.dao.Dao;
import com.esports.yafit.utility.DbUtility;

public class TrainersDao implements Dao<Trainers> {
	// instantiate db-utility using a get method
	DbUtility db = DbUtility.getDbUtility();
	
	
	// validate login
	public void login(Trainers trainer) {
		try {
			// sql query to select data from the table based on conditions
			String sql = "SELECT * FROM trainers WHERE trnrEmail='" + trainer.getTrnrEmail() + "' AND trnrPassword ='"
					+ trainer.getTrnrPassword() + "'";
			ResultSet trn = db.executeQuery(sql);
			// object "pojo" mapping
			if (trn.next()) {
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				trainer.setTrnrId(trn.getInt("trnrId"));
				trainer.setTrnrName(trn.getString("trnrName"));
				trainer.setTrnrEmail(trn.getString("trnrEmail"));
				trainer.setTrnrPassword(trn.getString("trnrPassword"));
				//trainer.setLoginType(trn.getInt("loginType"));
				String date = trn.getString("addedOn");
				Date addedOn = format.parse(date);
				trainer.setAddedOn(addedOn);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}
	
	
	public List<Trainers> getAll() {
		List<Trainers> trainersList = new ArrayList<>();
		try {
			// sql query to select all data from the table
			String sql = "SELECT * FROM trainers";
			ResultSet trn = db.executeQuery(sql);
			while (trn.next()) {
				// instantiate trainers object called "trainer"
				Trainers trainer = new Trainers();
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				trainer.setTrnrId(trn.getInt("trnrId"));
				trainer.setTrnrName(trn.getString("trnrName"));
				trainer.setTrnrEmail(trn.getString("trnrEmail"));
				trainer.setTrnrPassword(trn.getString("trnrPassword"));
				trainer.setTrnrStreet(trn.getString("trnrStreet"));
				trainer.setTrnrCity(trn.getString("trnrCity"));
				trainer.setTrnrState(trn.getString("trnrState"));
				trainer.setTrnrZipcode(trn.getInt("trnrZipcode"));
				trainer.setTrnrAge(trn.getInt("trnrAge"));
				trainer.setTrnrGender(trn.getString("trnrGender"));
				trainer.setTrnrImage(trn.getString("trnrImage"));
				trainer.setTrnrPhone(trn.getString("trnrPhone"));
				trainer.setTrnrTitle(trn.getString("trnrTitle"));
				trainer.setTrnrRating(trn.getInt("trnrRating"));
				trainer.setTrnrActive(trn.getInt("trnrActive"));
				Date addedOn = format.parse(trn.getString("addedOn"));
				trainer.setAddedOn(addedOn);
				// add trainer into trainersList
				trainersList.add(trainer);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
		return trainersList;
	}


	public Trainers getOne(long id) {
		// instantiate trainers object called "trainer"
		Trainers trainer = new Trainers();
		try {
			// sql query to select data from the table based on conditions
			String sql = "SELECT * FROM trainers WHERE trnrId = " + id;
			ResultSet trn = db.executeQuery(sql);
			if (trn.next()) {
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				trainer.setTrnrId(trn.getInt("trnrId"));
				trainer.setTrnrName(trn.getString("trnrName"));
				trainer.setTrnrEmail(trn.getString("trnrEmail"));
				trainer.setTrnrPassword(trn.getString("trnrPassword"));
				trainer.setTrnrStreet(trn.getString("trnrStreet"));
				trainer.setTrnrCity(trn.getString("trnrCity"));
				trainer.setTrnrState(trn.getString("trnrState"));
				trainer.setTrnrZipcode(trn.getInt("trnrZipcode"));
				trainer.setTrnrAge(trn.getInt("trnrAge"));
				trainer.setTrnrGender(trn.getString("trnrGender"));
				trainer.setTrnrImage(trn.getString("trnrImage"));
				trainer.setTrnrPhone(trn.getString("trnrPhone"));
				trainer.setTrnrTitle(trn.getString("trnrTitle"));
				trainer.setTrnrRating(trn.getInt("trnrRating"));
				trainer.setTrnrActive(trn.getInt("trnrActive"));
				String date = trn.getString("addedOn");
				Date addedOn = format.parse(date);
				trainer.setAddedOn(addedOn);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
		return trainer;
	}

	
	public void save(Trainers obj) {
		try {
			// date formatting
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOn = format.format(obj.getAddedOn());
			// sql query to add data into the table
			String sql = String.format("INSERT INTO trainers VALUES(null, '%s', '%s', '%s', '%s', '%s', '%s', %d, %d, '%s', '%s', '%s', '%s', %d, %d, '%s')",
			obj.getTrnrName(), 
			obj.getTrnrEmail(), 
			obj.getTrnrPassword(), 
			obj.getTrnrStreet(), 
			obj.getTrnrCity(),
			obj.getTrnrState(), 
			obj.getTrnrZipcode(), 
			obj.getTrnrAge(), 
			obj.getTrnrGender(), 
			obj.getTrnrImage(), 
			obj.getTrnrPhone(),  
			obj.getTrnrTitle(),
			obj.getTrnrRating(),
			obj.getTrnrActive(),
			addedOn);
			String message = (db.executeUpdate(sql) > 0) ? "Trainers data saved successfully" : "Unable to save Trainers data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}

	
	public void update(Trainers obj) {
		try {
			// date formatting
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String addedOn = format.format(obj.getAddedOn());
			// sql query to update data in the table
			String sql = String.format("UPDATE trainers SET trnrName='%s', trnrEmail='%s', trnrPassword='%s', trnrStreet='%s', trnrCity='%s', trnrState='%s', trnrZipcode='%s', trnrAge='%s', trnrGender='%s', trnrImage='%s', trnrPhone='%s', trnrTitle='%s', trnrRating='%d', trnrActive='%d', addedOn='%s' WHERE trnrId=%d",
			obj.getTrnrName(), 
			obj.getTrnrEmail(), 
			obj.getTrnrPassword(), 
			obj.getTrnrStreet(), 
			obj.getTrnrCity(),
			obj.getTrnrState(), 
			obj.getTrnrZipcode(), 
			obj.getTrnrAge(), 
			obj.getTrnrGender(), 
			obj.getTrnrImage(), 
			obj.getTrnrPhone(),  
			obj.getTrnrTitle(),
			obj.getTrnrRating(),
			obj.getTrnrActive(),
			addedOn,
			obj.getTrnrId());
			String message = (db.executeUpdate(sql) > 0) ? "Trainers data updated successfully" : "Unable to update Trainers data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}

	
	public void delete(long id) {
		try {
			// sql query to delete data from the table based on conditions
			String sql = "DELETE FROM trainers WHERE trnrId = " + id;
			String message = (db.executeUpdate(sql) > 0) ? "Trainers data deleted successfully" : "Unable to delete Trainers data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}

}
