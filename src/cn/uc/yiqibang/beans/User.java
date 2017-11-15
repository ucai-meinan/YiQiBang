package cn.uc.yiqibang.beans;

import java.util.Date;

public class User {
	
	private int id;
	private String userName;
	private String nickName;
	private String password;
	private boolean sex;
	private String bindtel;
	private String email;
	private String headimg;
	private boolean state;
	private Date createTime;
	private Date birthday;
	private String remark;
	private Date update;
	private int provinceId;
	private int cityId;
	private int areaId;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String nickName, String password, boolean sex, String bindtel, String email,
			String headimg, boolean state, Date createTime, Date birthday, String remark, Date update, int provinceId,
			int cityId, int areaId) {
		super();
		this.userName = userName;
		this.nickName = nickName;
		this.password = password;
		this.sex = sex;
		this.bindtel = bindtel;
		this.email = email;
		this.headimg = headimg;
		this.state = state;
		this.createTime = createTime;
		this.birthday = birthday;
		this.remark = remark;
		this.update = update;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getBindtel() {
		return bindtel;
	}

	public void setBindtel(String bindtel) {
		this.bindtel = bindtel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	
	

}
