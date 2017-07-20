package hwj.reservation.controller;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Utils {
	public static String generateState(){
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32); //state
		//session.setAttribute("state", state);
	}
}
