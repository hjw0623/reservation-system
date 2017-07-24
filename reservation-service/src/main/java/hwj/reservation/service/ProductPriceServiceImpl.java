package hwj.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hwj.reservation.dao.ProductPriceDao;
import hwj.reservation.dao.UsersDao;
import hwj.reservation.domain.ProductPriceDTO;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

	@Autowired
	ProductPriceDao dao;
	public ProductPriceServiceImpl(ProductPriceDao dao ){
		super();
		this.dao = dao;
	}
	@Override
	public List<ProductPriceDTO> getProductPriceByProductId(Integer productId) {
		try{
			List<ProductPriceDTO> priceList = dao.getPriceListByProductId(productId);
			return priceList;
		}catch(Exception e){
			return null;
		}
	}

	//unused yet
	@Override
	public int updateProductPrice(Integer productId, Integer price) {
		return 0;
	}

	@Override
	public int updateDiscountRate(Integer productId, double discountRate) {
		return 0;
	}

	@Override
	public int updatePriceType(Integer productId, Integer pricetype) {
		return 0;
	}
	

}
