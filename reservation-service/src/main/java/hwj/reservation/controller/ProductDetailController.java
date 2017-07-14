package hwj.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking/bizes")
public class ProductDetailController {
	@GetMapping("/{id}")
	public String loadDetailPage( @PathVariable Integer id){
		// return "/detail";
		return "/detail";
	}	
}
