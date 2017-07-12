package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import hwj.reservation.domain.Product;

public interface ProductService {
	public List<Product> getAllProductList(Integer num)throws SQLException ;
	public List<Product> getListByCategory(Integer categoryId, Integer num)throws SQLException ; 
	public Integer getCountCategroyNumber(Integer id) throws SQLException; 

	//optional not yet used
	public Product create(Product product) throws SQLException;
	public boolean update(Product product);
	//public boolean update(String name);
	public boolean deleteById(Integer id);
	public boolean deleteByName(String name);
	public Product getByName(String name) throws SQLException;
	public Product getById(Integer id) throws SQLException;
}
