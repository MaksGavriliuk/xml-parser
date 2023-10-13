public class LoggingObserver implements ParserObserver {
    @Override
    public void onParsingStarted() {
        System.out.println("Начало парсинга");
    }

    @Override
    public void onParsingCompleted() {
        System.out.println("Конец парсинга");
    }

}