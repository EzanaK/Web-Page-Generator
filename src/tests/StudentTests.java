package tests;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.w3c.dom.Text;

import model.AnchorElement;
import model.HeadingElement;
import model.TableElement;
import model.TagElement;
import model.TextElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {

	@Test
	public void testingTextElement() {
		TextElement textE = new TextElement("textElement");
		System.out.print(textE.genHTML(5));
	}
	
	@Test
	public void testGetId() {
		String tagName = "img";
		String stringId = tagName + 10;
		int sizeOfTag = tagName.length();
		String StrId = stringId.substring(sizeOfTag);
		System.out.println(Integer.parseInt(StrId));
	}
	
	@Test
	public void testTagElementGenHTML() {
		TagElement.resetIds();
		TagElement.enableId(false);
		HeadingElement element = new HeadingElement(new TextElement("Introduction"), 1, null);
		String answer = element.genHTML(3);
		System.out.println(answer);
	}
	
	@Test
	public void pub04AnchorElementTest1() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		int indentation = 3;
		String answer = "", attributes = "attribute";

		TagElement.resetIds();
		TagElement.enableId(false);
		AnchorElement element = new AnchorElement("http://www.cs.umd.edu", "UMD", attributes);
		answer += element.genHTML(indentation);
		answer += "\nSecondElement\n";

		element = new AnchorElement("http://www.cs.umd.edu", "UMD", attributes);
		answer += element.genHTML(indentation);

		answer += "\nThirdElement\n";
		indentation = 6;
		element = new AnchorElement("http://www.cs.umd.edu", "UMD", attributes);
		;
		answer += element.genHTML(indentation);
		
		System.out.println(answer);
	}
	
	@Test
	public void pub08TableTest1() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		int indentation = 3;
		String attributes = "border=\"1\"", answer = "";

		TagElement.resetIds();
		TagElement.enableId(true);
		TableElement tableElement = new TableElement(2, 2, attributes);
		tableElement.addItem​(0, 0, new AnchorElement("http://www.cs.umd.edu", "UMD", "attributes"));
		tableElement.addItem​(0, 1, new AnchorElement("http://www.cs.umd.edu", "UMD", "attributes"));
		tableElement.addItem​(1, 0, new AnchorElement("http://www.cs.umd.edu", "UMD", "attributes"));

		answer += tableElement.genHTML(indentation);

		System.out.println(answer);
	}

}
