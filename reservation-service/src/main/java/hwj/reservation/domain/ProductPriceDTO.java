package hwj.reservation.domain;

import java.sql.Date;

public class ProductPriceDTO {
	private int id;
	private int productId;
	private int priceType;
	private int price;
	private double discountRate;
	private Date createDate;
	private Date modifyDate;
	
	public ProductPriceDTO(){}
	public ProductPriceDTO(int id, int productId, int priceType, int price, double discountRate, Date createDate,
			Date modifyDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.priceType = priceType;
		this.price = price;
		this.discountRate = discountRate;
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
	public int getPriceType() {
		return priceType;
	}
	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
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
