package homework;

/*Напишите программу, которая будет разбирать xml файл сделанный в предыдущих заданиях с помощью StAX, ]
и выводить его на экран в текстовом виде. Каждая точка должна выводиться на отдельной строке в виде 2
чисел, разделенных запятой, при этом должна выводиться единица измерения. Например: 10px, 30px.*/

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task23_11 {
    public static void main(String[] args) {
        boolean x = false;
        boolean y = false;
        String unit = "";

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileReader("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task22\\Task22_7.xml"));

            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();

                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("point")) {
                            System.out.println("Начальный элемент: point");
                            Attribute attribute = startElement.getAttributeByName(new QName("unit"));
                            unit = attribute.getValue();
                        } else if (qName.equalsIgnoreCase("x")) {
                            x = true;
                        } else if (qName.equalsIgnoreCase("y")) {
                            y = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();

                        if (x) {
                            System.out.print("x: " + characters.getData() + unit + ", ");
                            x = false;
                        } else if (y) {
                            System.out.println("x: " + characters.getData() + unit);
                            y = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if (endElement.getName().getLocalPart().equalsIgnoreCase("point")) {
                            System.out.println("Конечный элемент: point");
                            System.out.println("=======================");
                        }
                        break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
