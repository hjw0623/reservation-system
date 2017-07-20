package hwj.reservation.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NaverLoginUser implements Serializable {
    private Integer id;
    private String name;
	private String email;
    private String nickname;
    @JsonProperty("profile_image")
    private String profileImage;
    private String age;
    private String gender;
 
    private String birthday;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "NaverLoginUser [id=" + id + ", name=" + name + ", email=" + email + ", nickname=" + nickname
				+ ", profileImage=" + profileImage + ", age=" + age + ", gender=" + gender + ", birthday=" + birthday
				+ "]";
	}
    
}
