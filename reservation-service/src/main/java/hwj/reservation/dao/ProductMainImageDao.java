package hwj.reservation.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import hwj.reservation.domain.ProductDTO;
import hwj.reservation.domain.ProductMainImageDTO;

//Table 3개의 Join 연산결과에 따른 조회만을 나타낸다.
@Repository
public class ProductMainImageDao {
	private NamedParameterJdbcTemplate jdbc;
	
	private RowMapper<ProductMainImageDTO> rowMapper = BeanPropertyRowMapper.newInstance(ProductMainImageDTO.class);
	//Dao ProductDao
	
	//SELECT Product List with Main Image By CATEGORY ID and limit num
	public List<ProductMainImageDTO> selectProductListWithMainImageByCategory(Integer categoryId, Integer num) throws SQLException  {
		Map<String, Object> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("num", num);
		return jdbc.query(ProductMainImageSqls.SELECT_WITH_MAIN_IMAGE_BY_CATEGORY_ID, params, rowMapper);
	}
	
	//select All List with Main Image limit num
	public List<ProductMainImageDTO> selectAllProductWithMainImageList(Integer num)  {
		Map<String, Object> params =new HashMap<>();
		params.put("num", num);
		return jdbc.query(ProductMainImageSqls.SELECT_ALL_PRODUCT_WITH_MAIN_IMAGE, params, rowMapper);
	}
}
