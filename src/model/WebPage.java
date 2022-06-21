package model;

import java.util.*;

/**
 * Represents a web page.  Web page elements are
 * stored in an ArrayList of Element objects.  A title
 * is associated with every page.  This class implements
 * the Comparable interface.  Pages will be compared
 * based on the title.
 * @author UMCP
 *
 */
public class WebPage implements Comparable<WebPage> {
	
	private ArrayList<Element> elements;
	private String title;
	private static int listCount;
	private static int paragraphCount;
	private static int tableCount;

	public WebPage(String title) {
		this.title = title;
		elements = new ArrayList<>();
		listCount = 0;
		paragraphCount = 0;
		tableCount = 0;
	}
	
	public int addElement​(Element element) {
		elements.add(element);
		if (element instanceof ListElement) {
			listCount++;
		} else if (element instanceof ParagraphElement) {
			paragraphCount++;
		} else if (element instanceof TableElement) {
			tableCount++;
		}
		if (element instanceof TagElement) {
			TagElement tagElement = (TagElement)element;
			return tagElement.getId();
		} else {
			return -1;
		}
	}
	
	public String getWebPageHTML(int indentation) {
		StringBuffer strB = new StringBuffer();
		strB.append("<!doctype html>\n" + "<html>\n");
		int i;
		StringBuffer spaces = new StringBuffer();
		for (i = 0; i < indentation; i++) {
			spaces.append(" ");
		}
		strB.append(spaces);
		strB.append("<head>\n");
		strB.append(spaces + "   <meta charset=\"utf-8\"/>\n");
		strB.append(spaces + "   <title>" + title + "</title>\n");
		strB.append(spaces + "</head>\n" + spaces + "<body>");
		for (i = 0; i < elements.size(); i++) {
			strB.append("\n");
			Element element = elements.get(i);
			strB.append(element.genHTML(indentation));
		}
		
		
		strB.append("\n" + spaces + "</body>\n</html>");
		return strB.toString();
	}
	
	public void writeToFile​(String filename, int indentation) {
		String data = getWebPageHTML(indentation);
		Utilities.writeToFile(filename, data);
	}
	
	public Element findElem​(int id) {
		int i;
		for (i = 0; i < elements.size(); i++) {
			if (elements.get(i) instanceof TagElement) {
				TagElement tagElement = (TagElement)elements.get(i);
				if (tagElement.getId() == id) {
					return elements.get(i);
				}
			}
		}
		return null;
	}
	
	public String stats() {
		StringBuffer strB = new StringBuffer();
		strB.append("List Count: " + listCount + "\nParagraph Count: " + paragraphCount);
		strB.append("\nTable Count: " + tableCount + "\nTableElement Utilization: " + TableElement.getTableUtilization());
		return strB.toString();
 	}
	
	@Override
	public int compareTo(WebPage webPage) {
		return this.title.compareTo(webPage.title);
	}
	
	public static void enableId​(boolean choice) {
		TagElement.enableId(choice);
	}
	
}
