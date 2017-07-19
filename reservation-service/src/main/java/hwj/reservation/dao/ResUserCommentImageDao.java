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

import hwj.reservation.domain.FileDTO;
import hwj.reservation.domain.ResUserCommentDTO;
import hwj.reservation.domain.ResUserCommentImageDTO;

@Repository
public class ResUserCommentImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	private RowMapper<ResUserCommentImageDTO> rowMapper = BeanPropertyRowMapper.newInstance(ResUserCommentImageDTO.class);
	//insert
	public  ResUserCommentImageDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction  = new SimpleJdbcInsert(dataSource)
				.withTableName("RESERVATION_USER_COMMENT_IMAGE")
				.usingGeneratedKeyColumns("id");
	}
	// SimpleJdbcInsert
	public Integer insert(ResUserCommentImageDTO rUCImg) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(rUCImg);
		int rUCImgId = insertAction.executeAndReturnKey(params).intValue();
		return rUCImgId;
	}
	//select by comment id
	public List<ResUserCommentImageDTO> getImgRelatedUserComment(Integer commentId) {
		Map<String, Object> params = new HashMap<>();
		params.put("comment_id", commentId);
		return jdbc.query(ResUserCommentImageSqls.SELECT_IMAGES_BY_COMMENT_ID, params, rowMapper);
	}
	
	//select comment with imgges
	
	
}
