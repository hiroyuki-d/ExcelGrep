package jp.co.d.excelgrep.judge;

public class Judge {

	private String words;

	public String getWords() {
		return words;
	}

	private void setWords(String words) {
		this.words = words;
	}

	public Judge(String s) {
		setWords(s);
	}

	public Judgement judge(Object[] line) {
		Judgement j = new Judgement();

		for (int i = 0; i < line.length; i++) {
			if (line[i] == null)
				continue;
			//面倒なので判別は適当に…
			if (getWords().equals(line[i].toString())) {
				j.setFlag(true);
				j.setCol(i);
			}
		}
		return j;
	}
}
