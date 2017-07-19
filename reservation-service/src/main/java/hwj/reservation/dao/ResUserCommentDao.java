package hwj.reservation.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import hwj.reservation.domain.FileDTO;
import hwj.reservation.domain.ProductMainImageDTO;
import hwj.reservation.domain.ResUserCommentDTO;
import hwj.reservation.domain.ResUserCommentImageDTO;
import hwj.reservation.domain.ResUserCommentWitImageDTO;


@Repository
public class ResUserCommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	private RowMapper<ResUserCommentDTO> rowMapper = BeanPropertyRowMapper.newInstance(ResUserCommentDTO.class);
	private RowMapper<ResUserCommentWitImageDTO> rowMapperWithImages = BeanPropertyRowMapper.newInstance(ResUserCommentWitImageDTO.class);
	private RowMapper<FileDTO> rowMapperForFile =  BeanPropertyRowMapper.newInstance(FileDTO.class);
	//constructor
	public  ResUserCommentDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction  = new SimpleJdbcInsert(dataSource)
				.withTableName("RESERVATION_USER_COMMENT")
				.usingGeneratedKeyColumns("id");
	}
	
	//
	public List<ResUserCommentWitImageDTO> getAllCommentWithImages(Integer productId) throws SQLException  {
		
		//반환할 코멘트 1개당 0~n개의파일 이미지 DTO
		List<ResUserCommentWitImageDTO> resUserComWithImageList = new ArrayList<ResUserCommentWitImageDTO>();
		
		//step 1. 코멘트를 가져온다.
		Map<String, Object> params = new HashMap<>();
		
		params.put("product_id", productId);
		List<ResUserCommentDTO> resUserCommentList
					= jdbc.query(ResUserCommentSqls.SELECT_ALL_COMMENT_BY_PRODUCT_ID, params, rowMapper);
		
		for(ResUserCommentDTO dto : resUserCommentList){
			
			ResUserCommentWitImageDTO rUCWImgDTO = new ResUserCommentWitImageDTO();
			rUCWImgDTO.setId(dto.getId());
			rUCWImgDTO.setProductId(dto.getProductId());
			rUCWImgDTO.setProductName(dto.getProductName());
			rUCWImgDTO.setUserId(dto.getUserId());
			rUCWImgDTO.setUserName(dto.getUserName());
			rUCWImgDTO.setScore(dto.getScore());
			rUCWImgDTO.setComment(dto.getComment());
			rUCWImgDTO.setCreate_date(dto.getCreate_date());
			rUCWImgDTO.setModify_date(dto.getModify_date());
			
			resUserComWithImageList.add(rUCWImgDTO);
		}
	
		return resUserComWithImageList;
	}
	
	
	public List<ResUserCommentWitImageDTO> getThreeCommentWithImages(Integer productId) throws SQLException  {
		//반환할 코멘트 1개당 0~n개의파일 이미지 DTO
		List<ResUserCommentWitImageDTO> resUserComWithImageList = new ArrayList<ResUserCommentWitImageDTO>();
		
		//step 1. 코멘트를 가져온다.
		Map<String, Object> params = new HashMap<>();
		
		params.put("product_id", productId);
		List<ResUserCommentDTO> resUserCommentList
					= jdbc.query(ResUserCommentSqls.SELECT_THREE_COMMENT_BY_PRODUCT_ID, params, rowMapper);
		//log.info("success");
		
		for(ResUserCommentDTO dto : resUserCommentList){
			
			ResUserCommentWitImageDTO rUCWImgDTO = new ResUserCommentWitImageDTO();
			rUCWImgDTO.setId(dto.getId());
			rUCWImgDTO.setProductId(dto.getProductId());
			rUCWImgDTO.setProductName(dto.getProductName());
			rUCWImgDTO.setUserId(dto.getUserId());
			rUCWImgDTO.setUserName(dto.getUserName());
			rUCWImgDTO.setScore(dto.getScore());
			rUCWImgDTO.setComment(dto.getComment());
			rUCWImgDTO.setCreate_date(dto.getCreate_date());
			rUCWImgDTO.setModify_date(dto.getModify_date());
			
			resUserComWithImageList.add(rUCWImgDTO);
		}

		return resUserComWithImageList;
	}
	
	//
	public Integer selectCountTotalCommentById(Integer productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		return  jdbc.queryForObject(ResUserCommentSqls.COUNT_ALL_COMMENT_BY_PRODUCT_ID, params, Integer.class);
	}
	public Double selectAvgScoreCommentById(Integer productId) {
		Map<String, ?> params = Collections.singletonMap("product_id", productId);
		Double count;
		try{
			count = jdbc.queryForObject(ResUserCommentSqls.AVERAGE_COMMENT_SCORE_BY_PRODUCT_ID, params, Double.class);
			return count;
		}catch(Exception e){
			count =0.0;
			return count;
		}
		
	}
	//depreciated
	public List<ResUserCommentDTO> getRecentThreeComment(Integer productId) throws SQLException  {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		return jdbc.query(ResUserCommentSqls.SELECT_THREE_COMMENT_BY_PRODUCT_ID, params, rowMapper);
	}
	
	public List<ResUserCommentDTO> getAllComment(Integer productId) throws SQLException  {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		return jdbc.query(ResUserCommentSqls.SELECT_ALL_COMMENT_BY_PRODUCT_ID, params, rowMapper);
	}
}
