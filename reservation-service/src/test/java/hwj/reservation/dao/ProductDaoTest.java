package hwj.reservation.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hwj.reservation.config.RootApplicationContextConfig;
import hwj.reservation.domain.Category;
import hwj.reservation.domain.Product;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootApplicationContextConfig.class)
@Transactional
public class ProductDaoTest {

	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categoryDao;
	//int id, int categoryId, String name, String description, Date salesStart, Date salesEnd,
	//int salesFlag, String event, Date createDate, Date modifyDate
	/*
	@Test
	public void shoudInsertAndSelect() {
		java.sql.Date start = java.sql.Date.valueOf( "2017-08-02 07:30:00");
		java.sql.Date end = java.sql.Date.valueOf("2017-12-30 07:30:00");
		java.sql.Date first = java.sql.Date.valueOf("2017-08-02 07:30:00");
		java.sql.Date modified = java.sql.Date.valueOf("2017-08-02 07:30:00");
		
		Product product = new Product(8, "뮤지컬1", "description",
									  start, end, 1, "event 서술", first,  modified);
		Integer productPk = productDao.insert(product);
		Product result = productDao.selectById(productPk);
		System.out.println(result.getName());
		assertThat(result.getName(), is("뮤지컬1"));
	}
	*/
	
	@Test
	public void shouldSelectAll() throws SQLException{
		int num = 10;
		List<Product> allProduct;
		allProduct = productDao.selectAllProductList(10);
		if(allProduct!=null){
			System.out.println(allProduct.get(0).getName());		
		}
		assertThat(allProduct, is(notNullValue()));
	}
	
	
	
	/*
	@Test
	public void shouldSelectByCategory(){
		Integer categoryId;
		try {
			categoryId = categoryDao.selectByName("뮤지컬").getId();
			try {
				List<Product> selectByCategory = productDao.selectProductListByCategory(categoryId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("Category Not found");
		}	
	}
	*/
	@Test
	public void shouldSelectByCategory() throws SQLException{
		int categoryId = 16;
		List<Product> allProduct;
		allProduct = productDao.selectProductListByCategory(categoryId, 10);
		if(allProduct!=null){
			System.out.println(allProduct.get(0).getName());		
		}else{
			System.out.println("list is null");
		}
		assertThat(allProduct, is(notNullValue()));
	}
	@Test
	public void shouldCount() throws SQLException {
		int id = 16;
		//given
		int  count = productDao.countByCategoryId(id);
		//Then
		assertThat(count, is(5));
	}
	/*
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
