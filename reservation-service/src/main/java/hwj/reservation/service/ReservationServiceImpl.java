package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hwj.reservation.dao.ReservationInfoDao;
import hwj.reservation.domain.ReservationInfoDTO;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationInfoDao dao;
	public ReservationServiceImpl(ReservationInfoDao dao){
		this.dao = dao;
	}
	
	@Override
	@Transactional(readOnly=false)
	public ReservationInfoDTO insert(ReservationInfoDTO dto) throws SQLException {
		int id = dao.insert(dto);
		dto.setId(id);
		return dto;
	}

	@Override
	@Transactional(readOnly=true)
	public ReservationInfoDTO selectByProductIdAndUserId(Integer productId, Integer userId) throws SQLException {
		
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ReservationInfoDTO> selectByUserId(Integer userId) throws SQLException {
		
		return null;
	}

	
	
}
