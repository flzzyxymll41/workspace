package cn.study.exportExcel;
public class publicOperation {
/*
	public static void main(String[] args) {
			String filePath=new String("d:\\flzhen.xlsx");
			ImportExcel imp=new ImportExcel(filePath);
			imp.excuteImport();
			imp.closeResource();
	}
*/
	
	public static void main(String[] args){
		String filePath=new String("d:\\flzhen.xlsx");
		ExportToExcel ete=new ExportToExcel(filePath);
		String sql="select * from user";
		ete.excuteExport(sql);
		ete.closeResource();
	}
}
