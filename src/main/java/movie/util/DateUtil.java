package movie.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	//문자가 들어오면 util의 데이터로 변경해서 보낸다.
	public static Date getUtilDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date result = null;
		try {
			result = sdf.parse(d); //result에 담아서 return
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//sql의 데이터로 변경
	public static java.sql.Date getSQLDate(String d) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //형태작성주의
		
		java.sql.Date result = null;
		try {
			Date d2 = sdf.parse(d);
			result = new java.sql.Date(d2.getTime()); //?
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
