package hwj.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detail")
public class ProductDetailController {
	@GetMapping
	public String detailPageLoad( Model model){
		 return "/detail";
	}	
}
