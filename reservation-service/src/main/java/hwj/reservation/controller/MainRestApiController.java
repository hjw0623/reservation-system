package hwj.reservation.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hwj.reservation.domain.Category;
import hwj.reservation.domain.Product;
import hwj.reservation.service.CategoryService;
import hwj.reservation.service.ProductService;

@Controller
@RequestMapping("/bottom")
public class MainRestApiController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	private final Logger log = LoggerFactory.getLogger(CategoryMainController.class);

	// 세부 목록 카테고리 별 조회 
	@GetMapping("/category")//("/product/{categoryId}")
	public @ResponseBody List<Product> productCategoryList(@RequestParam(value="categoryId", required=true) Integer categoryId, 
															@RequestParam(value="num", required=true) Integer num) {
		List<Product> pList;
		try {
			pList = productService.getListByCategory(categoryId, num);
			return pList;
		} catch (SQLException e) {
			return null;
		}
	}
	//카테고리 id를 받아서 count 쿼리 
	@GetMapping//("/{id}")
	public  @ResponseBody Integer countCategoryList(@RequestParam Integer categoryId  ) throws SQLException{
		Integer count = productService.getCountCategroyNumber(categoryId);
		return count;
	}
}
