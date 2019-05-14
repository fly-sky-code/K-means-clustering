package 文件夹选项;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class Excel extends JFrame{
	public static String s;
	public static void main(String[] args) {
		try {
			s=窗口.s;
			//获取指定列的值
			//readSpecifyColumns(new File(s));
			
			//获取指定行的值
			//readSpecifyRows(new File(s));
			
			//读取行列的值
			readRowsAndColums(new File(s));
			
			//将获取到的值写入到TXT或者xls中
			copy_excel(new File(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static void readRowsAndColums(File file) throws BiffException, IOException {
		//1:创建workbook
        Workbook workbook=Workbook.getWorkbook(new File(s)); 
        //2:获取第一个工作表sheet
        Sheet sheet=workbook.getSheet(0);
        //3:获取数据
        System.out.println("行："+sheet.getRows());
        System.out.println("列："+sheet.getColumns());
        for (int j = 1; j < sheet.getRows(); j++) {
			if(sheet.getCell(0, j).getContents()!="")
			{
			String cellinfo = (sheet.getCell(0, j).getContents())+","+(sheet.getCell(1, j).getContents())+","+(sheet.getCell(2, j).getContents());//读取的是第二列数据，没有标题，标题起始位置在for循环中定义
			System.out.println(cellinfo);
			}
			else
				break;
        }
        
        //最后一步：关闭资源
        workbook.close();
	}
	
	/**
	 * 	将获取到的值写入到TXT或者xls中
	 * @param file
	 * @throws Exception
	 */
	public static void copy_excel(File file) throws Exception {
		FileWriter fWriter = null;
		PrintWriter out = null;
		String fliename = file.getName().replace(".xls", "");
		//fWriter = new FileWriter(file.getParent()+ "/agetwo.xls");//输出格式为.xls
		fWriter = new FileWriter(file.getParent() + "/" + fliename + ".txt");//输出格式为.txt
		out = new PrintWriter(fWriter);
		InputStream is = new FileInputStream(file.getAbsoluteFile());
		Workbook wb = null;
		wb = Workbook.getWorkbook(is);
		int sheet_size = wb.getNumberOfSheets();
		Sheet sheet = wb.getSheet(0);
		for (int j = 1; j < sheet.getRows(); j++) {
			String cellinfo = (sheet.getCell(0, j).getContents())+","+(sheet.getCell(1, j).getContents())+","+ (sheet.getCell(2, j).getContents());//读取的是第二列数据，没有标题，标题起始位置在for循环中定义
			out.println(cellinfo);
		}
		out.close();//关闭流
		fWriter.close();
		out.flush();//刷新缓存
		System.out.println("输出完成！");
	}
}
