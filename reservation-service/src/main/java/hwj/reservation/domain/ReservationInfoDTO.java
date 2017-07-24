package hwj.reservation.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class ReservationInfoDTO {
	private int id;
	private int productId;
	private int userId;
	private int generalTicketCount;
	private int youthTicketCount;
	private int childTicketCount;
	private String reservationName;
	private String reservationTel;
	private String reservationEmail;
	private Date reservationDate;
	private int reservationType;
	private Timestamp createDate;
	private Timestamp modifyDate;
	public ReservationInfoDTO(){}
	
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
	public int getGeneralTicketCount() {
		return generalTicketCount;
	}
	public void setGeneralTicketCount(int generalTicketCount) {
		this.generalTicketCount = generalTicketCount;
	}
	public int getYouthTicketCount() {
		return youthTicketCount;
	}
	public void setYouthTicketCount(int youthTicketCount) {
		this.youthTicketCount = youthTicketCount;
	}
	public int getChildTicketCount() {
		return childTicketCount;
	}
	public void setChildTicketCount(int childTicketCount) {
		this.childTicketCount = childTicketCount;
	}
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	public String getReservationTel() {
		return reservationTel;
	}
	public void setReservationTel(String reservationTel) {
		this.reservationTel = reservationTel;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public int getReservationType() {
		return reservationType;
	}
	public void setReservationType(int reservationType) {
		this.reservationType = reservationType;
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
