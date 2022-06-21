package model;

/**
 * 
 * Represents text that can appear in an HTML document
 * @author UMCP
 *
 */
public class TextElement implements Element {
	
	private String text;
	
	public TextElement(String text) {
		this.text = text;
	}

	public String genHTML(int indentation) {
		StringBuffer strB = new StringBuffer();
		int i;
		for (i = 0; i < indentation; i++) {
			strB.append(" ");
		}
		strB.append(text);		
		return strB.toString();
	}
	
}
