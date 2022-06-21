package model;

/**
 * Represents the &lt;a&gt; tag.
 * @author UMCP
 *
 */
public class AnchorElement extends TagElement {
	
	private String linkText;
	private String url;
	private String attributes;

	public AnchorElement(String url, String linkText, String attributes) {
		super("a", true, null, attributes);
		this.linkText = linkText;
		this.url = url;
		this.attributes = attributes;
	}
	
	public String getLinkText() {
		return linkText;
	}
	
	public String getUrlText() {
		return url;
	}
	
	@Override
	public String genHTML(int indentation) {
		StringBuffer strB = new StringBuffer();
		int i;
		for (i = 0; i < indentation; i++) {
			strB.append(" ");
		}		
		strB.append("<a");
		if (getIdStatus()) {
			strB.append(" id=\"" + getStringId() + "\"");
		}		
		strB.append(" href=\"" + url + "\">" + linkText);
		if (attributes != null && !attributes.isEmpty()) {
			strB.append(" attr:\"" + attributes + "\"");
		}
		strB.append(getEndTag());
		return strB.toString();
	}

}
