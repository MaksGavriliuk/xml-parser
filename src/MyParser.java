import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface MyParser {
    void parse(String xml) throws ParserConfigurationException, SAXException, IOException;
    void setStatisticsStrategy(StatisticsStrategy statisticsStrategy);
}
