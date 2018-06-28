package com.simplevm;

import com.simplevm.model.Data;

import java.io.*;

public class Main {

    /**
     * Usage: Hello.out
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // write your code here

        if (args.length > 0) {

            Parser parser = new Parser();
            Data data = parser.parseFile(args[0]);
            SimpleVM vm = new SimpleVM();
            vm.execute(data);

        } else {
            System.out.println("Usage: ./program_name filename.out");
        }

    }


}
