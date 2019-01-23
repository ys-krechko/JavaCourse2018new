package homework;

/*Напишите программу, которая будет разбирать xml файл сделанный в предыдущих заданиях с помощью DOM, ]
и выводить его на экран в текстовом виде. Каждая точка должна выводиться на отдельной строке в виде 2
чисел, разделенных запятой, при этом должна выводиться единица измерения. Например: 10px, 30px.*/

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Task23_10 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task22\\Task22_7.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
            System.out.println("============================");
            NodeList list = doc.getElementsByTagName("point");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                System.out.println("\nТекущий элемент: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.print("x: " + element.getElementsByTagName("x").item(0).getTextContent() + element.getAttribute("unit") + ", ");
                    System.out.println("y: " + element.getElementsByTagName("y").item(0).getTextContent() + element.getAttribute("unit"));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
