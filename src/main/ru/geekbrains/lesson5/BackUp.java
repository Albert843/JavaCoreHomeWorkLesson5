package main.ru.geekbrains.lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class BackUp {
    private final String source;
    private final String backup = "./backup";

    public BackUp(String source) {
        this.source = source;
    }

    public static void main(String[] args) throws IOException {
        BackUp backUp = new BackUp(".");
        backUp.copyFiles();
    }

    /**
     * Метод копирует файлы из текущей папки в папку "./backup"
     * @throws IOException
     */
    public void copyFiles() throws IOException {
        File folder = new File(this.source);
        File backupFolder = new File(this.backup);
        if(!backupFolder.exists())
        {
            Path path = Files.createDirectories(Paths.get(this.backup));
            System.out.printf("Директория %s создана\n", path.toString());
        }
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                Files.copy(Paths.get(file.getName()),
                        Paths.get(backupFolder+"/"+file.getName()),
                        REPLACE_EXISTING);
                System.out.printf("Файл %s скопирован.\n", file.getName());
            }
        }
    }
}

