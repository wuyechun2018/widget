package org.widget.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * ClassName: JdbcUtil 
 * Function: TODO ADD FUNCTION. 
 * Reason: TODO ADD REASON(可选). 
 * date: 2016-7-25 下午3:57:25 
 *
 * @author wuyechun
 * @version 
 * @since JDK 1.7
 */
public class JdbcUtil {
	
	/**
	 * 
	 * getDbConn:(这里用一句话描述这个方法的作用). 
	 *
	 * @author wuyechun
	 * @param url
	 * @param user
	 * @param password
	 * @return
	 * @since JDK 1.7
	 */
	public static Connection getDbConn(String url,String user,String password){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	
	
	/**
	 * 
	 * doQuery:查询
	 *
	 * @author wuyechun
	 * @param sql
	 * @param url
	 * @param user
	 * @param password
	 * @return
	 * @since JDK 1.7
	 */
	public static int doQuery(String sql,String url,String user,String password) {
		
		
		
		int count=0;
		try {
			Connection  conn=getDbConn(url,user,password);
			PreparedStatement pstm =conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
		
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			//关闭连接
			if (pstm != null) {
				pstm.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	

}
