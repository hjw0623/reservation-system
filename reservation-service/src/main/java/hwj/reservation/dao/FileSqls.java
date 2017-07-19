package hwj.reservation.dao;

public class FileSqls {
		//COUNT All
		static final String COUNT_ALL_FILES="SELECT COUNT(*) FROM FILE ";
		//COUNT BY Category
		static final String COUNT_FILE_BY_PRODUCT="SELECT COUNT(*) FROM FILE WHERE product_id=:product_id ";
		
		//Select All List by limit num
		static final String SELECT_ALL_FILES= 
				"SELECT id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date "
				+ "FROM FILE";
		static final String CREATE_FILE=
				"INSERT INTO FILE ( user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)"
				+ "VALUES(1, :file_name, :save_file_name, :file_length, :content_type, :delete_flag, "
				+ "CURRENT_TIMESTAMP, CURRENT_TIMESTAMP )";
		//SELECT ALL List 
		static final String SELECT_FILE_BY_FILE_NAME= 
				"SELECT id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date "
				+"FROM PRODUCT where file_name=:file_name";
		
		static final String SELECT_FILE_BY_FILE_ID= 
				"SELECT id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date "
				+"FROM PRODUCT where file_name=:id";
		
		static final String SELECT_FILES_BY_COMMENT_ID =
				"SELECT  B.id, B.user_id, B.file_name, B.save_file_name, "
				+" B.file_length, B.content_type, B.delete_flag, B.create_date, B.modify_date "
				+" FROM  RESERVATION_USER_COMMENT_IMAGE as A, FILE as B "
				+" WHERE A.file_id = B.id AND A.reservation_user_comment_id = :reservation_user_comment_id";
		
	
		
}
