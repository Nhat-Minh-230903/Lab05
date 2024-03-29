package nguyennhatminh.edu.vn.utils;
import java.sql.*;

import nguyennhatminh.edu.vn.beans.UserAccount;

public class LoginUtils {
	public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a" +
					" where a.User_Name = ? and a.password= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUsername(userName);
			user.setpassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}
	public static UserAccount findUser(Connection conn, String userName) throws SQLException {
		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a" +
				" where a.User_Name = ?";
	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setString(1, userName);
	ResultSet rs = pstm.executeQuery();
	if(rs.next()) {
		String password = rs.getString("Password");
		String gender = rs.getString("Gender");
		UserAccount user = new UserAccount();
		user.setUsername(userName);
		user.setpassword(password);
		user.setGender(gender);
		return user;
	}
	return null;
	}
}
