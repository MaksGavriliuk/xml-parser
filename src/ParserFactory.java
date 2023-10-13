class ParserFactory {
    public MyParser createParser(String type) {
        if (type.equalsIgnoreCase("SAX")) {
            return new MySAXParser();
        } else if (type.equalsIgnoreCase("DOM")) {
            return new MyDOMParser();
        }

        throw new IllegalArgumentException("Invalid parser type: " + type);
    }
}
