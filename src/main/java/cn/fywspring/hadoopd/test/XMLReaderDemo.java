package cn.fywspring.hadoopd.test;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLReaderDemo {
	public static void main(String[] args) {
		System.out.println(getValue("<words><word>hello</word></words>"));
	}
	
	public static String getValue(String str){
		SAXParser parser = null;
		try {
			parser = SAXParserFactory.newInstance().newSAXParser();
			XmlSaxParser xml = new XmlSaxParser();
			parser.parse(new ByteArrayInputStream(str.getBytes()), xml);
			return xml.getWord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
