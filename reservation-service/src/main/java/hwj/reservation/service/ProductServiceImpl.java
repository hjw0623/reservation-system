package hwj.reservation.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hwj.reservation.dao.CategorySqls;
import hwj.reservation.dao.ProductDao;
import hwj.reservation.dao.ProductMainImageDao;
import hwj.reservation.domain.Category;
import hwj.reservation.domain.DisplayInfoDTO;
import hwj.reservation.domain.ProductDTO;
import hwj.reservation.domain.ProductDetailDTO;
import hwj.reservation.domain.ProductMainImageDTO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao dao;

	public ProductServiceImpl(ProductDao dao ){
		this.dao = dao;
	}
	
	@Override
	@Transactional(readOnly=false)
	public ProductDTO create(ProductDTO product) {
		Integer id = dao.insert(product);
		product.setId(id);
		return product;
	}
	@Override
	public List<ProductDTO> getAllList() throws SQLException {
		return dao.selectAllProductList();
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProductDTO> getListByCategory(Integer categoryId, Integer num) throws SQLException {
		if(categoryId!=1){
			return dao.selectProductListByCategory(categoryId, num);
		}else{
			return dao.selectAllProductList(num);
		}
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<ProductMainImageDTO> getListWithImageByCategory(Integer categoryId, Integer num) throws SQLException {
		if(categoryId!=1){
			return dao.selectProductListWithMainImageByCategory(categoryId, num);
		}else{
			return dao.selectAllProductWithMainImageList(num);
		}
	}
	@Override
	@Transactional(readOnly=true)
	public ProductDTO getById(Integer id) {
		try {
			return dao.selectById(id);
		} catch (SQLException e) {
			return null;		
		}
	}	
	@Override
	@Transactional(readOnly=true)
	public List<ProductDTO> getAllProductList(Integer num)  {
			return dao.selectAllProductList(num);
	}
	
	@Override
	@Transactional(readOnly=true)
	public ProductDTO getByName(String name) {
		try {
			return dao.selectByName(name);
		} catch (SQLException e) {
			return null;
		}
	}

	//--product detail query
	@Override
	@Transactional(readOnly=true)
	public ProductDetailDTO getProductDetailById(Integer id) {
		try {
			return dao.selectProductDetailById(id);
		} catch (SQLException e) {
			return null;
		}
	}
	//--display info query
	@Override
	@Transactional(readOnly=true)
	public DisplayInfoDTO getDisplayInfoById(Integer id) {
		try {
			return dao.selectDisplayInfoById(id);
		} catch (SQLException e) {
			return null;
		}
	}
	
	//below: no use yet
	@Override
	@Transactional(readOnly=false)
	public boolean update(ProductDTO product) {
		int affected = dao.update(product);
		return affected==1;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean deleteById(Integer id) {
		int affected = dao.deleteById(id);
		return affected==1;
	}

	@Override
	public boolean deleteByName(String name) {
		int affected = dao.deleteByName(name);
		return affected==1;
	}

	@Override
	@Transactional(readOnly=true)
	public Integer getCountCategroyNumber(Integer id) throws SQLException {
		Integer count = dao.countByCategoryId(id);
		return count;
	}

	

	

}
