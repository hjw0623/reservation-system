package hwj.reservation.dao;

public class DisplayInfoSqls {
	static final String SELECT_DISPLAY_INFO_BY_PRODUCT_ID=
			"select A.id, A.product_id, A.observation_time, A.display_start, A.display_end, A.place_name, A.place_lot, A.place_street, "
						+"A.tel, A.homepage, A.email, A.create_date, A.modify_date "
						+"from DISPLAY_INFO as A, PRODUCT as B "
						+"where A.product_id = B.id AND B.id=:id";
	
}
