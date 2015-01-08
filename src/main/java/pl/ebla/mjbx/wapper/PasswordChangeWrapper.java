package pl.ebla.mjbx.wapper;

import javax.validation.constraints.Size;


public class PasswordChangeWrapper {
	
	private String oldPassword;
	
	@Size(min=5, message = "Has³o powinno mieæ co najmniej 5 znaków")
	private String newPassword;
	
	
	private String newPasswordRepeat;

	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewPasswordRepeat() {
		return newPasswordRepeat;
	}
	public void setNewPasswordRepeat(String newPasswordRepeat) {
		this.newPasswordRepeat = newPasswordRepeat;
	}

	
	

}
