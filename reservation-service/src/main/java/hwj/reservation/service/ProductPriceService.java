package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import hwj.reservation.domain.ProductPriceDTO;

public interface ProductPriceService {
	public List<ProductPriceDTO> getProductPriceByProductId(Integer productId) throws SQLException ;
	public int updateProductPrice(Integer productId, Integer price);
	public int updateDiscountRate(Integer productId, double discountRate);
	public int updatePriceType(Integer productId, Integer pricetype);
}
