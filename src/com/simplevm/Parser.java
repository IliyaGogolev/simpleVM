package com.simplevm;

import com.simplevm.model.Data;
import com.simplevm.model.Logger;

import java.io.FileInputStream;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Parser {



    public Data parseFile(String filename) throws IOException {

        Data input_data = new Data();
        Logger.println("filename: " + filename);

        FileInputStream fin = new FileInputStream(filename);
        byte data[] = new byte[4];

        int index = 0;
        int code_counts = 0;
        while (fin.read(data) != -1) {

                int result = ByteBuffer.wrap(data).getInt();
                Logger.println(result);

                switch (index) {
                    case 0: // code_count
                        input_data.code_count = result;
                        code_counts = result;
                        index++;
                        break;

                    case 1: // array of codes
                        if (code_counts > 0) {
                            input_data.code.add(result);
                            code_counts--;
                        }

                        if (code_counts == 0) {
                            index++;
                        }
                        break;

                    case 2: // string_count
                        input_data.string_count = result;
                        index++;
                        parseStrings(fin, input_data);
                        break;
                }
        }

        return input_data;

    }


    private void parseStrings(FileInputStream fin, Data data) throws IOException {

        while (fin.available() > 0) {

            int charCount = readCharacterCount(fin);
            byte bytes_string[] = new byte[charCount];
            if (charCount > 0 && fin.read(bytes_string) != -1) {
                data.strings.add(new String(bytes_string));
            }
        }
    }

    /**
     * Assume that file format is fine, no exception
     * @param fin
     * @return
     * @throws IOException
     */
    private int readCharacterCount(FileInputStream fin) throws IOException {
        byte character_count_buffer[] = new byte[4];
        fin.read(character_count_buffer);
        return ByteBuffer.wrap(character_count_buffer).getInt();
    }
}
