package model;

/**
 * Represents an &lt;img&gt; tag.  For this project
 * you can assume we will not update any of the attributes associated with
 * this tag.
 * @author UMCP
 *
 */
public class ImageElement extends TagElement {
	
	private String imageURL;
	private int width;
	private int height;
	private String alt;
	private String attribute;

	public ImageElement(String imageURL, int width, int height, String alt, String attributes) {
		super("img", false, null, attributes);
		this.imageURL = imageURL;
		this.width = width;
		this.height = height;
		this.alt = alt;
		this.attribute = attributes;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	@Override
	public String genHTML(int indentation) {
		StringBuffer strB = new StringBuffer();
		int i;
		for (i = 0; i < indentation; i++) {
			strB.append(" ");
		}
		strB.append(getStartTag());
		strB.append("src=\"" + imageURL + "\" width=\"" + width + "\" height=\"" + height + "\"");
		if (alt != null && !alt.isEmpty()) {
			strB.append(" alt=\"" + alt + "\"");
		}
		if (attribute != null && !attribute.isEmpty()) {
			strB.append(attribute);
		}
		strB.append(">");
		return strB.toString();
	}
	
}
