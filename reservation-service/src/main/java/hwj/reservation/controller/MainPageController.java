package hwj.reservation.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hwj.reservation.domain.Category;
import hwj.reservation.domain.Product;
import hwj.reservation.service.CategoryService;
import hwj.reservation.service.ProductService;

@Controller
@RequestMapping("/")
public class MainPageController {
	 @Autowired
	 CategoryService categoryService;
	 @Autowired
	 ProductService productService;
	 private final Logger log = LoggerFactory.getLogger(CategoryMainController.class);
	
	@GetMapping
	public String pageLoad( Model model){
		 return "/mainPage";
	}	
	 //카테고리 전부 조회 
	@GetMapping("/home") 
	public @ResponseBody List<Category> categoryList() throws SQLException{
		List<Category> cList = categoryService.getAllList();
		if(cList ==null){
			System.out.println("empty");
			log.info("empty List");
		}else{
			
			log.info("cList");
		}
		return cList;
	}	
	
	
}
