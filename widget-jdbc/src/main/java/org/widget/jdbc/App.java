package org.widget.jdbc;
/**
 * 
 * ClassName: App 
 * Function: TODO ADD FUNCTION. 
 * Reason: TODO ADD REASON(可选). 
 * date: 2016-7-25 下午3:58:17 
 *
 * @author wuyechun
 * @version 
 * @since JDK 1.7
 */
public class App {
	
	/**
	 * 
	 * main:主方法
	 *
	 * @author wuyechun
	 * @param args
	 * @since JDK 1.7
	 */
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@172.16.7.116:1521:center";
		String user="center"; 
		String password="123456";
		String sql="SELECT COUNT(1) FROM PSN_PERSON";
		
		int count=JdbcUtil.doQuery(sql, url, user, password);
		System.out.println(count);
		
	}
}
