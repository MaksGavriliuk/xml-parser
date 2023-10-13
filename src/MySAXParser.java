import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MySAXParser extends DefaultHandler implements MyParser {

    private final StringBuilder text = new StringBuilder();
    private final List<Student> students = new ArrayList<>();
    private StatisticsStrategy statisticsStrategy;

    private Student student;

    @Override
    public void setStatisticsStrategy(StatisticsStrategy statisticsStrategy) {
        this.statisticsStrategy = statisticsStrategy;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("student".equals(qName)) {
            student = new Student();
        } else if ("surname".equals(qName) || "age".equals(qName) || "gender".equals(qName)) {
            text.setLength(0);
        }
    }

    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "students":
                statisticsStrategy.calculateStatistics(students);
                break;
            case "student":
                students.add(student);
                break;
            case "surname":
                String surname = text.toString().trim();
                student.setSurname(surname);
                break;
            case "age":
                String age = text.toString().trim();
                student.setAge(Integer.parseInt(age));
                break;
            case "gender":
                String gender = text.toString().trim();
                student.setGender(gender);
                break;
        }
        text.setLength(0);
    }


    public void characters(char[] ch, int start, int length) {
        text.append(ch, start, length);
    }


    @Override
    public void parse(String xml) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        parser.parse(xml, this);

    }

}