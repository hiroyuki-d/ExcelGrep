package jp.co.d.excelgrep;

import java.io.File;
import java.util.ArrayList;

public class DirectoryCrawler {
	/**
	 * ディレクトリを再帰的に読む
	 * @param dir
	 * @return ディレクトリ内のファイル一覧
	 */
	public ArrayList<File> readFolder(File dir) {
		ArrayList<File> ret = new ArrayList<File>();
		File[] files = dir.listFiles();
		if (files == null)
			return ret;
		for (File file : files) {
			if (!file.exists())
				continue;
			else if (file.isDirectory())
				ret.addAll(readFolder(file));
			else if (file.isFile())
				ret.add(file);
		}
		return ret;
	}
}
