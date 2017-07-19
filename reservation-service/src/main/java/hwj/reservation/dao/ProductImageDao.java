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

import hwj.reservation.domain.FileDTO;
import hwj.reservation.domain.ProductImageDTO;

@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	private RowMapper<ProductImageDTO> rowMapper = BeanPropertyRowMapper.newInstance(ProductImageDTO.class);
	private RowMapper<FileDTO> fileRowMapper = BeanPropertyRowMapper.newInstance(FileDTO.class);
	//Dao FileDao
	public  ProductImageDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction  = new SimpleJdbcInsert(dataSource)
				.withTableName("PRODUCT_IMAGE")
				.usingGeneratedKeyColumns("id");
	}
	//create
	// SimpleJdbcInsert
	public Integer insert(ProductImageDTO productImageDto) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(productImageDto);
		int productImageId = insertAction.executeAndReturnKey(params).intValue();
		System.out.println("productImageId: "+productImageId);
		return productImageId;
	}
	//select All product Images
	public List<ProductImageDTO> selectAllProductImageList()  {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.query(ProductImageSqls.SELECT_ALL_PRODUCT_IMAGES, params, rowMapper);
	}
		
	//SELECT product Images  BY product id
	//Product_Image 테이블과 file 테이블의 조인 연산결과로 fileDTO를 반환.
	//return FileDTO. 불필요한 DTO양산을 막고 쿼리를 분할하자.
	public List<FileDTO> selectProductImagesListByProductId(Integer productId) throws SQLException  {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		return jdbc.query(ProductImageSqls.SELECT_PRODUCT_IMAGES_BY_PRODUCT_ID, params, fileRowMapper);
	}
	//COUNT BY productId
	public Integer countByProductId(Integer productId) throws SQLException {
		Map<String, ?> params = Collections.singletonMap("product_id", productId);
		Integer count = jdbc.queryForObject(ProductImageSqls.COUNT_PRODUCT_IMAGES_BY_PRODUCT, params, Integer.class);
		return count;
	}
	
	//not use
	//SELECT the product Main Image BY product id
	public List<ProductImageDTO> selectProductMainImageListByProductId(Integer productId) throws SQLException  {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		return jdbc.query(ProductImageSqls.SELECT_PRODUCT_MAIN_IMAGES_BY_PRODUCT_ID, params, rowMapper);
	}
}
