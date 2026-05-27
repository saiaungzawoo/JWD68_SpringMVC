package com.spring.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FileRepo {
	
	public void saveFilePathToDatabase(String filePath) {

	    String sql = "INSERT INTO files (file_path) VALUES (?)";

	    try (Connection con = DbConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, filePath);
	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
