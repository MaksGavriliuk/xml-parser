import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Parser {
    private final List<ParserObserver> observers = new ArrayList<>();

    public void addObserver(ParserObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ParserObserver observer) {
        observers.remove(observer);
    }

    public void parse(String xml, MyParser handler, StatisticsStrategy statisticsStrategy) throws ParserConfigurationException, SAXException, IOException {
        notifyParsingStarted();

        handler.setStatisticsStrategy(statisticsStrategy);
        handler.parse(xml);

        notifyParsingCompleted();
    }

    private void notifyParsingStarted() {
        for (ParserObserver observer : observers) {
            observer.onParsingStarted();
        }
    }

    private void notifyParsingCompleted() {
        for (ParserObserver observer : observers) {
            observer.onParsingCompleted();
        }
    }

}