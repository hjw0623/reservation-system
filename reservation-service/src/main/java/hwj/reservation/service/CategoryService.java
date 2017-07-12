package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import hwj.reservation.domain.Category;

public interface CategoryService {
	public Category create(Category category);
	public List<Category> getAllList() throws SQLException;
	public Category getByName(String name) throws SQLException;
	public Category getById(Integer id) throws SQLException;
	public boolean update(Category category);
	public boolean deleteById(Integer id);
	public boolean deleteByName(String name);
	
}
