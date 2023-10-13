import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyDOMParser implements MyParser {

    private final List<Student> students = new ArrayList<>();
    private StatisticsStrategy statisticsStrategy;

    @Override
    public void setStatisticsStrategy(StatisticsStrategy statisticsStrategy) {
        this.statisticsStrategy = statisticsStrategy;
    }

    @Override
    public void parse(String xml) throws ParserConfigurationException, IOException, SAXException {

        File xmlFile = new File(xml);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(xmlFile);

        Element root = document.getDocumentElement();

        NodeList groupNodes = root.getElementsByTagName("group");
        for (int i = 0; i < groupNodes.getLength(); i++) {
            Element groupElement = (Element) groupNodes.item(i);

            Element studentsElement = (Element) groupElement.getElementsByTagName("students").item(0);

            NodeList studentNodes = studentsElement.getElementsByTagName("student");
            for (int j = 0; j < studentNodes.getLength(); j++) {
                Element studentElement = (Element) studentNodes.item(j);

                Element surnameElement = (Element) studentElement.getElementsByTagName("surname").item(0);
                String surname = surnameElement.getTextContent();

                Element ageElement = (Element) studentElement.getElementsByTagName("age").item(0);
                String age = ageElement.getTextContent();

                Element genderElement = (Element) studentElement.getElementsByTagName("gender").item(0);
                String gender = genderElement.getTextContent();

                Student student = new Student(surname, Integer.parseInt(age), gender);
                students.add(student);

            }

        }

        statisticsStrategy.calculateStatistics(students);

    }


}