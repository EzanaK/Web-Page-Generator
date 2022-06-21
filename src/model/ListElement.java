package model;

import java.util.ArrayList;

/**
 * Represents the &lt;ul&gt and the &lt;ol&gt; tags.
 * An ArrayList is used to keep track of the Element objects of the list.
 * @author UMCP
 *
 */
public class ListElement extends TagElement {
	
	private ArrayList<Element> items;
	
	public ListElement(boolean ordered, String attributes) {
		super(getListTagName(ordered), true, null, attributes);
		items = new ArrayList<>();
	}
	
	private static String getListTagName(boolean ordered) {
		if(ordered) {
			return "ol";
		} else {
			return "ul";
		}
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
			strB.append("\n" + spaces + "   <li>\n");
			Element element = items.get(i);
			strB.append(element.genHTML(indentation + 6));
			strB.append("\n" + spaces + "   </li>");
		}
		
		strB.append("\n" + spaces + getEndTag());
		return strB.toString();
	}


}
