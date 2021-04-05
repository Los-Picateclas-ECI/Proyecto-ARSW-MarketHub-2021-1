package edu.escuelaing.arsw.markethub.tools;

import java.io.File;

public class FileManager {
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
