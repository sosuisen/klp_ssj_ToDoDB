package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

/**
 * DAO for todos table
 */
/**
CREATE TABLE todos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(30),
  priority INT
);
*/
@ApplicationScoped
public class ToDoDAO {
	@Resource(lookup = "jdbc/__default")
	private DataSource ds;

	@Inject
	private ToDos toDos;

	public void getAll() {
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM todos");) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int myId = rs.getInt("id");
				String title = rs.getString("title");
				int priority = rs.getInt("priority");
				toDos.add(new ToDoDTO(myId, title, priority));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void create(ToDoDTO mesDTO) {
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("INSERT INTO todos(title, priority) VALUES(?, ?)")) {
			pstmt.setString(1, mesDTO.getTitle());
			pstmt.setInt(2, mesDTO.getPriority());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE from todos");) {
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
