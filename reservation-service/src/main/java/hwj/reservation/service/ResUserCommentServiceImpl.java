package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hwj.reservation.dao.ResUserCommentDao;
import hwj.reservation.dao.ResUserCommentImageDao;
import hwj.reservation.domain.ResUserCommentDTO;
import hwj.reservation.domain.ResUserCommentImageDTO;
import hwj.reservation.domain.ResUserCommentWitImageDTO;

@Service
public class ResUserCommentServiceImpl implements ResUserCommentService {
	@Autowired
	ResUserCommentDao dao;
	@Autowired
	ResUserCommentImageDao imgDao;
	public ResUserCommentServiceImpl(ResUserCommentDao dao, ResUserCommentImageDao imgDao ){
		super();
		this.dao = dao;
		this.imgDao = imgDao;
	}
	
	@Override
	@Transactional(readOnly=true)	
	public List<ResUserCommentDTO> getRecentThreeCommentById(Integer id)  throws SQLException{
		
		return dao.getRecentThreeComment(id);
	}

	@Override
	@Transactional(readOnly=true)	
	public List<ResUserCommentDTO> getAllCommentById(Integer id)  throws SQLException{

		return dao.getAllComment(id);
	}

	@Override
	@Transactional(readOnly=true)	
	public Integer getCountTotalCommentById(Integer id) throws SQLException {
		return dao.selectCountTotalCommentById(id);
	}

	@Override
	@Transactional(readOnly=true)	
	public Double getAvgScoreCommentById(Integer id)  {
		Double avgScore =null;
		try{
			avgScore = dao.selectAvgScoreCommentById(id);
			return avgScore;
		}catch(Exception e){
			return avgScore=0.0;
		}
		/*
		if(avgscore==null||avgscore==0.0 ){
			return 0.0;
		}else{
			return avgscore;
		}
		*/
	}

	@Override
	public List<ResUserCommentImageDTO> getImagesRelatedUserComment(Integer commentId) throws SQLException {
		return imgDao.getImgRelatedUserComment(commentId);
	}

	@Override
	@Transactional(readOnly=false)	
	public ResUserCommentImageDTO insert(ResUserCommentImageDTO rUCimg) throws SQLException {
		Integer id = imgDao.insert(rUCimg);
		rUCimg.setId(id);
		return rUCimg;
	}

	//일단 코멘트 리스트를 가져온다. 	
	@Override
	@Transactional(readOnly=true)	
	public List<ResUserCommentWitImageDTO> getAllUserCommentWithImages(Integer productId) throws SQLException {
		return dao.getAllCommentWithImages(productId);
	}
	@Override
	@Transactional(readOnly=true)	
	public List<ResUserCommentWitImageDTO> getThreeUserCommentWithImages(Integer productId) throws SQLException {
		return dao.getThreeCommentWithImages(productId);
	}
}
