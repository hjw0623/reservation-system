package hwj.reservation.dao;


import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import hwj.reservation.domain.Category;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	//Dao Constructor
	public  CategoryDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction  = new SimpleJdbcInsert(dataSource)
				.withTableName("category")
				.usingGeneratedKeyColumns("id");
	}
	// SimpleJdbcInsert
	public Integer insert(Category category){
		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
		return  insertAction.executeAndReturnKey(params).intValue();
	}
	
	//select All
	public List<Category> selectAllCategory() throws SQLException {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.query(CategorySqls.SELECT_ALL_CATEGORY, params, rowMapper);
	}
	//SELECT BY ID
	public Category selectById(Integer id) throws SQLException{
		Map<String, Object>params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(CategorySqls.SELECT_BY_CID, params, rowMapper);
	}
	//SELECT BY NAME
	public Category selectByName(String name) throws SQLException{
		Map<String, Object>params = new HashMap<>();
		params.put("name", name);
		return jdbc.queryForObject(CategorySqls.SELECT_BY_CNAME, params, rowMapper);
	}
	//UPDATE 
	public int update(Category category){
		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
		return jdbc.update(CategorySqls.UPDATE_CATEGORY, params);
	}
	//DELETE BY ID
	public int deleteById(Integer id){
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(CategorySqls.DELETE_BY_CID, params);		
	}
	//DELETE BY NAME
	public int deleteByName(String name){
		Map<String, ?> params = Collections.singletonMap("name", name);
		return jdbc.update(CategorySqls.DELETE_BY_CNAME, params);		
	}
}
