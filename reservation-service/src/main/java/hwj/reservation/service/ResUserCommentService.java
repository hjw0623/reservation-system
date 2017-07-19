package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import hwj.reservation.domain.ResUserCommentDTO;
import hwj.reservation.domain.ResUserCommentImageDTO;
import hwj.reservation.domain.ResUserCommentWitImageDTO;

public interface ResUserCommentService {
	public List<ResUserCommentDTO>getRecentThreeCommentById(Integer id) throws SQLException;
	public List<ResUserCommentDTO>getAllCommentById(Integer id) throws SQLException;
	public Integer getCountTotalCommentById(Integer id) throws SQLException;
	public Double getAvgScoreCommentById(Integer id)throws SQLException;
	public List<ResUserCommentImageDTO> getImagesRelatedUserComment(Integer commentId) throws SQLException;
	public ResUserCommentImageDTO insert(ResUserCommentImageDTO rUCimgDTO) throws SQLException;
	//
	public List<ResUserCommentWitImageDTO> getAllUserCommentWithImages(Integer productId) throws SQLException;
	public List<ResUserCommentWitImageDTO> getThreeUserCommentWithImages(Integer productId) throws SQLException;

}
