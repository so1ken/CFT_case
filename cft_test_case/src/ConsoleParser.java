import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleParser {
    private String[] files;
    private String prefix = "";
    private String path = "";
    private StateType stateType;
    private boolean addToExisting = false;

    public ConsoleParser(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].matches("(.*).txt")) {
                list.add(args[i]);
            } else if (args[i].equals("-p")) {
                prefix = args[i + 1];
                i++;
            } else if (args[i].equals("-o")) {
                path = args[i + 1];
                i++;
            } else if (args[i].equals("-a")) {
                addToExisting = true;
            } else if (args[i].equals("-s")) {
                stateType = StateType.SHORT;
            } else if (args[i].equals("-f")) {
                stateType = StateType.FULL;
            }
            files = list.toArray(new String[0]);
        }
    }

    public String[] getFiles() {
        return files;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getPath() {
        return path;
    }

    public StateType getStateType() {
        return stateType;
    }

    public boolean isAddToExisting() {
        return addToExisting;
    }
}
