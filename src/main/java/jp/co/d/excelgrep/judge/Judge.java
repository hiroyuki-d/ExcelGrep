package jp.co.d.excelgrep.judge;

public class Judge {
	public Judge() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Judgement judge(Object[] line) {
		Judgement j = new Judgement();
		for (Object cell : line) {
			if (cell == null)
				continue;
			//面倒なので判別は適当に…
			if ("a1".equals(cell.toString()))
				j.setFlag(true);
		}

		return j;
	}
}
