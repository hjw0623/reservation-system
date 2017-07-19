package hwj.reservation.domain;

import java.sql.Date;

public class ProductDetailDTO {
	private int id;
	private int productId;
	private String content;
	private Date createDate;
	private Date modifyDate;
	
	public ProductDetailDTO(){}
	
	public ProductDetailDTO(int productId, String content, Date createDate, Date modifyDate) {
		super();
		this.productId = productId;
		this.content = content;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public ProductDetailDTO(int id, int productId, String content, Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.content = content;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
