package model;

import java.util.ArrayList;

/**
 * 
 * Represents a paragraph (&lt;p&gt;) tag.  It relies on an
 * ArrayList in order to keep track of the set of Element objects
 * that are part of the paragraph.
 * @author UMCP
 *
 */
public class ParagraphElement extends TagElement {
	
	private ArrayList<Element> items;
	
	public ParagraphElement(String attributes) {
		super("p", true, null, attributes);
		items = new ArrayList<>();
	}
	
	public void addItem​(Element item) {
		items.add(item);
	}
	
	@Override
	public String genHTML(int indentation) {
		StringBuffer strB = new StringBuffer();
		int i;
		StringBuffer spaces = new StringBuffer();
		for (i = 0; i < indentation; i++) {
			spaces.append(" ");
		}
		strB.append(spaces);
		strB.append(getStartTag());
		strB.append(">");
		
		for (i = 0; i < items.size(); i++) {
			strB.append("\n");
			Element element = items.get(i);
			strB.append(element.genHTML(indentation + 3));
		}
		
		strB.append("\n" + spaces + getEndTag());
		return strB.toString();
	}
	
}
