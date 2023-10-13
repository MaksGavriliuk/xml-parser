public class SecondLoggingObserver implements ParserObserver {
    @Override
    public void onParsingStarted() {
        System.out.println("Начало парсинга для второго наблюдателя");
    }

    @Override
    public void onParsingCompleted() {
        System.out.println("Конец парсинга для второго наблюдателя");
    }
}
