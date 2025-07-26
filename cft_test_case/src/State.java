import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class State {
    private StateType type;
    private String stateLogs;

    public String getStateLogs() {

        return stateLogs;
    }
    public <T> State(StateType type, List<T> list) {
        this.type = type;
        switch (type) {
            case SHORT -> {
                stateLogs = getShortState(list);
                break;
            }
            case FULL -> {
                getFullState(list);
                break;
            }
        }
    }

    private <T> void getFullState(List<T> list) {
        if (list.get(0).getClass().equals(String.class)) {
            int max = ((String) Collections.max(list, Comparator.comparingInt(el -> el.toString().length()))).length();
            int min = ((String) Collections.min(list, Comparator.comparingInt(el -> el.toString().length()))).length();

            System.out.println(min);
            System.out.println(max);
        }
    }

    private <T> String getShortState(List<T> list) {
        return "Количество файлов записанных в %s равно " + list.size() + "\n";
    }
}
