package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import hwj.reservation.domain.FileDTO;
import hwj.reservation.domain.ProductImageDTO;

public interface ProductImageService {
	public ProductImageDTO insert(ProductImageDTO productImageDto); //2nd way
	public List<ProductImageDTO> getAllProductImageList() throws SQLException;
	public List<FileDTO> getProductImagesByProductId(Integer productId) throws SQLException;
	public Integer getCountProductImages(Integer productId) throws SQLException; 

	//public List<ProductImageDTO> getProductMainImageByProductId(Integer productId) throws SQLException;

}
