package hwj.reservation.dao;

public class ProductImageSqls {
	static final String SELECT_ALL_PRODUCT_IMAGES ="SELECT id, product_id, file_id, type FROM PRODUCT_IMAGE ";
	
	static final String SELECT_PRODUCT_IMAGES_BY_PRODUCT_ID=
						"SELECT B.id, B.save_file_name, type "
						+ "FROM PRODUCT_IMAGE as A, FILE as B "
						+ "WHERE (type=0 OR type=1 ) "
						+ "AND product_id=:product_id "
						+ "AND delete_flag=0 "
						+ "AND B.id=A.file_id ORDER BY type ASC  ";
	
	//안씀.ProducMainImageSqls쿼리로 대체함 
	//type=0 ; 메인이미지, type = 1; 서브이미지.
	static final String SELECT_PRODUCT_MAIN_IMAGES_BY_PRODUCT_ID=
													"SELECT id,product_id, file_id, type FROM PRODUCT_IMAGE "
															+ "WHERE product_id=:product_id and type=0 ";
	
	//상세페이지에서 product의 메인&서브 이미지 개수 카운트 
	static final String COUNT_PRODUCT_IMAGES_BY_PRODUCT=
													"SELECT COUNT(*) FROM PRODUCT_IMAGE as A, FILE as B "
													+ "WHERE A.product_id=:product_id "
													+ "AND (A.type=0 OR A.type=1) "
													+ "AND A.file_id=B.id "
													+ "AND B.delete_flag=0";
	
	static final String COUNT_ALL_PRODUCT_IMAGES="SELECT COUNT(*) FROM PRODUCT_IMAGE ";
}
