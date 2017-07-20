package hwj.reservation.controller;

import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class LoginUtils {
	//1.난수 state 생
	public static String generateState(){
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32); //state

	}
	public static Map<String, Object> JSONStringToMap(String str){
		Map<String, Object> map = new HashMap<String, Object>();
		//json parsing to map using jackson 
		ObjectMapper mapper = new ObjectMapper();
		
		try{
			map = mapper.readValue(str, new TypeReference<HashMap<String, String>>(){});
		}catch(JsonParseException e){
			e.printStackTrace();
		}catch(JsonMappingException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return map;
	}
	//token JSON String 받아오기 
	public static String getAccessToken(String tokenUrl){
		String result="";
	
		 try {
	            URL url = new URL(tokenUrl);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	           
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	            result = response.toString();

	        } catch (Exception e) {
	            System.out.println(e);
	        }	
		return result;
	}
	//java unicode to korean
	private static String unicodeConvert(String str) {
	    StringBuilder sb = new StringBuilder();
	    char ch;
	    int len = str.length();
	    for (int i = 0; i < len; i++) {
	        ch = str.charAt(i);
	        if (ch == '\\' && str.charAt(i+1) == 'u') {
	            sb.append((char) Integer.parseInt(str.substring(i+2, i+6), 16));
	            i+=5;
	            continue;
	        }
	        sb.append(ch);
	    }
	    return sb.toString();
	}


	public static String getProfile(String accessToken){
		String profile="";
		String header="Bearer "+accessToken;
		 try {
	            String apiURL = "https://openapi.naver.com/v1/nid/me";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	           
	            con.setRequestProperty("Authorization", header);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {

	            	String info= unicodeConvert(inputLine);
	               response.append(info);
	            }
	            br.close();
	           // System.out.println(response.toString());
	           profile = response.toString();

	        } catch (Exception e) {
	            System.out.println(e);
	        }	
		return profile;
	}
}
