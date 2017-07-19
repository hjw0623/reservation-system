package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import hwj.reservation.domain.DisplayInfoDTO;
import hwj.reservation.domain.ProductDTO;
import hwj.reservation.domain.ProductDetailDTO;
import hwj.reservation.domain.ProductMainImageDTO;

public interface ProductService {
	public List<ProductDTO> getAllProductList(Integer num)throws SQLException ;
	public List<ProductDTO> getAllList()throws SQLException ; 
	//only product list by categoryId
	public List<ProductDTO> getListByCategory(Integer categoryId, Integer num)throws SQLException ; 
	//product list with image  by categoryId
	//조인 연산결과를 받는 DTO이고 메인페이지에서 사용되므로 별도의 Service를 만들지 않고 ProductService에 추
	public List<ProductMainImageDTO> getListWithImageByCategory(Integer categoryId, Integer num)throws SQLException ; 

	public Integer getCountCategroyNumber(Integer id) throws SQLException; 

	//optional not yet used
	public ProductDTO create(ProductDTO product) throws SQLException;
	public boolean update(ProductDTO product);
	//public boolean update(String name);
	public boolean deleteById(Integer id);
	public boolean deleteByName(String name);
	public ProductDTO getByName(String name) throws SQLException;
	public ProductDTO getById(Integer id) throws SQLException;
	
	//productDetail
	public ProductDetailDTO getProductDetailById(Integer id)throws SQLException;
	//displayInfo
	public DisplayInfoDTO getDisplayInfoById(Integer id)throws SQLException;
}
