package hwj.reservation.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hwj.reservation.dao.FileDao;
import hwj.reservation.domain.FileDTO;
@Service
public class FileServiceImpl implements FileService{
	@Autowired
	FileDao fileDao;
	
	public FileServiceImpl(FileDao fileDao){
		this.fileDao = fileDao;
	}
	//insert by jdbc.update
	@Override
	public FileDTO create(FileDTO fileDto) {
		Integer id = fileDao.insertSql(fileDto);
		fileDto.setId(id);
		System.out.println("id: "+id);
		return fileDto;
	}
	
	//insertAction
	@Override
	public FileDTO insert(FileDTO fileDto){
		Integer id = fileDao.insert(fileDto);
		System.out.println("파일 id: "+id);
		fileDto.setId(id);
		return fileDto;
	}

	@Override
	public List<FileDTO> getAllFileList() throws SQLException {		
		return fileDao.selectAllFileList() ;
	}
	//파일 이름으로 찾기 
	@Override
	public FileDTO getFileByFileName(String fileName) throws SQLException {

		return fileDao.selectProductListByCategory(fileName);
	}
	@Override
	public List<Map<String, Object> > getFileListByCommentId(Integer commentId)  {
		//try{
			return fileDao.selectFileListByCommentId(commentId);
	
	}


}
