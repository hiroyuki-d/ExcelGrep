package jp.co.d.excelgrep;

import java.io.File;
import java.util.ArrayList;

public class Kicker {
	public static void main(String[] args) {
		DirectoryCrawler crawler = new DirectoryCrawler();
		ArrayList<File> list = crawler.readFolder(new File(args[0]));
		for (int i = 0; i < list.size(); i++) {
			ExcelGrep eg = new ExcelGrep(list.get(i));
			Object a = eg.readLine();
		}
		return;
	}
}
