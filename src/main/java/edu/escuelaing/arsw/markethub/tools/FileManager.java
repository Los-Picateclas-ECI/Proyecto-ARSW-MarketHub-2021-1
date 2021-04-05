package edu.escuelaing.arsw.markethub.tools;

import java.io.File;

public class FileManager {

    public static File createDir(String path) {
        File dir = new File(path);
        if (!dir.exists())
            dir.mkdirs();
        return dir;
    }

    public static void removeDir(File file) {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    removeDir(entry);
                }
            }
        }
        if (!file.delete()) {
            System.out.println("Failed to delete " + file);
        }
    }
}
