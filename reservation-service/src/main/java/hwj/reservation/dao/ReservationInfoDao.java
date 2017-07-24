package hwj.reservation.dao;

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

import hwj.reservation.domain.ProductDTO;
import hwj.reservation.domain.ReservationInfoDTO;

@Repository
public class ReservationInfoDao {

	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationInfoDTO> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfoDTO.class);
	
	public  ReservationInfoDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction  = new SimpleJdbcInsert(dataSource)
				.withTableName("RESERVATION_INFO")
				.usingGeneratedKeyColumns("id");
	}
	// SimpleJdbcInsert
	public Integer insert(ReservationInfoDTO reservation) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservation);
		return  insertAction.executeAndReturnKey(params).intValue();
	}
	
	public List<ReservationInfoDTO> selectByUserId(Integer userId){
		Map<String, Object>params = new HashMap<>();
		params.put("user_id", userId);
		return jdbc.query(ReservationInfoSqls.SELECT_RESERVATION_INFO_BY_USER_ID, params, rowMapper);
	}
}
