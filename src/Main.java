import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String scr="1234<img style=WIDTH: 510px; HEIGHT: 324px src=/tcmV4/1/ewebeditor/uploadfile/2014/3/18/20140318093924408.jpg width=510 height=342>5678<IMG src=/tcmV4/1/ewebeditor/uploadfile/2014/3/18/20140318093932525.jpg>0000";
		
		//getElementText("dqd",scr,0);
		System.out.println(filterImage(scr));
	}

	public static String getElementText(String tag, String srcXml, int flag) {

		if (srcXml == null || srcXml.equals("")) {
			return "";
		}

		if (tag == null || tag.equals("")) {
			return "";
		}

		//System.out.println(srcXml);
		tag = tag.trim();
		String returnStr = "";
		try {

			Pattern pattern = Pattern.compile("<IMG (.*?)>");
			Matcher matcher = pattern.matcher(srcXml);
			while (matcher.find()) {
				returnStr = matcher.group(flag);
				System.out.println(returnStr);
				;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return returnStr;
	}
	
	public static String filterImage(String src){
		if (src == null || src.equals("")) {
			return "";
		}
		//System.out.println(srcXml);
		src=src.replace("img", "IMG");
		String returnStr = src;
		
		//大写
		try {
			Pattern pattern = Pattern.compile("<IMG (.*?)>");
			Matcher matcher = pattern.matcher(src);
			while (matcher.find()) {
				String	matchStr = matcher.group(0);
				returnStr=returnStr.replace(matchStr, "");
				System.out.println(matchStr);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return returnStr;
	}
}

