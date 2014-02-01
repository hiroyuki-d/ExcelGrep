package jp.co.d.excelgrep.judge;

public class Judgement {
	private boolean flag;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getCol() {
		return col;
	}

	public void setCol(long col) {
		this.col = col;
	}

	private long col;
}
