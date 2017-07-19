package hwj.reservation.domain;

import java.sql.Date;

public class Users {
	private int id;
	private String username;
	private String email;
	private String tel;
	private String nickname;
	private String snsId;
	private String snsType;
	private String snsProfile;
	private int adminFlag;
	private Date createDate;
	private Date modifyDate;
	public Users(){}
	
	public Users(String username, String email, String tel, String nickname, String snsId, String snsType,
			String snsProfile, int adminFlag, Date createDate, Date modifyDate) {
		super();
		this.username = username;
		this.email = email;
		this.tel = tel;
		this.nickname = nickname;
		this.snsId = snsId;
		this.snsType = snsType;
		this.snsProfile = snsProfile;
		this.adminFlag = adminFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public Users(int id, String username, String email, String tel, String nickname, String snsId, String snsType,
			String snsProfile, int adminFlag, Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.tel = tel;
		this.nickname = nickname;
		this.snsId = snsId;
		this.snsType = snsType;
		this.snsProfile = snsProfile;
		this.adminFlag = adminFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSnsId() {
		return snsId;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

	public String getSnsType() {
		return snsType;
	}

	public void setSnsType(String snsType) {
		this.snsType = snsType;
	}

	public String getSnsProfile() {
		return snsProfile;
	}

	public void setSnsProfile(String snsProfile) {
		this.snsProfile = snsProfile;
	}

	public int getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(int adminFlag) {
		this.adminFlag = adminFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
