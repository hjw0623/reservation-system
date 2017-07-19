package hwj.reservation.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import hwj.reservation.domain.FileDTO;

public interface FileService {
	public FileDTO create(FileDTO fileDto);
	public FileDTO insert(FileDTO fileDto); //2nd way
	public List<FileDTO> getAllFileList() throws SQLException;
	public FileDTO getFileByFileName(String fileName) throws SQLException;
	
	//use in ProductDetailController
	public  List<Map<String, Object> > getFileListByCommentId(Integer commentId) ;
}
