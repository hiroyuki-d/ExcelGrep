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
			Object[][][] a = eg.readLine();
			Judge j = new Judge();
			for (Object[][] sheet : a) {
				if (sheet == null)
					continue;
				for (Object[] line : sheet) {
					if (line == null)
						continue;
					Judgement res = j.judge(line);
					if (res.isFlag())
						System.out.println("引っかかりました");
				}
			}
		}
		return;
	}
}
