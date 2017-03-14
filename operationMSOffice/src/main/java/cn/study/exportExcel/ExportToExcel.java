package cn.study.exportExcel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExportToExcel{
	BaseDao dao;
	FileOutputStream outStream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	public ExportToExcel(String filePath){
		try {
			outStream=new FileOutputStream(filePath);
			workbook=new XSSFWorkbook();
			sheet=workbook.createSheet();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (@SuppressWarnings("hiding") IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void excuteExport(String sql){
		dao=new BaseDao();
		ResultSet rs=dao.query(sql);
		XSSFRow row0=sheet.createRow(0);
		row0.createCell(0).setCellValue("id");
		row0.createCell(1).setCellValue("user");
		row0.createCell(2).setCellValue("tel");
		try {
			for(int i=0;rs.next();i++){
				XSSFRow row=sheet.createRow(i+1);
				row.createCell(0).setCellValue(rs.getInt(1));
				row.createCell(1).setCellValue(rs.getString(2));
				row.createCell(2).setCellValue(rs.getString(3));
			}
			workbook.write(outStream);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeResource(){
		try {
			workbook.close();
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
