package hwj.reservation.domain;

import java.sql.Date;

public class ProductMainImageDTO {
	//productDTO (A in ProductMainImageSqls)
	private int id; //productId
	private int categoryId;
	private String name;
	private String description;
	private Date salesStart;
	private Date salesEnd;
	private int salesFlag;
	private String event;
	private Date createDate;
	private Date modifyDate;
	
	//productImageDTO (B in ProductMainImageSqls)
	private int fileId;
	private int type;
	
	//File DTO (C in ProductMainImageSqls)
	private String saveFileName;
	public ProductMainImageDTO(){}
	
	public ProductMainImageDTO(int categoryId, String name, String description, Date salesStart, Date salesEnd,
			int salesFlag, String event, Date createDate, Date modifyDate, int fileId, int type, String saveFileName) {
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
		this.fileId = fileId;
		this.type = type;
		this.saveFileName = saveFileName;
	}

	public ProductMainImageDTO(int id, int categoryId, String name, String description, Date salesStart, Date salesEnd,
			int salesFlag, String event, Date createDate, Date modifyDate, int fileId, int type, String saveFileName) {
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
		this.fileId = fileId;
		this.type = type;
		this.saveFileName = saveFileName;
	}

	//getter and setter
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

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	

}
