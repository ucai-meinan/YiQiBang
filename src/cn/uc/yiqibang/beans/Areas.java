package cn.uc.yiqibang.beans;

public class Areas {
	
	private int id;
	private String areaId;
	private String area;
	private String cityId;
	
	public Areas() {
		// TODO Auto-generated constructor stub
	}

	public Areas(String areaId, String area, String cityId) {
		super();
		this.areaId = areaId;
		this.area = area;
		this.cityId = cityId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	

}
