public class EntryPoint {

    public static void main(String[] args) {

        ConsoleParser data = new ConsoleParser(args);
        FileFilter filter = new FileFilter(data);
        filter.Filter();
    }
}
