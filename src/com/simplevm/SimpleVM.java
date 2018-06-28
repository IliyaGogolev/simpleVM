package com.simplevm;

import com.simplevm.model.Data;
import com.simplevm.model.Opcode;

public class SimpleVM {

    int ip;
    int a;
    int b;
    byte n; // boolean 0/1
    byte z; // boolean 0/1

    int[] memory = new int[128];

    int opcode_index = 0;

    public void execute(Data data) {

        if (data.code_count == 0) {
            System.out.println("No opcodes");
            return;
        }

        // initialize vm
        ip = data.code.get(opcode_index++);

        while (ip != Opcode.HALT.code()) {
            proccessCode(ip, data);
            if (opcode_index < data.code_count) {
                ip = data.code.get(opcode_index++);
            } else {
                System.out.println("Wrong input, opcode_index: " + opcode_index);
                System.exit(0);
            }
        }

    }

    private void proccessCode(int ip, Data data) {

        if (ip == Opcode.HALT.code()) {

            System.exit(0);

        } else if (ip == Opcode.NEWLINE.code()) {

            System.out.println("");

        } else if (ip == Opcode.PRINT_TEXT.code()) {

            int stringIndex = data.code.get(opcode_index++);
            if (stringIndex >= data.strings.size()) {
                System.out.println("NO STRING, WRONG INPUT, string index: " + stringIndex);
            } else {
                System.out.println(data.strings.get(stringIndex));
            }
        }
    }

}
