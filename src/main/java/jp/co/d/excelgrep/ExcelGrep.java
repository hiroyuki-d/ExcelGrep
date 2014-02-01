package jp.co.d.excelgrep;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelGrep {

	private File targetFile = null;

	public ExcelGrep(File target) {
		targetFile = target;
	}

	public Object[] readLine() {
		try {
			//Excelのワークブックを読み込みます。
			POIFSFileSystem filein = new POIFSFileSystem(new FileInputStream(targetFile));
			HSSFWorkbook wb = new HSSFWorkbook(filein);

			Object[] sheetArray = new Object[wb.getNumberOfSheets()];
			// シートごとのループ
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				//シートを読み込みます。
				HSSFSheet sheet = wb.getSheetAt(i);
				Object[] rowArray = new Object[sheet.getLastRowNum() + 1];
				// 行ごとのループ
				if (sheet.getLastRowNum() == 0)
					continue; // シートに何も入っていない時は、最大行数が0として帰ってくる。
				for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {
					HSSFRow row = sheet.getRow(j);
					if (row == null)
						continue;
					Object[] cellArray = new Object[row.getLastCellNum()];
					// 列に対するループ
					for (int k = 0; k < row.getLastCellNum(); k++) {
						HSSFCell cell = row.getCell(k);
						if (cell == null)
							continue;
						if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
							cellArray[k] = cell.getRichStringCellValue().getString();
					}
					rowArray[j] = cellArray;
				}
				sheetArray[i] = rowArray;
			}
			return sheetArray;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("処理が失敗しました");
		}
		return null;
	}
}
