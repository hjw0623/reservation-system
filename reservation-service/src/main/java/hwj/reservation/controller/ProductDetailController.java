package hwj.reservation.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hwj.reservation.service.FileService;
import hwj.reservation.service.ProductImageService;
import hwj.reservation.service.ProductService;
import hwj.reservation.service.ResUserCommentService;
import hwj.reservation.domain.DisplayInfoDTO;
import hwj.reservation.domain.FileDTO;
import hwj.reservation.domain.ProductDTO;
import hwj.reservation.domain.ProductDetailDTO;
import hwj.reservation.domain.ProductImageDTO;
import hwj.reservation.domain.ResUserCommentDTO;
import hwj.reservation.domain.ResUserCommentImageDTO;
import hwj.reservation.domain.ResUserCommentWitImageDTO;
@Controller
@RequestMapping("/booking/bizes")
public class ProductDetailController {
	@Autowired
	ProductService productService;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	ResUserCommentService resUserCommentService;
	@Autowired
	FileService fileService;
	
	private final Logger log = LoggerFactory.getLogger(ProductDetailController.class);

	@GetMapping("/{id}")
	public String loadDetailPage( @PathVariable Integer id){
		
		return "/detail";
	}	
	
	@GetMapping("/image{id}")
	public @ResponseBody List<FileDTO> loadProductImages( @RequestParam Integer id){
		List<FileDTO> imageList ;
		try{
			imageList = productImageService.getProductImagesByProductId(id);
		}catch(SQLException e){
			return null;
		}
		return imageList;
	}
	
	
	@GetMapping("/info{id}")
	public @ResponseBody ProductDTO loadProductDetailInfo(@RequestParam Integer id){
		ProductDTO pDto = null;
		try {
			return pDto = productService.getById(id);
		} catch (SQLException e) {
			return pDto;
		}
	}
	@GetMapping("/display{id}")
	public @ResponseBody DisplayInfoDTO loadDisplayInfoById(@RequestParam Integer id){
		DisplayInfoDTO displayInfo= null;
		try{
			return displayInfo = productService.getDisplayInfoById(id);
		}catch(SQLException e){
			return displayInfo;
		}
	}
	
	@GetMapping("/pdetail{id}")
	public @ResponseBody ProductDetailDTO loadProductDetailById(@RequestParam Integer id){
		ProductDetailDTO productDetail = null;
		try{
			return productDetail = productService.getProductDetailById(id);
		}catch(SQLException e){
			return productDetail;
		}
	}
	
	@GetMapping("/count{id}")
	public @ResponseBody Integer countProductImages(@RequestParam Integer id){
		int count = 0;
		try{
			return count = productImageService.getCountProductImages(id);
		}catch(SQLException e){
			return count;
		}
	}
	@GetMapping("/comment{id}")
	public @ResponseBody List<ResUserCommentWitImageDTO> loadCommentThreeById(@RequestParam Integer id){
		List<ResUserCommentWitImageDTO> commentList = null;
		try{
			commentList = resUserCommentService.getThreeUserCommentWithImages(id);
			//file처리하러 내려보낸다..
			for( ResUserCommentWitImageDTO dto : commentList){				
				List<Map<String, Object> > fList = fileService.getFileListByCommentId(dto.getId());
				dto.setImgList(fList);
			}
			return commentList;
		}catch(SQLException e){
			return commentList; //null
		}
	}
	@GetMapping("/commentnum{id}")
	public @ResponseBody Integer getCountCommentById(@RequestParam Integer id){
		int commentnum =0;
		try{
			return commentnum = resUserCommentService.getCountTotalCommentById(id);
		}catch(SQLException e){
			commentnum=0;
			return commentnum;
		}	
	}
	
	@GetMapping("/avgscore{id}")
	public @ResponseBody Double getAverageScoreById(@RequestParam Integer id){
		Double avg =null;
		try{
			avg = resUserCommentService.getAvgScoreCommentById(id);
			if(avg !=null){
				return avg;
			}else{
				return 0.0;
			}
		}catch(SQLException e){
			avg=0.0;
			return avg;
		}	
	}

	//review.jsp
	@GetMapping("/reviewMore/{id}")
	public String loadReviewPage( @PathVariable Integer id){
		return "/review";
	}	
	@GetMapping("/reviewMore/reviews{id}")
	public  @ResponseBody  List<ResUserCommentWitImageDTO> loadReviews(@RequestParam Integer id){
		List<ResUserCommentWitImageDTO> commentList = null;
		try{
			commentList = resUserCommentService.getAllUserCommentWithImages(id);
			//file처리하러 내려보낸다..
			for( ResUserCommentWitImageDTO dto : commentList){
				List<Map<String, Object> > fList = fileService.getFileListByCommentId(dto.getId());
				dto.setImgList(fList);
			}
			return commentList;
		}catch(SQLException e){
			return commentList; //null
		}
	}
}
