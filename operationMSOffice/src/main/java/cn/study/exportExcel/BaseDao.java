package cn.study.exportExcel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	public BaseDao(){
		String driver=ConfigManager.getInstance().getString("jdbc.driver_class");
		String url=ConfigManager.getInstance().getString("jdbc.connection.url");
		String user=ConfigManager.getInstance().getString("jdbc.connection.user");
		String password=ConfigManager.getInstance().getString("jdbc.connection.password");
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ResultSet query(String sql){
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int update(String sql){
		int count=0;
		try {
			ps=conn.prepareStatement(sql);
			count=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	public void closeResource(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
