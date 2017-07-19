package hwj.reservation.domain;

import java.sql.Date;

public class ResUserCommentDTO {
	private int id;
	private int productId;
	private String productName;
	private int userId;
	private String userName;
	private double score;
	private String comment;
	private Date create_date;
	private Date modify_date;
	
	
	public ResUserCommentDTO(){}
	
	public ResUserCommentDTO(int productId, String productName, int userId, String userName, double score,
			String comment, Date create_date, Date modify_date) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.userId = userId;
		this.userName = userName;
		this.score = score;
		this.comment = comment;
		this.create_date = create_date;
		this.modify_date = modify_date;
	}



	public ResUserCommentDTO(int id, int productId, String productName, int userId, String userName, double score,
			String comment, Date create_date, Date modify_date) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.userId = userId;
		this.userName = userName;
		this.score = score;
		this.comment = comment;
		this.create_date = create_date;
		this.modify_date = modify_date;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
