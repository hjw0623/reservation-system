package hwj.reservation.domain;

import java.sql.Date;
import java.util.List;
import java.util.Map;
//댓글 하나에 이미지 0~n 
//ResUserCommentImageDTO와 ResUserCommentDTO와 File의 조인 연산이 복잡져서 하나의 DTO로 묶어서 받는다.
public class ResUserCommentWitImageDTO {
	private int id; //코멘트 id
	private int productId;
	private String productName;
	private int userId;
	private String userName;
	private double score;
	private String comment;
	private Date create_date;
	private Date modify_date;
	//이미지 0~n개 
	private List<Map<String, Object> > imgList;
	
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public  List<Map<String, Object> > getImgList() {
		return imgList;
	}
	public void setImgList( List<Map<String, Object> > imgList) {
		this.imgList = imgList;
	}

}
