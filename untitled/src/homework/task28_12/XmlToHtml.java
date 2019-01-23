package homework.task28_12;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class XmlToHtml {
    public static void main(String[] args) {
        Source xml = new StreamSource(new File("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task28_12\\task28_12.xml"));
        Source xslt = new StreamSource(new File("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task28_12\\task28_12.xsl"));

        converter(xml, xslt);
    }

    public static void converter(Source xml, Source xslt) {
        StringWriter sw = new StringWriter();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task28_12\\task28_12.txt"));
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(xslt);
            transformer.transform(xml, new StreamResult(sw));
            writer.write(sw.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}