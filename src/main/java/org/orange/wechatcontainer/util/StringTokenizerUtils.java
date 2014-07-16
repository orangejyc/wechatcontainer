package org.orange.wechatcontainer.util;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringTokenizerUtils {

    /**
     * 
     * for example：StringTokenizerUtils.split("1,2;3 4"," ,;");
     * return: ["1","2","3","4"]
     * 
     * @param str
     * @param seperators
     * @return
     */
	@SuppressWarnings("all")
	public static String[] split(String str,String seperators) {
		StringTokenizer tokenlizer = new StringTokenizer(str,seperators);
		List result = new ArrayList();
		
		while(tokenlizer.hasMoreElements()) {
			Object s = tokenlizer.nextElement();
			result.add(s);
		}
		return (String[])result.toArray(new String[result.size()]);
	}
	
}
