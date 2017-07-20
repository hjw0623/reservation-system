package hwj.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class NaverLoginController {
	private static final String ENCODED_REDIRECT_URI="http%3A%2F%2Flocalhost%3A8080%2Fmy";
	private static final String ClIENT_ID="9y9mVsuHC1uIHfGs3H1E";
	private static final String CLIENT_SECRET="g13SA7Ycw1";	
	private static final String REQUEST_URL="https://nid.naver.com/oauth2.0/authorize?client_id="
											+ClIENT_ID+"&response_type=code&redirect_uri="
											+ENCODED_REDIRECT_URI+"&state=" ;
	
	@RequestMapping(value="/api/Oauth")
	public String naverLogin(HttpSession session){
		String state = Utils.generateState();
		session.setAttribute("state", state);
		return "redirect:"+REQUEST_URL+state;
	}
	
	
	
}	
