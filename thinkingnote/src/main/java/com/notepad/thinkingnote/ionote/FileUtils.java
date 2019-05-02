package com.notepad.thinkingnote.ionote;

import java.io.*;

/**
 * Description: 文件处理操作
 * <p>
 * Create:      2018/6/25 0:28
 *
 * @author Marvin Yang
 */
public class FileUtils {

    public static void main(String [] args) {
        String fileName = "E:\\code\\data\\text_classify\\corpus.txt";
        File corpusFile = new File(fileName);

        if (!corpusFile.isFile()) {
            System.out.println("can not find file: " + fileName);
            return;
        }
        try {
            FileInputStream inputStream = new FileInputStream(corpusFile);
            byte [] buffer = new byte[2028];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                System.out.println(length);
                continue;
            }
            inputStream.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
