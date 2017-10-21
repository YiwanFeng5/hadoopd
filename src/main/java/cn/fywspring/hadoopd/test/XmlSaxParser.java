package cn.fywspring.hadoopd.test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 定制xml解析器，拿到每个节点的单词
 * @author Yiwan
 *
 */
public class XmlSaxParser extends DefaultHandler{
	//存储读取到的单词
	private String word;
	//记住操作的标签名
	private String tagName;
	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	//只调用一次，可以进行初始化操作
	@Override
	public void startDocument() throws SAXException {
	}
	
	//调用多次，从这开始解析
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		this.tagName = qName;
	}
	
	//调用多次
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		this.tagName = null;//
	}
	
	//调用一次
	@Override
	public void endDocument() throws SAXException {
	}
	
	//调用多次,取标签中的值,如<a>value<a> --> value
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(this.tagName != null){
			String data = new String(ch,start,length);
			if("word".equals(this.tagName)){
				this.word = data;//把值传给word变量，外部方法可以通过get方法获取到
			}
		}
	}
}
