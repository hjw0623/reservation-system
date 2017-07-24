package hwj.reservation.dao;

import java.sql.SQLException;
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

import hwj.reservation.domain.ProductPriceDTO;


@Repository

public class ProductPriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	private RowMapper<ProductPriceDTO> rowMapper = BeanPropertyRowMapper.newInstance(ProductPriceDTO.class);
	//insert
	public  ProductPriceDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction  = new SimpleJdbcInsert(dataSource)
				.withTableName("PRODUCT_PRICE")
				.usingGeneratedKeyColumns("id");
	}
	// SimpleJdbcInsert
	public Integer insert(ProductPriceDTO priceDto) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(priceDto);
		int id = insertAction.executeAndReturnKey(params).intValue();
		return id;
	}
	//select price list
	public List<ProductPriceDTO> getPriceListByProductId(Integer productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		try{
			return jdbc.query(ProductPriceSqls.SELECT_PRODUCT_PRICES_BY_PRODUCT_ID, params, rowMapper);
		}catch(Exception e){
			return null;
		}
	}
	
}
