package model.model_interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface I_Variable {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;
}
