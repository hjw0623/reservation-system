package hwj.reservation.dao;

public class ResUserCommentSqls {
	
	static final String SELECT_THREE_COMMENT_BY_PRODUCT_ID=
			"SELECT D.id, D.product_id, C.name as productName, D.user_id, D.username, D.score, D.comment, D.create_date, D.modify_date "
					+"FROM ( select A.id, A.product_id, A.user_id, B.username, A.score, A.comment, A.create_date, A.modify_date "
					+"FROM RESERVATION_USER_COMMENT as A, Users as B "
					+"WHERE A.user_id = B.id )  as D, Product as C "
					+"WHERE D.product_id =C.id AND C.id =:product_id ORDER BY create_date desc limit 3 ";

	static final String SELECT_ALL_COMMENT_BY_PRODUCT_ID=
			"SELECT D.id, D.product_id, C.name as productName, D.user_id, D.username, D.score, D.comment, D.create_date, D.modify_date "
					+"FROM ( select A.id, A.product_id, A.user_id, B.username, A.score, A.comment, A.create_date, A.modify_date "
					+"FROM RESERVATION_USER_COMMENT as A, Users as B "
					+"WHERE A.user_id = B.id )  as D, Product as C "
					+"WHERE D.product_id =C.id AND C.id =:product_id ORDER BY create_date desc ";
	
	static final String COUNT_ALL_COMMENT_BY_PRODUCT_ID =" SELECT COUNT(*) "
														+ "FROM RESERVATION_USER_COMMENT "
														+ "WHERE product_id = :product_id;";
	
	static final String AVERAGE_COMMENT_SCORE_BY_PRODUCT_ID ="SELECT Round(avg (score),1) "
														+ "FROM RESERVATION_USER_COMMENT "
														+ "WHERE product_id =:product_id ";
}
