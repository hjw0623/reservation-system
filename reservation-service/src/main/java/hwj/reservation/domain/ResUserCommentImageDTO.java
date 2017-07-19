package hwj.reservation.domain;

public class ResUserCommentImageDTO {
	private int id;
	private int reservationUserCommentId;
	private int fileId;
	
	public ResUserCommentImageDTO(){}
	public ResUserCommentImageDTO(int reservationUserCommentId, int fileId) {
		super();
		this.reservationUserCommentId = reservationUserCommentId;
		this.fileId = fileId;
	}
	public ResUserCommentImageDTO(int id, int reservationUserCommentId, int fileId) {
		super();
		this.id = id;
		this.reservationUserCommentId = reservationUserCommentId;
		this.fileId = fileId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReservationUserCommentId() {
		return reservationUserCommentId;
	}
	public void setReservationUserCommentId(int reservationUserCommentId) {
		this.reservationUserCommentId = reservationUserCommentId;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
}
