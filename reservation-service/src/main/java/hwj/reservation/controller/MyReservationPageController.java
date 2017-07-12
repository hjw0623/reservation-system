package hwj.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MyReservationPageController {
	@GetMapping
	public String pageLoad( Model model){
		 return "/mypage";
	}	
}
