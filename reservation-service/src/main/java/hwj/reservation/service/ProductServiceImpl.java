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
import hwj.reservation.domain.Category;
import hwj.reservation.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao dao;
	
	public ProductServiceImpl(ProductDao dao){
		this.dao = dao;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Product create(Product product) {
		Integer id = dao.insert(product);
		product.setId(id);
		return product;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Product> getListByCategory(Integer categoryId, Integer num) throws SQLException {
		if(categoryId!=1){
			return dao.selectProductListByCategory(categoryId, num);
		}else{
			return dao.selectAllProductList(num);
		}
	}
	
	//below: no use yet
	@Override
	@Transactional(readOnly=true)
	public List<Product> getAllProductList(Integer num)  {
			return dao.selectAllProductList(num);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Product getByName(String name) {
		try {
			return dao.selectByName(name);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Product getById(Integer id) {
		try {
			return dao.selectById(id);
		} catch (SQLException e) {
			return null;		
		}
	}	
	@Override
	@Transactional(readOnly=false)
	public boolean update(Product product) {
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
