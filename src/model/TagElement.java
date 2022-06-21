package model;

/**
 * 
 * Represents an HTML tag element (<&lt;p&gt;, &lt;ul&gt;, etc.).
 * Each tag has an id (ids start at 1).  By default the start tag
 * will have an id (e.g., <&lt;p id="a1"&gt;&lt;/p&gt;) when
 * the HTML for the tag is generated.  This can be disabled by
 * using enableId.
 * @author UMCP
 *
 */
public class TagElement implements Element {
	private String tagName;
	private boolean endtag;
	private Element content;
	private String attributes;
	private String stringId;

	private static boolean idStatus = true;
	private static int nextID = 1;
	
	public TagElement(String tagName, boolean endTag, Element content, String attributes) {
		this.tagName = tagName;
		this.endtag = endTag;
		this.content = content;
		this.attributes = attributes;
		stringId = tagName + nextID;
		nextID++;
	}
	
	public int getId() {
		int sizeOfTag = tagName.length();
		String StrId = stringId.substring(sizeOfTag);
		return Integer.parseInt(StrId);
	}

	public String getStringId() {
		return stringId;
	}

	public String getStartTag() {
		StringBuffer strB = new StringBuffer();
		strB.append("<" + tagName);
		if (idStatus) {
			strB.append(" id=\"" + stringId + "\"");
		}
		if (attributes != null && !attributes.isEmpty()) {
			strB.append(" " + attributes);
		}		
		return strB.toString();
	}
	
	public String getEndTag() {
		if (endtag) {
			return "</" + tagName + ">";
		} else {
			return "";
		}
	}
	
	public void setAttributes​(String attributes) {
		this.attributes = attributes;
	}

	public static void resetIds() {
		nextID = 1;
	}

	public static void enableId(boolean choice) {
		idStatus = choice;
	}

	public String genHTML(int indentation) {
		StringBuffer strB = new StringBuffer();
		int i;
		for (i = 0; i < indentation; i++) {
			strB.append(" ");
		}
		strB.append(getStartTag());
		strB.append(">");
		
		if(content != null) {
			strB.append(content.genHTML(0));
		}
		strB.append(getEndTag());
		return strB.toString();
	}
	
	public boolean getIdStatus() {
		return idStatus;
	}

}