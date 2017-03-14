package cn.study.exportExcel;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void testGetInstance() {
		String str="com.mysql.jdbc.Driver";
		
		
		assertEquals(str,ConfigManager.getInstance().getString("jdbc.driver_class"));
		
	}

}
