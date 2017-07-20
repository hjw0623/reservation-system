package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import hwj.reservation.domain.NaverLoginUser;
import hwj.reservation.domain.ProductDTO;
import hwj.reservation.domain.Users;


public interface LoginUsersService {
	public List<Users> getAllUsers()throws SQLException ; 
	public boolean update(Users product);
	public Users getById(Integer id) throws SQLException;
	public Users create(NaverLoginUser nLoginUser) throws SQLException;
	public Users update(NaverLoginUser nLoginUser) throws SQLException;;

}
