import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.io.File;
import java.io.IOException;

/**
 * @author Martin Pfeffer (pepperonas)
 */
public class ExportIj extends AnAction {

    public void actionPerformed(AnActionEvent e) {

        File keymapDir = new File(System.getProperty("user.home") + File.separator + ".IntelliJIdea14/config/keymaps");

        for (File map : keymapDir.listFiles()) {
            try {

                FileHelper.writeStringInFile(
                        FileHelper.createFile(FileHelper.INTELLIJ_EXPORT, map.getName()),
                        Formatter.formatKeymap(map, Formatter.AS_FORMAT));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
