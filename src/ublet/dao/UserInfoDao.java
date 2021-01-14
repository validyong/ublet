package ublet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import ublet.bean.UserInfo;

public class UserInfoDao {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static UserInfo login(UserInfo userInfo) {
		// preparing som objects for connection
		Statement stmt = null;

		String userId = userInfo.getUserId();
		String password = userInfo.getPassword();

		String searchQuery = "select * from user_info where user_id='"
				+ userId
				+ "'AND password='"
				+ password
				+ "'";

		// "System.out.println" prints in the console; NOrmally used to trace the process
		System.out.println("Your user id is " + userId);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);

		try {
			//connect to DB
			currentCon = DBManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				userInfo.setValid(false);
			}

			//if user exists set the isValid variable to true
			else if (more) {
				String mailAddress = rs.getString("mail_address");

				System.out.println("Welcome " + userId);
				userInfo.setMailAddress(mailAddress);
				userInfo.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		//some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return userInfo;
	}
}
