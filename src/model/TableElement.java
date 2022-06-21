package model;

/**
 * Represents the &lt;table&gt tag.
 * A two dimensional array is used to keep track of the Element objects of table.
 * @author UMCP
 *
 */
public class TableElement extends TagElement {
	
	private Element[][] items;
	private static double tablesUsed = 0;
	private static double totalTables = 0;
	
	public TableElement(int rows, int cols, String attributes) {
		super("table", true, null, attributes);
		items = new Element[rows][cols];
		totalTables += rows * cols;
	}
	
	public void addItem​(int rowIndex, int colIndex, Element item) {
		items[rowIndex][colIndex] = item;
		tablesUsed++;
	}
	
	public static double getTableUtilization() { // Changed to static
		return (tablesUsed/totalTables) * 100;
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
		strB.append(">\n");
		int row, col;
		for (row = 0; row < items.length; row++) {
			for (col = 0; col < items[0].length; col++) {
				if (col == 0) {
					strB.append(spaces + "   <tr>");
				} 
				strB.append("<td>");
				if (items[row][col] != null) {
					strB.append(items[row][col].genHTML(0));
				}
				strB.append("</td>");
				if (col == items[0].length - 1) {
					strB.append("</tr>\n");
				} 
			}
		}
		strB.append(spaces + getEndTag());
		return strB.toString();
	}
	
}
