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
import hwj.reservation.domain.DisplayInfoDTO;
import hwj.reservation.domain.ProductDTO;
import hwj.reservation.domain.ProductDetailDTO;
import hwj.reservation.domain.ProductMainImageDTO;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	private RowMapper<ProductDTO> rowMapper = BeanPropertyRowMapper.newInstance(ProductDTO.class);
	private RowMapper<ProductMainImageDTO> rowMapper2 = BeanPropertyRowMapper.newInstance(ProductMainImageDTO.class);
	private RowMapper<DisplayInfoDTO> displayInforowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoDTO.class);
	private RowMapper<ProductDetailDTO> productDetailRowMapper = BeanPropertyRowMapper.newInstance(ProductDetailDTO.class);

	
	//Dao ProductDao
	//optional
	public  ProductDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction  = new SimpleJdbcInsert(dataSource)
				.withTableName("product")
				.usingGeneratedKeyColumns("id");
	}
	// SimpleJdbcInsert
	public Integer insert(ProductDTO product) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(product);
		return  insertAction.executeAndReturnKey(params).intValue();
	}
	//select All limit num
	public List<ProductDTO> selectAllProductList(Integer num)  {
		Map<String, Object> params =new HashMap<>();
		params.put("num", num);
		return jdbc.query(ProductSqls.SELECT_ALL_PRODUCT, params, rowMapper);
	}
	
	public List<ProductDTO> selectAllProductList()  {
		Map<String, Object> params =Collections.emptyMap();
		return jdbc.query(ProductSqls.SELECT_ALL_PRODUCT_DEFAULT, params, rowMapper);
	}
	
	//SELECT Product List BY CATEGORY ID
	public List<ProductDTO> selectProductListByCategory(Integer categoryId, Integer num) throws SQLException  {
		Map<String, Object> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("num", num);
		return jdbc.query(ProductSqls.SELECT_BY_CATEGORY_ID, params, rowMapper);
	}
	
	//COUNT BY CategoryId
	public Integer countByCategoryId(Integer id) throws SQLException {
		Integer count;
		Map<String, ?> params = Collections.singletonMap("category_id", id);
		if(id!=1){
			count = jdbc.queryForObject(ProductSqls.COUNT_PRODUCT_BY_CATEGORY, params, Integer.class);
		}else{//전체 출력 
			params = Collections.emptyMap();
			count = jdbc.queryForObject(ProductSqls.COUNT_ALL_PRODUCT, params, Integer.class);
		}
		return count;
	}
	//SELECT display info
	public DisplayInfoDTO selectDisplayInfoById(Integer id)  throws SQLException{
		Map<String, Object>params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(DisplayInfoSqls.SELECT_DISPLAY_INFO_BY_PRODUCT_ID, params, displayInforowMapper);
	}
	//SELECT ProductDetail
	public ProductDetailDTO selectProductDetailById(Integer id)  throws SQLException{
		Map<String, Object>params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(ProductDetailSqls.SELECT_PRODUCT_DETAIL_BY_PRODUCT_ID, params, productDetailRowMapper);
	}
	//****
	//SELECT Product List with Main Image By CATEGORY ID and limit num
	public List<ProductMainImageDTO> selectProductListWithMainImageByCategory(Integer categoryId, Integer num) throws SQLException  {
		Map<String, Object> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("num", num);
		return jdbc.query(ProductMainImageSqls.SELECT_WITH_MAIN_IMAGE_BY_CATEGORY_ID, params, rowMapper2);
	}
		
	//select All List with Main Image limit num
	public List<ProductMainImageDTO> selectAllProductWithMainImageList(Integer num)  {
		Map<String, Object> params =new HashMap<>();
		params.put("num", num);
		return jdbc.query(ProductMainImageSqls.SELECT_ALL_PRODUCT_WITH_MAIN_IMAGE, params, rowMapper2);
	}
	//***

	//SELECT BY ID
	public ProductDTO selectById(Integer id)  throws SQLException{
		Map<String, Object>params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(ProductSqls.SELECT_BY_PRODUCT_ID, params, rowMapper);
	}
	//SELECT BY NAME
	public ProductDTO selectByName(String name) throws SQLException {
		Map<String, Object>params = new HashMap<>();
		params.put("name", name);
		return jdbc.queryForObject(ProductSqls.SELECT_BY_PRODUCT_NAME, params, rowMapper);
	}
	//UPDATE 
	public int update(ProductDTO product){
		SqlParameterSource params = new BeanPropertySqlParameterSource(product);
		return jdbc.update(ProductSqls.UPDATE_PRODUCT_NAME, params);
	}
	//DELETE BY ID
	public int deleteById(Integer id){
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(ProductSqls.DELETE_BY_PRODUCT_ID, params);		
	}
	//DELETE BY NAME
	public int deleteByName(String name){
		Map<String, ?> params = Collections.singletonMap("name", name);
		return jdbc.update(ProductSqls.DELETE_BY_PRODUCT_NAME, params);		
	}
	
	
}
