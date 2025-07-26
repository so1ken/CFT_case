import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileFilter {
    private ConsoleParser data;
    private List<Integer> intData = new ArrayList<>();
    private List<Float> floatData = new ArrayList<>();
    private List<String> stringData = new ArrayList<>();

    public FileFilter(ConsoleParser data) {

        this.data = data;
    }

    public void Filter() {
        ReadFiles();
        if (!intData.isEmpty()) {
            var file = new File(data.getPrefix() + "integers.txt");
            WriteFile(intData, file);
        }
        if (!floatData.isEmpty()) {
            var file = new File(data.getPrefix() + "floats.txt");
            WriteFile(floatData, file);
        }
        if (!stringData.isEmpty()) {
            var file = new File(data.getPrefix() + "strings.txt");
            WriteFile(stringData, file);
            var state = new State(data.getStateType(), stringData);
            System.out.println(state.getStateLogs());
        }
    }

    private void ReadFiles() {
        for (String file : data.getFiles()) {
            try (var fr = new FileReader(file);
                 var reader = new BufferedReader(fr)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try {
                        intData.add(Integer.parseInt(line));
                    } catch (NumberFormatException e1) {
                        try {
                            floatData.add(Float.parseFloat(line));
                        } catch (NumberFormatException e2) {
                            stringData.add(line);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private <T> void WriteFile(List<T> list, File file) {
        try (var fis = new FileOutputStream(file);
             var writer = new PrintWriter(fis)) {
            list.forEach(writer::println);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
