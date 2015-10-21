import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.io.File;
import java.io.IOException;

/**
 * @author Martin Pfeffer (pepperonas)
 */
public class ExportAs extends AnAction {

    public void actionPerformed(AnActionEvent e) {

        File keymapDir = new File(System.getProperty("user.home") + File.separator + ".AndroidStudio1.4/config/keymaps");

        for (File map : keymapDir.listFiles()) {
            try {

                FileHelper.writeStringInFile(
                        FileHelper.createFile(FileHelper.STUDIO_EXPORT, map.getName()),
                        Formatter.formatKeymap(map, Formatter.IJ_FORMAT));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
