package hwj.reservation.dao;

public class UsersSqls {
	public static final String INSERT_USER ="INSERT INTO USERS (id, email, username, nickname, admin_flag, create_date, modify_date) "
			+ " VALUES(:id, :email, :username, :nickname, :admin_flag, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP) ";
	
	public static final String SELECT_USER_BY_ID=" SELECT id, username, email, tel, nickname, admin_flag, create_date, modify_date "
			+ " FROM USERS WHERE id =:id";
	
	public static final String SELECT_ALL_USERS ="SELECT id, username, email, tel, nickname, admin_flag, create_date, modify_date "
			+ " FROM USERS ";
	
	public static final String UPDATE_USER_BY_ID ="UPDATE nickname "
			+ "SET :nickname "
			+ "FROM USERS "
			+ "WHERE id=:id ";
			
}
