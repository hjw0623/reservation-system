package hwj.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("")
public class RedirectController {
	@GetMapping("/myreservation")
	public String loadDetailPage( HttpSession session){
		if(session.getAttribute("LoginOk")==null){
			return "redirect:/login/api/Oauth";
		}else{
			 return "/myreservation";
		}
	}	
	
	@GetMapping("/detaildefault")
	public String loadPromotionDetailPage( Model model){
		 return "/detaildefault";
	}	
	
	//@GetMapping("/booking/bizes/{id}/item/{detailId}")
	
	
}
