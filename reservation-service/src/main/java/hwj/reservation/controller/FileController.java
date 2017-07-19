package hwj.reservation.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hwj.reservation.domain.FileDTO;
import hwj.reservation.domain.ProductDTO;
import hwj.reservation.domain.ProductImageDTO;
import hwj.reservation.domain.ResUserCommentImageDTO;
import hwj.reservation.service.CategoryService;
import hwj.reservation.service.FileService;
import hwj.reservation.service.ProductImageService;
import hwj.reservation.service.ResUserCommentService;

@Controller
@RequestMapping("/files")
public class FileController {
	// img path : /Users/hw/Boostcamp/reservation-system/resources/productimg 
    private String baseDir =  File.separator + "Users" + File.separator 
    							+ "hw" + File.separator+"Boostcamp"+File.separator+"reservation-system"
    							+ File.separator+"resources"+File.separator+"productimg"+File.separator;
    @Autowired
	FileService fileService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    ResUserCommentService resUserCommentService;
    
	private final Logger log = LoggerFactory.getLogger(CategoryMainController.class);
	
    @PostMapping
    @RequestMapping(method = RequestMethod.POST)	
    public String create( 
    		@RequestParam(value="product-List") Integer productId, 
            @RequestParam("file") MultipartFile[] files){
    	
    	if(files !=null && files.length>0){
            String formattedDate = baseDir + new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd").format(new Date());
    		File f = new File(formattedDate);
    		if(!f.exists()){ // 파일이 존재하지 않는다면
                f.mkdirs(); // 해당 디렉토리를 하위폴더까지 한꺼번에 만든다.
            }
    		int idx=0;
	    	for(MultipartFile file : files){
	    		System.out.println("productId:" +productId);
	    		String contentType = file.getContentType();
	    		String name = file.getName();
	    		String originalFilename = file.getOriginalFilename();
	    		long fileLength = file.getSize();
	    		String uuid = UUID.randomUUID().toString();
	            String saveFileName = formattedDate + File.separator + uuid; // 실제 저장되는 파일의 절대 경로
	            
                // pk 값은 자동으로 생성되도록
	            
	            System.out.println("contentType :" + contentType);
                System.out.println("name :" + name);
                System.out.println("originalFilename : " + originalFilename);
                System.out.println("fileLength : " + fileLength);
                System.out.println("saveFileName : " + saveFileName);
             
                //deleteFlag = 0 ; 삭제 안함.
        		//File Table에 추가 
        		Timestamp timestamp = new Timestamp(new Date().getTime());
        		int userId = 7;
                FileDTO fDto = new FileDTO(userId, originalFilename, saveFileName, fileLength,contentType, 0, timestamp, timestamp  );     
                FileDTO insertedFileDto = fileService.insert(fDto); //better for use
                int fileId = insertedFileDto.getId();
                
                //개인예약자의 댓글 사진 등록 
                int commentId = 2;
                ResUserCommentImageDTO resUserCommentImgDTO = new ResUserCommentImageDTO(commentId, fileId);
                ResUserCommentImageDTO resCommentImg ;
                try {
					resCommentImg=resUserCommentService.insert(resUserCommentImgDTO);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
                
                
                /*
                기업의 공연 이미지 등록 
                ProductImageDTO pIDto = null;
                if(idx==0){ //메인 이미지 
                	pIDto = new ProductImageDTO(productId, insertedFileDto.getId(),0);
                }else{// 서브이미지 
                	pIDto = new ProductImageDTO(productId, insertedFileDto.getId(), 1);
                }
                productImageService.insert(pIDto);
                */
                // 실제 파일 저장
                try(
	            		InputStream in = file.getInputStream();
	                    FileOutputStream fos = new FileOutputStream(saveFileName) ){
                	int readCount =0;
                	byte[] buffer = new byte[512];
                	
                    while((readCount = in.read(buffer)) != -1){
                        fos.write(buffer,0,readCount);
                    }
                		
                }catch(Exception e){
                	e.printStackTrace();
                }
                idx++; //index 증가 
	    	}//end for
    	}//end if
    	
		return "redirect:/file";
    	
    }
}
