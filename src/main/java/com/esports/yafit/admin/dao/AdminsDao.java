package com.esports.yafit.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.esports.yafit.admin.model.Admins;
import com.esports.yafit.dao.Dao;
import com.esports.yafit.utility.DbUtility;

public class AdminsDao implements Dao<Admins> {
	// instantiate db-utility using a get method
	DbUtility db = DbUtility.getDbUtility();

	
	// validate login
	public void login(Admins admin) {
		try {
			// sql query to select data from the table based on conditions
			String sql = "SELECT * FROM admins WHERE adminEmail='" + admin.getAdminEmail() + "' AND adminPassword ='"
					+ admin.getAdminPassword() + "'";
			ResultSet adm = db.executeQuery(sql);
			// object "pojo" mapping
			if (adm.next()) {
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				admin.setAdminId(adm.getInt("adminId"));
				admin.setAdminName(adm.getString("adminName"));
				admin.setAdminEmail(adm.getString("adminEmail"));
				admin.setAdminPassword(adm.getString("adminPassword"));
				admin.setLoginType(adm.getInt("loginType"));
				String date = adm.getString("addedOn");
				Date addedOn = format.parse(date);
				admin.setAddedOn(addedOn);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}
	

	public List<Admins> getAll() {
		List<Admins> adminList = new ArrayList<Admins>();
		try {
			// sql query to select all data from the table
			String sql = "SELECT * FROM admins";
			ResultSet adm = db.executeQuery(sql);
			// object "pojo" mapping
			while (adm.next()) {
				// instantiate admin object called "admin"
				Admins admin = new Admins();
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				admin.setAdminId(adm.getInt("adminId"));
				admin.setAdminName(adm.getString("adminName"));
				admin.setAdminEmail(adm.getString("adminEmail"));
				admin.setAdminPassword(adm.getString("adminPassword"));
				admin.setLoginType(adm.getInt("loginType"));
				String date = adm.getString("addedOn");
				Date addedOn = format.parse(date);
				admin.setAddedOn(addedOn);
				// add admin into adminsList
				adminList.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
		return adminList;
	}

	
	public Admins getOne(long id) {
		// instantiate an admin object "admin"
		Admins admin = new Admins();
		try {
			// sql query to select data from the table based on conditions
			String sql = "SELECT * FROM admins WHERE adminId=" + id;
			ResultSet adm = db.executeQuery(sql);
			// object "pojo" mapping
			if (adm.next()) {
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				admin.setAdminId(adm.getInt("adminId"));
				admin.setAdminName(adm.getString("adminName"));
				admin.setAdminEmail(adm.getString("adminEmail"));
				admin.setAdminPassword(adm.getString("adminPassword"));
				admin.setLoginType(adm.getInt("loginType"));
				String date = adm.getString("addedOn");
				Date addedOn = format.parse(date);
				admin.setAddedOn(addedOn);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
		return admin;
	}

	
	public void save(Admins obj) {
		try {
			// date formatting
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOn = format.format(obj.getAddedOn());
			// sql query to add data into the table
			String sql = String.format("INSERT INTO admins VALUES(null, '%s', '%s', '%s', %d, '%s')",
			obj.getAdminName(), 
			obj.getAdminEmail(), 
			obj.getAdminPassword(), 
			obj.getLoginType(), 
			addedOn);
			String message = (db.executeUpdate(sql) > 0) ? "Admins data saved successfully" : "Unable to save Admins data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}

	
	public void update(Admins obj) {
		try {
			// date formatting
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOn = format.format(obj.getAddedOn());
			// sql query to update data in the table
			String sql = String.format("UPDATE admins SET adminName='%s', adminEmail='%s', adminPassword='%s', loginType='%s', addedOn='%s' WHERE adminId=%d",
			obj.getAdminName(), 
			obj.getAdminEmail(), 
			obj.getAdminPassword(), 
			obj.getLoginType(),
			addedOn,
			obj.getAdminId());
			String message = (db.executeUpdate(sql) > 0) ? "Admins data updated successfully" : "Unable to update Admins data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}

	
	public void delete(long id) {
		try {
			// sql query to delete data from the table based on conditions
			String sql = "DELETE FROM admins WHERE adminId = " + id;
			int rowAffected = db.executeUpdate(sql);
			String message = (rowAffected > 0) ? "Admin record deleted successfully" : "Unable to delete Admin data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}
}
