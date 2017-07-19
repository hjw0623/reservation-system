package hwj.reservation.dao;

public class ProductDetailSqls {
	static final String SELECT_PRODUCT_DETAIL_BY_PRODUCT_ID=
			"select A.id, A.product_id, A.content, A.create_date, A.modify_date "
			+"from PRODUCT_DETAIL as A, PRODUCT as B "
			+"where A.product_id=B.id AND B.id=:id ";			
}
