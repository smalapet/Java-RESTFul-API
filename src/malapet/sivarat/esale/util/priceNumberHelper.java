/*
 * Copyrights 2015 Sivarat Malapet all rights reserved.
 */
package malapet.sivarat.esale.util;

import java.math.BigDecimal;
import java.math.BigInteger;
 
/**
* author (JS) Earthchie http://www.earthchie.com/
* modify (Java) Falook http://www.falook.in.th/
* license WTFPL v.2 - http://www.wtfpl.net/
*
* Copyright (c) 2014, Earthchie (earthchie@gmail.com)
*/

public class priceNumberHelper {
	private static final String BATH_SUFFIX = "บาท";
	
	public static BigInteger parseInt(String num){
		return new BigInteger(num);
	}

	public static BigDecimal parseDecimal(String num){
		return new BigDecimal(num);
	}

	public static int charToInt(char a) {
		return Integer.parseInt(a + "");
	}
	
	public static String bahtThai(String number) {
		return bahtThai(number, "");
	}
	
	public static String bahtThai(String number,String suffix) {
		return bahtThai(number, suffix,true);
	}
	
	public static String bahtThai(String number,boolean forceZero) {
		return bahtThai(number, "",forceZero);
	}
	
	public static String bahtThai(String num, String suffix,boolean forceZero) {
		String t[] = {"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน", "ล้าน"};
		String n[] = {"", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด",
		"เก้า"};
		String text = "";
		num = num.replace(",", "");
		suffix = suffix.equals("") ?BATH_SUFFIX:suffix;
		if(parseDecimal(num).toString().equals("0") && forceZero)
			return correctSpelling("ศูนย์"+BATH_SUFFIX);
		
		if (num.contains(".")) {
			String parts[] = num.split("\\.");
			parts[1] = (parseDecimal("0."+parts[1]).setScale(2, BigDecimal.ROUND_HALF_UP))
			.toString().split("\\.")[1];
			if (forceZero)
				return correctSpelling(bahtThai(parts[0],"") + bahtThai(parts[1], "สตางค์"));
		else
			return correctSpelling(bahtThai(parts[1], "สตางค์"));
		}
		
		if (num.length() > 7)
			return correctSpelling(bahtThai(num.substring(0, num.length() - 6), "ล้าน",false).replace(BATH_SUFFIX,"ล้าน")
					+ bahtThai(num.substring(num.length() - 6, num.length()),"",false));
		else
			for (int i = 0; i < num.length(); i++)
			if (Integer.parseInt(num.charAt(i) + "") != 0)
			if (num.length() > 2 && i == num.length() - 1
			&& charToInt(num.charAt(i)) == 1
			&& !suffix.equals("สตางค์"))
			text += "เอ็ด" + t[num.length() - 1 - i];
		else
			text += n[charToInt(num.charAt(i))] +
			t[num.length() - 1 - i];
			text = text.replace("หนึ่งสิบ", "สิบ");
			text = text.replace("สองสิบ", "ยี่สิบ");
			text = text.replace("สิบหนึ่ง", "สิบเอ็ด");
			return correctSpelling(text + suffix);
	}
	
	private static String correctSpelling(String data){
		String res = data;
		int lenx = "ศูนย์บาท".length();
		if(res.length() > lenx){
			int idx = res.indexOf("ศูนย์บาท");
			//System.out.println("res = "+res+" lenx = "+lenx+" res.length() = "+res.length()+" idx = "+idx);
			if(idx > 0){
				res = res.replaceAll("ศูนย์บาท", "ถ้วน");
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.printf("%-25s %s\n" ,"0", bahtThai("0"));
		System.out.printf("%-25s %s\n" ,"0.25", bahtThai("0.25"));
		System.out.printf("%-25s %s\n" ,"0.256", bahtThai("0.256"));
		System.out.printf("%-25s %s\n" ,"0.2514", bahtThai("0.2514"));
		System.out.printf("%-25s %s\n" ,"12,000.50", bahtThai("12,000.50"));
		System.out.printf("%-25s %s\n" ,"1,200,000.50", bahtThai("1,200,000.50"));
		System.out.printf("%-25s %s\n" ,"12,100,000,000,000.50", bahtThai("12,100,000,000,000.50"));
		System.out.printf("%-25s %s\n" ,"12,100,000.50", bahtThai("12,100,000.50"));
		System.out.printf("%-25s %s\n" ,"000,000,000,000.25", bahtThai("000,000,000,000.25"));
		System.out.printf("%-25s %s\n" ,"0.25 [forceZero = false]", bahtThai("0.25",false));
		System.out.printf("%-25s %s\n" ,"0.256 [forceZero = false]", bahtThai("0.256",false));
	}
	
} 