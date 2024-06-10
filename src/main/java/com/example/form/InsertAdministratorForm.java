package com.example.form;

import jakarta.validation.constraints.NotBlank;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class InsertAdministratorForm {
	/** 名前 */
	@NotBlank(message = "名前は必須です")
	private String name;
	/** メールアドレス */
	@NotBlank(message = "メールアドレスは必須")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message = "パスワードは必須")
	private String password;
	/** 確認用パスワード */
	@NotBlank(message = "確認用パスワードは必須")
	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "InsertAdministratorForm{" +
				"confirmPassword='" + confirmPassword + '\'' +
				", name='" + name + '\'' +
				", mailAddress='" + mailAddress + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
