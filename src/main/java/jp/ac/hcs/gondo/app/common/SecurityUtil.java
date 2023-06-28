package jp.ac.hcs.gondo.app.common;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtil {

	private SecurityUtil() {
		// newを禁止
	}

	/**
	 * ログイン中のユーザ情報を取得.<br>
	 * <Strong>ユーザ情報が取得できない場合は、IllegalAccessErrorをスローする。</Strong>
	 * @return ユーザ情報
	 */
	public static String getUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof User) {
			String username = ((User) principal).getUsername();
			return username;
		}
		throw new IllegalAccessError("ログインユーザ情報が取得できませんでした");
	}
}