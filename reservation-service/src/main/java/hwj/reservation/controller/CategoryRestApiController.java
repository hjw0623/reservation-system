package hwj.reservation.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import hwj.reservation.domain.Category;
import hwj.reservation.dto.CategoryFormParam;
import hwj.reservation.service.CategoryService;
import hwj.reservation.service.CategoryServiceImpl;

@Controller
@RequestMapping({"/category/api"})
public class CategoryRestApiController {
	@Autowired
	CategoryService categoryService;
	 private final Logger log = LoggerFactory.getLogger(CategoryRestApiController.class);

	@PostMapping
	public String create(@ModelAttribute Category category){
		//유효성 체크 
		if(category.getName()==null|| category.getName().length()==0){
			return "redirect:/category";
		}else{
				
			Category resultCategory = categoryService.create(category);
			if(resultCategory==null){
				log.info("null...");
			}
			return "redirect:/category";
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String delete(@PathVariable Integer id) throws SQLException{
		Category check = categoryService.getById(id);
		//check validation
		if(check!=null){
			categoryService.deleteById(id);
		}
		return "redirect:/category";
	}
	
	//update
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void update(@PathVariable Integer id, @RequestBody Category category) throws SQLException{
		//check validation
		Category check =  categoryService.getById(category.getId());
		if(check!=null){
			categoryService.update(category);
			log.info("category updated");
		}
	}
}
