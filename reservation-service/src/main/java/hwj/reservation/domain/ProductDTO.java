package hwj.reservation.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class ProductDTO {
	private int id;
	private int categoryId;
	private String name;
	private String description;
	private Date salesStart;
	private Date salesEnd;
	private int salesFlag;
	private String event;
	private Date createDate;
	private Date modifyDate;
	public ProductDTO(){}
	public ProductDTO(int id, int categoryId, String name, String description, Date salesStart, Date salesEnd,
			int salesFlag, String event, Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.salesStart = salesStart;
		this.salesEnd = salesEnd;
		this.salesFlag = salesFlag;
		this.event = event;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	public ProductDTO(int categoryId, String name, String description, Date salesStart, Date salesEnd, int salesFlag,
			String event, Date createDate, Date modifyDate) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.salesStart = salesStart;
		this.salesEnd = salesEnd;
		this.salesFlag = salesFlag;
		this.event = event;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getSalesStart() {
		return salesStart;
	}
	public void setSalesStart(Date salesStart) {
		this.salesStart = salesStart;
	}
	public Date getSalesEnd() {
		return salesEnd;
	}
	public void setSalesEnd(Date salesEnd) {
		this.salesEnd = salesEnd;
	}
	public int getSalesFlag() {
		return salesFlag;
	}
	public void setSalesFlag(int salesFlag) {
		this.salesFlag = salesFlag;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
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
