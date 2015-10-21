import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Martin Pfeffer (pepperonas)
 */
public class FileHelper {

    public static final String PLUGIN_DIR_NAME = "AnniKeymap";
    public static final String INTELLIJ_EXPORT = "intellij-export";
    public static final String STUDIO_EXPORT = "studio-export";


    protected static File createFile(String subDir, String fileName) {
        String format = (subDir.equals(INTELLIJ_EXPORT) ? "_AS_format" : "_IJ_format");

        fileName = fileName.split("\\.")[0];
        File dir = new File(System.getProperty("user.home") + File.separator +
                            PLUGIN_DIR_NAME + File.separator +
                            subDir + File.separator);

        if (!dir.exists()) dir.mkdirs();

        return new File(System.getProperty("user.home") + File.separator +
                        PLUGIN_DIR_NAME + File.separator +
                        subDir + File.separator +
                        fileName + format + ".xml");
    }


    protected static void writeStringInFile(File file, String data) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
