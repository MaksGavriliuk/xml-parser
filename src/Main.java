
public class Main {
    public static void main(String[] args) {

        try {

            String pathToFile = "src/students.xml";

            ParserFactory parserFactory = new ParserFactory();
            Parser parser = new Parser();
            LoggingObserver loggingObserver = new LoggingObserver();

            parser.addObserver(loggingObserver);
            parser.parse(pathToFile, parserFactory.createParser("dom"), new AverageAgeStrategy());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}