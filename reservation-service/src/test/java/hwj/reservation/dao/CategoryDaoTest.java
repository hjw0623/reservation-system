package hwj.reservation.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hwj.reservation.config.RootApplicationContextConfig;
import hwj.reservation.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootApplicationContextConfig.class)
@Transactional
public class CategoryDaoTest {
	@Autowired
	CategoryDao categoryDao;
	/*
	@Test
	public void shoudInsertAndSelect() {
		Category category = new Category("exhibition");
		Integer categoryPk = categoryDao.insert(category);
		Category result = categoryDao.selectById(categoryPk);
		System.out.println(result.getName());
		assertThat(result.getName(), is("exhibition"));
	}
	
	@Test
	public void shouldUpdate(){
		//given
		Category category = new Category("gallery");
		Integer categoryPk = categoryDao.insert(category);
		category.setId(categoryPk);
		
		//check
		category.setName("kidszone");
		int affected = categoryDao.update(category);
		
		//Then
		assertThat(affected, is(1));
		Category updated = categoryDao.selectById(categoryPk);
		assertThat(updated.getName(), is("kidszone"));
	}
	
	@Test
	public void shouldDelete(){
		//given
		Category category = new Category("museum");
		Integer categoryPk = categoryDao.insert(category);
		
		//when
		int affected = categoryDao.deleteById(categoryPk);
		
		//Then
		assertThat(affected, is(1));
	}
	
	@Test
	public void shouldFindAll(){
		List<Category> allCategory = categoryDao.selectAllCategory();
		System.out.println(allCategory.get(0).getName());
		assertThat(allCategory, is(notNullValue()));
	}
	*/
}
