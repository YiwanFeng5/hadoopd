package cn.fywspring.hadoopd.wc_xml;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
/**
 * 处理xml，从标签中获得指定的字段
 * @author Yiwan
 *
 */
public class MyXMLReader {
	public static void main(String[] args) {
		System.out.println(getValue("<words><word>hello</word></words>"));
	}
	
	/**
	 * 接收一个字符串
	 * @param str 接收的字符串
	 * @return 返回从xml标签中提取出来的字段
	 */
	public static String getValue(String str){
		SAXParser parser = null;
		try {
			//新建一个SAX解析器对象，该对象的特点就是一行一行的读xml文件
			parser = SAXParserFactory.newInstance().newSAXParser();
			//新建一个自定义的xml处理类实例
			XmlSaxParser xml = new XmlSaxParser();
			//parse方法的第一个参数接收一个InputStream类型的参数，第二个参数是上面定义的xml处理类实例
			parser.parse(new ByteArrayInputStream(str.getBytes()), xml);
			//通过访问器获得字段并返回
			return xml.getWord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
