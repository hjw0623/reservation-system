package hwj.reservation.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class FileDTO {
	private int id;
	private int userId;
	private String fileName;
	private String saveFileName;
	private long fileLength;
	private String contentType;
	private int deleteFlag;
	private Timestamp createDate;
	private Timestamp modifyDate;
	public FileDTO(){}
	public FileDTO(int userId, String fileName, String saveFileName, long fileLength, String contentType, int deleteFlag,
			Timestamp createDate, Timestamp modifyDate) {
		super();
		this.userId = userId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.fileLength = fileLength;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public FileDTO(int id, int userId, String fileName, String saveFileName, long fileLength, String contentType,
			int deleteFlag, Timestamp createDate, Timestamp modifyDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.fileLength = fileLength;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	public FileDTO(int userId,String fileName, String saveFileName, long fileLength, String contentType,
		int deleteFlag) {
		this.userId = userId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.fileLength = fileLength;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public long getFileLength() {
		return fileLength;
	}
	public void setFileLength(long fileLength) {
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
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
}
