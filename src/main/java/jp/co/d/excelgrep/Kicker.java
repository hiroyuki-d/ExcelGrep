package jp.co.d.excelgrep;

import java.io.File;
import java.util.ArrayList;

import jp.co.d.excelgrep.judge.Judge;
import jp.co.d.excelgrep.judge.Judgement;

public class Kicker {
	public static void main(String[] args) {
		DirectoryCrawler crawler = new DirectoryCrawler();
		ArrayList<File> list = crawler.readFolder(new File(args[0]));
		for (int i = 0; i < list.size(); i++) {
			ExcelGrep eg = new ExcelGrep(list.get(i));
			Object[][][] book = eg.readLine();
			Judge jud = new Judge(args[1]);

			for (int j = 0; j < book.length; j++) {
				if (book[j] == null)
					continue;

				for (int k = 0; k < book[j].length; k++) {
					if (book[j][k] == null)
						continue;
					Judgement res = jud.judge(book[j][k]);
					if (res.isFlag()) {
						System.out.print("Hit");
						System.out.print("\t");
						System.out.print(list.get(i).getAbsolutePath());
						System.out.print("\t");
						System.out.print("SheetNo." + (j + 1));
						System.out.print("\t");
						System.out.print("RowNo." + (k + 1));
						System.out.print("\t");
						System.out.println("ColNo." + (res.getCol() + 1));
					}
				}
			}
		}
		return;
	}
}
