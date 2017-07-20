package hwj.reservation.dao;

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
import hwj.reservation.domain.NaverLoginUser;
import hwj.reservation.domain.Users;

@Repository
public class UsersDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	private RowMapper<Users> rowMapper = BeanPropertyRowMapper.newInstance(Users.class);
	//insert
	public  UsersDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction  = new SimpleJdbcInsert(dataSource)
				.withTableName("USERS")
				.usingGeneratedKeyColumns("id");
	}
	//insert 2nd
	public Integer insertSql (FileDTO fileDto){
		Map<String, Object> params =new HashMap<>();
		params.put("file_name", fileDto.getFileName());
		params.put("save_file_name", fileDto.getSaveFileName());
		params.put("file_length", fileDto.getFileLength());
		params.put("content_type", fileDto.getContentType());
		params.put("delete_flag", fileDto.getDeleteFlag());
		
		return jdbc.update(FileSqls.CREATE_FILE, params);
	}
	
	public Users create(NaverLoginUser naverLoginUser){
		Map<String, Object> params =new HashMap<>();
		params.put("id", naverLoginUser.getId());
		params.put("email", naverLoginUser.getEmail());
		params.put("username", naverLoginUser.getName());
		params.put("nickname", naverLoginUser.getNickname());
		params.put("admin_flag",0);
		jdbc.update(UsersSqls.INSERT_USER, params);
		return null;
	}

	public Users selectById(Integer id){
		Map<String, Object> params =new HashMap<>();
		params.put("id", id);
		try{
			Users user = jdbc.queryForObject(UsersSqls.SELECT_USER_BY_ID, params, rowMapper );
			return user;
		}catch(Exception e){
			return null;

		}
	
	}
	public List<Users> selectAllUsers(){
		Map<String, Object> params = Collections.emptyMap();
		
		return jdbc.query(UsersSqls.SELECT_ALL_USERS, params, rowMapper);
	}
	public int updateById(Integer id){
		Map<String, Object> params =new HashMap<>();
		params.put("id", id);
		return jdbc.update(UsersSqls.UPDATE_USER_BY_ID, params);
	}
}
