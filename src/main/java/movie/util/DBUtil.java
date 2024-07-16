package movie.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.jdbc.pool.DataSource;


public class DBUtil {
	//DB연결
	// 한 사람이 쓰고 있는 동안 다른 사람이 못쓰면 비효율적-
	// 작업 하나 수행하고 바로 끊어지도록 하는 게 바람직
	// public이어야 외부에서 사용 가능
	
	//ConnectionPool 사용
	/*
	public static Connection dbConnection2() {
		Context initContext;
		Connection conn = null;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection(); //Connection Pooling(서버시작시 미리 Connection을 만들어두고 관리)
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	*/
	
	public static Connection dbConnection() {
		//변경이 가능한 것들
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String userid = "hr";
		String password = "hr";
		Connection conn = null; 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//클래스에 메모리올림
			conn = DriverManager.getConnection(url,userid,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}


	//DB연결 해제
	public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs!=null)rs.close(); 
			if(st!=null)st.close(); 
			if(conn!=null)conn.close(); 
		}catch (Exception e) {
			// TODO: handle exception
		}
//		System.out.println("3.실행 후 DB해제");
	}
	
}
