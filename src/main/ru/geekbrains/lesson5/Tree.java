package main.ru.geekbrains.lesson5;

import java.io.File;

/**
 *  Класс <Tree> доработан для вывода в консоль файлов
 *  строки 32,40
 */
public class Tree {
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if(isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "| ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if(files == null) {
            return;
        }

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if(files[i].isDirectory() || files[i].isFile()) {
                subDirTotal++;
            }
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()  || files[i].isFile()) {
                print(files[i], indent, subDirTotal == ++subDirCounter);
            }
        }
    }

}
