package hwj.reservation.domain;

public class ProductImageDTO {
	private int id;
	private int productId;
	private int fileId;
	private int type;
	public ProductImageDTO(){}
	public ProductImageDTO(int id, int productId, int fileId, int type) {
		super();
		this.id = id;
		this.productId = productId;
		this.fileId = fileId;
		this.type = type;
	}
	public ProductImageDTO(int productId, int fileId, int type) {
		super();
		this.productId = productId;
		this.fileId = fileId;
		this.type = type;
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
	
}
