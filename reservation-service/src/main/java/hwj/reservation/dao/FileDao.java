package hwj.reservation.dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import hwj.reservation.domain.Category;
import hwj.reservation.domain.FileDTO;

@Repository
public class FileDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	private RowMapper<FileDTO> rowMapper = BeanPropertyRowMapper.newInstance(FileDTO.class);
	//Dao FileDao
	
	public  FileDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction  = new SimpleJdbcInsert(dataSource)
				.withTableName("file")
				.usingGeneratedKeyColumns("id");
	}
	//create
	// SimpleJdbcInsert
	public Integer insert(FileDTO fileDto) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(fileDto);
		int fileId = insertAction.executeAndReturnKey(params).intValue();
		return fileId;
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
	//select All 
	public List<FileDTO> selectAllFileList()  {
		Map<String, Object> params = Collections.emptyMap();
		
		return jdbc.query(FileSqls.SELECT_ALL_FILES, params, rowMapper);
	}
	
	public <List>FileDTO selectFileListById(Integer id){
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(FileSqls.SELECT_FILE_BY_FILE_ID, params, rowMapper);
	}
	
	//SELECT the File  BY File Name
	public FileDTO selectProductListByCategory(String fileName) throws SQLException  {
		Map<String, Object> params = new HashMap<>();
		params.put("file_name", fileName);
		return jdbc.queryForObject(FileSqls.SELECT_FILE_BY_FILE_NAME, params, rowMapper);
	}
	
	public List<Map<String, Object> > selectFileListByCommentId(Integer commentId) {
		Map<String, Object> params = new HashMap<>();
		params.put("reservation_user_comment_id", commentId);
		return jdbc.queryForList(FileSqls.SELECT_FILES_BY_COMMENT_ID, params);
	}

}
