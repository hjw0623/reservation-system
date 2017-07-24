package hwj.reservation.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import hwj.reservation.domain.Category;
import hwj.reservation.domain.DisplayInfoDTO;
import hwj.reservation.domain.FileDTO;
import hwj.reservation.domain.ProductDTO;
import hwj.reservation.domain.ProductImageDTO;
import hwj.reservation.domain.ProductPriceDTO;
import hwj.reservation.domain.ReservationInfoDTO;
import hwj.reservation.domain.Users;
import hwj.reservation.service.LoginUsersService;
import hwj.reservation.service.ProductImageService;
import hwj.reservation.service.ProductPriceService;
import hwj.reservation.service.ProductService;
import hwj.reservation.service.ReservationService;

@Controller
@RequestMapping({"/booking/bizes/{id}/item/{detailId}", "/booking/bizes/{id}/item/{detailId}#"})
public class ReservationPageController {
	@Autowired
	ProductService productService;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	ProductPriceService productPriceService;
	@Autowired
	LoginUsersService loginUsersService;
	@Autowired
	ReservationService reservationService;

	private final Logger log = LoggerFactory.getLogger(ReservationPageController.class);

	@GetMapping
	public String loadReservePage(@PathVariable Integer id, @PathVariable Integer detailId, HttpSession session){
		//로그인되어있다면 사용자 정보를 호출. 아니면 OAut로그 페이지 redirect
		
			if(session.getAttribute("LoginOk")==null || !session.getAttribute("LoginOk").equals("logIn") ){
				System.out.println("로그인이 필요합니다.");
				return "redirect:/login/api/Oauth";
			}
			else{
				return "/reserve";				
			}
	}

	@GetMapping("/pId")
	public @ResponseBody Integer getProductId(@PathVariable(value="id") Integer id){
		return id;
	}
	@GetMapping("/dId")
	public @ResponseBody Integer getDetailId(@PathVariable(value="detailId") Integer detailId){
		return detailId;
	}
	@GetMapping("/images")
	public @ResponseBody List<FileDTO> loadProductImages(@PathVariable(value="id")Integer id){
		List<FileDTO> imageList = null;
		 try {
			imageList = productImageService.getProductImagesByProductId(id);
			return imageList;
		} catch (SQLException e) {
			e.printStackTrace();
			return imageList = new ArrayList<FileDTO>(); 
		}		
	}
	@GetMapping("/displayinfo")
	public @ResponseBody   DisplayInfoDTO loadDisplayInfo(@PathVariable(value="id") Integer id){
		DisplayInfoDTO displayInfo;
		try {
			displayInfo = productService.getDisplayInfoById(id);
			return displayInfo;
		} catch (SQLException e) {
			System.out.println("load display info fail");
			return displayInfo= null;
		}
	}
	
	
	@GetMapping("/priceinfo")
	public @ResponseBody  List<ProductPriceDTO> loadPriceInfo(@PathVariable(value="id") Integer id){
		List<ProductPriceDTO> priceList;
		try {
			priceList = productPriceService.getProductPriceByProductId(id);
			return priceList ;
		} catch (SQLException e) { //size 0 list return
			return priceList= new ArrayList<ProductPriceDTO>() ;
		}
	}
	
	@GetMapping("/userinfo")
	public @ResponseBody  Users loadUserInfo(HttpSession session){
		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println("userId: "+userId);

		Users customer;
		try {
			customer = loginUsersService.getSimpleInfoById(userId);
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/productinfo")
	public @ResponseBody ProductDTO loadProductInfo(@PathVariable(value="id") Integer id){
		log.info("id:"+id);
		ProductDTO product;
		try {
			product = productService.getById(id);
			return product;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/reservation")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ReservationInfoDTO create(@RequestBody ReservationInfoDTO reserve, @PathVariable(value="id") Integer productId, HttpSession session ){
		//유효성 체크 
		log.info("insert try");
		
		reserve.setProductId(12);
		System.out.println((int)session.getAttribute("userId"));
		reserve.setUserId((int)session.getAttribute("userId"));
		Timestamp timestamp = new Timestamp(new Date().getTime());
		
		reserve.setCreateDate(timestamp);
		reserve.setModifyDate(timestamp);
		ReservationInfoDTO reservation;
		try {
			log.info("insert 시도 ");
			reservation = reservationService.insert(reserve );
			log.info("reservation success");
			return reservation;//"redirect:/my";
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("reservation insert failed");
			return null;//"redirect:/";
		}
	}
}
