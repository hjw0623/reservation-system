package hwj.reservation.dto;

import java.sql.Date;

public class ProductImageFileFormParamDTO {
	//ProductImgFileForm 
	
	//for PRODUCT table
	private int productId;
	private int fileId;
	//main or sub img
	private int type; 
	
	//for FILE table
	private int userId;
	private String fileName;
	private String saveFileName;
	private int fileLength;
	private String contentType;
	private int deleteFlag;
	private Date createDate;
	private Date modifyDate;
	
	public ProductImageFileFormParamDTO(){}
	
	public ProductImageFileFormParamDTO(int productId, int fileId, int type, int userId, String fileName,
			String saveFileName, int fileLength, String contentType, int deleteFlag, Date createDate, Date modifyDate) {
		super();
		this.productId = productId;
		this.fileId = fileId;
		this.type = type;
		this.userId = userId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.fileLength = fileLength;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public int getFileLength() {
		return fileLength;
	}
	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
}
