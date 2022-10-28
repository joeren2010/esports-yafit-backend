package com.esports.yafit.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.esports.yafit.admin.model.Batches;
import com.esports.yafit.dao.Dao;
import com.esports.yafit.utility.DbUtility;

public class BatchesDao implements Dao<Batches> {
	// instantiate db-utility using a get method
	DbUtility db = DbUtility.getDbUtility();

	public List<Batches> getAll() {
		List<Batches> batchesList = new ArrayList<>();
		try {
			// sql query to select all data from the table
			String sql = "SELECT * FROM batches";
			ResultSet bat = db.executeQuery(sql);
			while (bat.next()) {
				// instantiate batches object called "batch"
				Batches batch = new Batches();
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				batch.setBatchId(bat.getInt("batchId"));
				batch.setBatchName(bat.getString("batchName"));
				batch.setTrnrName(bat.getString("trnrName"));
				batch.setTrnrId(bat.getInt("trnrId"));
				batch.setPartName(bat.getString("partName"));
				batch.setPartId(bat.getInt("partId"));
				batch.setPartAge(bat.getInt("partAge"));
				batch.setPartGender(bat.getString("partGender"));
				batch.setPartActive(bat.getInt("partActive"));
				Date addedOn = format.parse(bat.getString("addedOn"));
				batch.setAddedOn(addedOn);
				// add batch into batchesList
				batchesList.add(batch);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
		return batchesList;
	}


	public Batches getOne(long id) {
		// instantiate batches object called "batch"
		Batches batch = new Batches();
		try {
			// sql query to select data from the table based on conditions
			String sql = "SELECT * FROM batches WHERE batchId = " + id;
			ResultSet bat = db.executeQuery(sql);
			if (bat.next()) {
				// date formatting
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// set methods
				batch.setBatchId(bat.getInt("batchId"));
				batch.setBatchName(bat.getString("batchName"));
				batch.setTrnrName(bat.getString("trnrName"));
				batch.setTrnrId(bat.getInt("trnrId"));
				batch.setPartName(bat.getString("partName"));
				batch.setPartId(bat.getInt("partId"));
				batch.setPartAge(bat.getInt("partAge"));
				batch.setPartGender(bat.getString("partGender"));
				batch.setPartActive(bat.getInt("partActive"));
				String date = bat.getString("addedOn");
				Date addedOn = format.parse(date);
				batch.setAddedOn(addedOn);
			}
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
		return batch;
	}


	public void save(Batches obj) {
		try {
			// date formatting
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOn = format.format(obj.getAddedOn());
			// sql query to add data into the table
			String sql = String.format("INSERT INTO batches VALUES(null, '%s', '%s',  %d, '%s',  %d, %d, '%s', %d, '%s')",
			obj.getBatchName(), 
			obj.getTrnrName(), 
			obj.getTrnrId(), 
			obj.getPartName(), 
			obj.getPartId(), 
			obj.getPartAge(),  
			obj.getPartGender(),
			obj.getPartActive(),
			addedOn);
			String message = (db.executeUpdate(sql) > 0) ? "Batches data saved successfully" : "Unable to save Batches data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}


	public void update(Batches obj) {
		try {
			// date formatting
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOn = format.format(obj.getAddedOn());
			// sql query to update data in the table
			String sql = String.format("UPDATE batches SET batchName='%s', trnrName='%s', trnrId='%d', partName='%s', partId='%d', partAge='%d', partGender='%s', partActive='%d', addedOn='%s' WHERE batchId=%d",
			obj.getBatchName(), 
			obj.getTrnrName(), 
			obj.getTrnrId(), 
			obj.getPartName(), 
			obj.getPartId(), 
			obj.getPartAge(),  
			obj.getPartGender(),
			obj.getPartActive(),
			addedOn,
			obj.getBatchId());
			String message = (db.executeUpdate(sql) > 0) ? "Batches  data updated successfully" : "Unable to update Batches data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}

	
	public void delete(long id) {
		try {
			// sql query to delete data from the table based on conditions
			String sql = "DELETE FROM batches WHERE batchId = " + id;
			String message = (db.executeUpdate(sql) > 0) ? "Batches data deleted successfully" : "Unable to delete Batches data";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("oops! something went wrong:: " + e.getMessage());
		}
	}

}
