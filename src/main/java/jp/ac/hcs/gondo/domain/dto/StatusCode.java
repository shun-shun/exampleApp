package jp.ac.hcs.gondo.domain.dto;

public enum StatusCode {

	OK("正常終了しました。",200),
	NG("エラーが発生しました。",500);
	
	private String message;
	
	private int code;
	
	StatusCode(String message, int code) {
		this.message = message;
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getCode() {
		return code;
	}
}
