package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hwj.reservation.dao.ProductImageDao;
import hwj.reservation.domain.FileDTO;
import hwj.reservation.domain.ProductImageDTO;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Autowired
	ProductImageDao dao;
	
	public ProductImageServiceImpl(ProductImageDao Dao){
		super();
		this.dao = Dao;
	}
	@Override
	public ProductImageDTO insert(ProductImageDTO productImageDto) {
		Integer id = dao.insert(productImageDto);
		System.out.println("파일이미지 id: "+id);
		productImageDto.setId(id);
		return productImageDto;
	}

	@Override
	public List<ProductImageDTO> getAllProductImageList() throws SQLException {
		return dao.selectAllProductImageList();
	}

	@Override
	public List<FileDTO>  getProductImagesByProductId(Integer productId) throws SQLException {
		return dao.selectProductImagesListByProductId(productId);
	}
	
	@Override
	public Integer getCountProductImages(Integer productId) throws SQLException {
		return dao.countByProductId(productId);
	}

}
