package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import hwj.reservation.domain.ReservationInfoDTO;

public interface ReservationService {
	public ReservationInfoDTO insert(ReservationInfoDTO dto) throws SQLException;
	public ReservationInfoDTO selectByProductIdAndUserId(Integer productId, Integer userId) throws SQLException;
	public List<ReservationInfoDTO>  selectByUserId(Integer userId) throws SQLException;
	
}
