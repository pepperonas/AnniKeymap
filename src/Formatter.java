import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Martin Pfeffer (pepperonas)
 */
public class Formatter {

    public static final int AS_FORMAT = 0;
    public static final int IJ_FORMAT = 1;


    protected static String formatKeymap(File file, int mode) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder builder = new StringBuilder();
        String line;

        while (((line = bufferedReader.readLine()) != null)) {

            if (line.contains("<keyboard-shortcut")) Formatter.formatShortcut(builder, line, mode);

            else builder.append(line).append("\n");
        }

        System.out.println(builder.toString());
        bufferedReader.close();
        reader.close();

        return builder.toString();
    }


    protected static void formatShortcut(StringBuilder builder, String line, int mode) {
        String shortCut = line.split("\"")[1];
        String[] keys = shortCut.split(" ");
        String keyToFormat = keys[keys.length - 1];

        keyToFormat = mode == AS_FORMAT ? keyToFormat.toUpperCase()
                                        : keyToFormat.toLowerCase();

        String formatted = "";

        for (int i = 0; i < keys.length - 1; i++) {
            formatted += keys[i] + " ";
        }

        formatted += keyToFormat;
        builder.append(line.replace(shortCut, formatted)).append("\n");
    }

}
