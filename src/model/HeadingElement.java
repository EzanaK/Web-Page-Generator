package model;

/**
 * Represents a heading.  We can have levels 1 thru 6 (e.g., &lt;h1&gt;, &lt;h2&gt;, etc.)
 * @author UMCP
 *
 */
public class HeadingElement extends TagElement {
	
	public HeadingElement(Element content, int level, String attributes) {
		super(getHeadingElementTagName(level), true, content, attributes);
	}
	
	private static String getHeadingElementTagName(int level) {
		if (level < 1 || level > 6) {
			return "h1";
		} else {
			return "h" + level;
		}
	}
	
}
