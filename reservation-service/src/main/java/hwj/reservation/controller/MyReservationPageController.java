package hwj.reservation.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import hwj.reservation.controller.LoginUtils;
import hwj.reservation.domain.NaverLoginUser;
import hwj.reservation.domain.NaverLoginUserResult;
import hwj.reservation.domain.Users;
import hwj.reservation.service.LoginUsersService;

@Controller
@RequestMapping("/my")
public class MyReservationPageController {
	private static final String RESPONSE_UNAUTHORIZED="redirect:/";
	private static final String RESPONSE_SUCCESS ="/myreservation";
	private static final String ClIENT_ID="9y9mVsuHC1uIHfGs3H1E";
	private static final String CLIENT_SECRET="g13SA7Ycw1";	
	//https://nid.naver.com/oauth2.0/token?client_id={클라이언트 아이디}&client_secret={클라이언트 시크릿}&grant_type=authorization_code&state={상태 토큰}&code={인증 코드}
	private static final String getAccessTokenUrl = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id="+ClIENT_ID+"&client_secret="+CLIENT_SECRET;

	@Autowired
	LoginUsersService loginUserService;
	
	@RequestMapping
	public String callback(@RequestParam String state, @RequestParam String code, HttpServletRequest request) throws UnsupportedEncodingException{
		HttpSession session = request.getSession();
		//상태 코드 검증 단계 
		String storedState = (String) session.getAttribute("state");
		System.out.println("storedState:" +storedState);
		
		if(!state.equals(storedState) && request.getAttribute("LoginOk")==null){
			System.out.println("401 unauthorized");
			return RESPONSE_UNAUTHORIZED; //401
		}
		
		System.out.println("success");
		System.out.println("code: "+code);
		
		if(request.getAttribute("LoginOk")==null){			
			String tokenUrl = getAccessTokenUrl+"&code="+code+"&state="+state;
			String url = LoginUtils.getAccessToken(tokenUrl); //필수!!
			Map<String, Object> map = LoginUtils.JSONStringToMap(url);
			String accessToken = (String) map.get("access_token");
			String refreshToken = (String) map.get("refresh_token");
			String tokenType = (String) map.get("token_type");
			String expiresIn = (String)  map.get("expires_in");
			
			NaverLoginUser response = loginUserService.getProfile(accessToken);
			System.out.println(response.getName());	

			session = request.getSession();
			session.setAttribute("LoginOk", "logIn");
			session.setAttribute("userId", response.getId());

			System.out.println("login id : "+response.getId());
			try { //DB user정보 갱신 혹은 추가. 
				Users user = loginUserService.getById(response.getId());
				if(user==null){ //DB에 없는 유저면 생성
					System.out.println("=====user create===");
					loginUserService.create(response);
				}else{
					System.out.println("=====user found===");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("로그인 실패 ");
				return "redirect:/";
			}
			return "redirect:/myreservation" ;
		}else{
			return  "redirect:/login/api/Oauth" ;

		}
	}	
}
