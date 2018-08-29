package String;

import java.sql.Date;
import java.util.Scanner;

public class OnlineShopHelper {
	public static String ChangeDateFormate(String date) {
		String s1 ="";
		String s2 ="";
		String s3 ="";
		int firstindex=date.indexOf('/');
		int secondindex= date.indexOf('/', (firstindex+1));
		for(int i=0;i<firstindex;i++) {
			s1=s1+date.charAt(i);
		}
	 	for(int i=firstindex+1;i<secondindex;i++) {
			s2=s2+date.charAt(i);
		}
	 	for(int i=secondindex+1;i<date.length();i++) {
			s3=s3+date.charAt(i);
		}
	 	return s3+"-"+s2+"-"+s1;
	}
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter Date...");
		String s= scanner.next();
		System.out.println(ChangeDateFormate(s));
		Date date = Date.valueOf(ChangeDateFormate(s));
		System.out.println(date);
		scanner.close();
	}
}
