package hwj.reservation.dao;

public class ProductPriceSqls {
	static final String SELECT_PRODUCT_PRICES_BY_PRODUCT_ID=
			"SELECT id, product_id, price_type, price, discount_rate, create_date, modify_date "
			+ "FROM PRODUCT_PRICE "
			+ "WHERE product_id=:product_id ";
}
