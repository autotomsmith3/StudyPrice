package xmlParse;

//This is based on xml_parser_3.java. this works for CPS return. "StatusFlags"
//Two levels return. After enter node name, it returns attribute names and their values. "StatusFlags" as an example.
//Try to parse parent node and its child like: Works fine here.
//<StatusFlags>
//  <Flag>STANDARD_ICC</Flag>
//  <Flag>FLEET_OPTION_LOGIC</Flag>
//  <Flag>FLEET_OPTION_ICC</Flag>
//  <Flag>SEO_OPTION_LOGIC</Flag>
//  <Flag>SEO_OPTION_ICC</Flag>
//</StatusFlags>
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class xml_parser_5 {

	public static void main(String[] args) throws IOException {
		// String inputFile = "C:\\data\\xml\\CPS01.xml";
		String inputFile = "http://cps.london.autodata.net/api-ws/vehicle/UW/UW_ETL/USC40CHT279C0";
		String tagName = "";
		String element = "";
		String nodeString;
		try {
			// Reads text from a character-input stream
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// The Document interface represents the entire HTML or XML document. Conceptually, it is the root of the document tree, and provides the primary access to the document's data.
			Document doc = factory.newDocumentBuilder().parse(inputFile);
			while (!element.equalsIgnoreCase("stop")) {

				// Get input element from user
				System.out.print("Enter element name: ");
				element = reader.readLine();
				// Returns a NodeList of all the Elements in document order with a given tag name and are contained in the document.
				NodeList nodes = doc.getElementsByTagName(element);
				int nodeCount = nodes.getLength();
				System.out.println("\nHere you go => Total # of Elements: " + nodes.getLength());
				System.out.println("\n");

				for (int i = 0; i < nodeCount; i++) {
					// String nodeS=nodes.toString(); //useless
					org.w3c.dom.Node nL = nodes.item(i);// first key
					// String keyA=nL
					String nodeName = nL.getNodeName();// StatusFlags
					String key1 = nL.getNodeValue();// null
					String key2 = nL.getLocalName();// null

					NodeList childNode = nL.getChildNodes();
					int childNodeLength = childNode.getLength();// 5
					for (int k = 0; k < childNodeLength; k++) {

						org.w3c.dom.Node childnL = childNode.item(k);
						nodeName = childnL.getNodeName();// Flag
						String nodeValue = childnL.getTextContent();
						// nodeValue = childnL.getNodeValue(); //this shows null
						System.out.println("Node Num =   " + (i + 1) + " Total attributs= " + childNodeLength
								+ ". Attribute Num=   " + (k + 1));
						System.out.println("NodeName=                      " + nodeName);
						System.out.println("NodeValue=             " + nodeValue);
						System.out.println("\n");

						System.out.println("\n");
					}
				}

			}

			System.out.println("Complete!!!\n");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}