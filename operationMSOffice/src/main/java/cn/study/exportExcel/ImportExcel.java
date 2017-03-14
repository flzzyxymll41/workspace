package cn.study.exportExcel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ImportExcel{
	BaseDao dao;
	FileInputStream inputStream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	public ImportExcel(String filePath){
		try {
			inputStream=new FileInputStream(filePath);
			workbook=new XSSFWorkbook(inputStream);
			sheet=workbook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void excuteImport(){
		String sql=new String("");
		dao=new BaseDao();
		XSSFRow row=null;
		for(int i=0;sheet.getRow(i+1)!=null;i++){
			row=sheet.getRow(i+1);
			sql="insert into user(id,name,tel) values(";
			sql=sql+(int)row.getCell(0).getNumericCellValue()+",'"+row.getCell(1).getStringCellValue()+"','"
			+row.getCell(2).getStringCellValue()+"')";
			dao.update(sql);
		}
		try {
			workbook.close();
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeResource(){
		dao.closeResource();
		try {
			workbook.close();
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
