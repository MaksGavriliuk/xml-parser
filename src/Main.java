
public class Main {
    public static void main(String[] args) {

        try {

            String pathToFile = "src/students.xml";

            ParserFactory parserFactory = new ParserFactory();
            Parser parser = new Parser();

            parser.addObserver(new LoggingObserver());
            parser.addObserver(new SecondLoggingObserver());

            parser.parse(pathToFile, parserFactory.createParser("sax"), new AverageAgeStrategy());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}