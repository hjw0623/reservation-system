package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hwj.reservation.dao.CategoryDao;
import hwj.reservation.domain.Category;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao dao;
	
	public CategoryServiceImpl(CategoryDao dao){
		super();
		this.dao = dao;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Category> getAllList() throws SQLException {
		return this.dao.selectAllCategory();
	}

	@Override
	@Transactional(readOnly=true)
	public Category getByName(String name) throws SQLException {
		return this.dao.selectByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Category getById(Integer id) throws SQLException {
		return this.dao.selectById(id);
	}

	@Override
	@Transactional(readOnly=false)
	public boolean update(Category category) {
		int affected = dao.update(category);
		return affected !=0;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean deleteById(Integer id) {
		int affected = dao.deleteById(id);
		
		return affected ==1;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean deleteByName(String name) {
		int affected = dao.deleteByName(name);
		return affected ==1;
	}

	@Override
	@Transactional(readOnly=false)
	public Category create(Category category) {
		Integer id = dao.insert(category);
		category.setId(id);
		return category;
	}

}
