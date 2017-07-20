package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hwj.reservation.dao.ResUserCommentDao;
import hwj.reservation.dao.ResUserCommentImageDao;
import hwj.reservation.dao.UsersDao;
import hwj.reservation.domain.NaverLoginUser;
import hwj.reservation.domain.Users;

@Service
public class LoginUsersServiceImpl implements LoginUsersService {
	@Autowired
	UsersDao dao;
	public LoginUsersServiceImpl(UsersDao dao ){
		super();
		this.dao = dao;
	}
	@Override
	public List<Users> getAllUsers() throws SQLException {


		return null;
	}
	//내부 업데이트 
	@Override
	public boolean update(Users user) {
		return false;
	}

	@Override
	public Users getById(Integer id) throws SQLException {
	
		Users user = dao.selectById(id);
	
		return user;
	}

	@Override
	public Users create(NaverLoginUser naverLoginUser) throws SQLException {
		Integer id = (Integer) naverLoginUser.getId();
		Users found = dao.selectById(id);
		//변경정보 있으면 업데이트 
		if(found!=null){
			return found;
		}else{
			Users newbie = dao.create(naverLoginUser);
			return newbie;
		}
	}
	//OAuth 시 업데이트 
	@Override
	public Users update(NaverLoginUser naverLoginUser) throws SQLException {
		Integer id = (Integer) naverLoginUser.getId();
		Users found = dao.selectById(id);
		if(found.getNickname().equals(naverLoginUser.getNickname())){
			return found;
		}else{
			dao.updateById(id);
			found.setNickname(naverLoginUser.getNickname());
			return found;
		}
	}

}
