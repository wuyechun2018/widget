package org.widget.jdbc;

import java.util.Scanner;

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
		
		
		//String url = "jdbc:oracle:thin:@172.16.7.116:1521:center";
		//String user="center"; 
		//String password="123456";
		//String sql="SELECT COUNT(1) FROM PSN_PERSON";
		
		Scanner sc=new Scanner(System.in);
		System.out.println("=================The DB COUNT UTIL=================");
		System.out.println("The DB URL IS(jdbc:oracle:thin:@172.16.10.25:1521:torcl):");
		String url=sc.nextLine();
		System.out.println("The DB user IS(center):");
		String user=sc.nextLine();
		System.out.println("The DB password IS(centerDB12345):");
		String password=sc.nextLine();
		//System.out.println("The Query SQL IS(SELECT COUNT(1) FROM PSN_PERSON):");
		//String sql=sc.nextLine();
		
		//int count=JdbcUtil.doQueryCount(sql, url, user, password);
		//System.out.println("The Result IS:"+count);
		System.out.println("The Query SQL IS(SELECT * FROM (SELECT T.*, ROWNUM RN FROM PSN_PERSON T)WHERE RN > 5 AND RN < 10):");
		String sql=sc.nextLine();
		int count=JdbcUtil.doQueryCount(JdbcUtil.getCountSQL(sql), url, user, password);
		if(count>50){
			System.out.println("The Query result is:"+count+",Do you really want to disyplay some of them(Y/N)?");
		}
		String choice=sc.nextLine();
		if(choice!=null&&"Y".equals(choice)){
			//返回1-100条数据
			JdbcUtil.doQuery(JdbcUtil.getLimitSQL(sql,"1","100"), url, user, password);
		}else{
			JdbcUtil.doQuery(JdbcUtil.getLimitSQL(sql,"1","10"), url, user, password);
		}
		
	}
}
