package com.simplevm.model;

public enum Opcode {

    HALT(0),            // Stops execution
    JMP(1, 1),          // IP = ARG
    JEQ(2, 1),          // if Z  (the Z flag is true) then IP = ARG
    JNE(3, 1),          // if Z  (the Z flag is true) then IP = ARG
    JGT(4, 1),          // if !N and !Z then IP = ARG
    JGE(5, 1),          // if !N or Z then IP = ARG
    JLT(6, 1),          // if N and !Z then IP = ARG
    JLE(7, 1),          // if N or Z then IP = ARG
    LITERAL_A(8, 1),    // A = ARG
    LITERAL_B(9, 1),    // B = ARG
    INPUT_A(10),        // A = (integer read from console)
    INPUT_B(11),        // B = (integer read from console)
    NEWLINE(12),        // Prints a newline to the console
    PRINT_A(13),        // Prints the value of A without a newline
    PRINT_B(14),        // Prints the value of B without a newline
    PRINT_TEXT(15, 1),  // Prints strings[ARG] without a newline
    READ_A(16, 1),      // A = MEMORY[ARG]
    READ_B(17, 1),      // B = MEMORY[ARG]
    WRITE_A(18, 1),     // MEMORY[ARG] = A
    WRITE_B(19, 1),     // MEMORY[ARG] = B
    ADD(20),            // A = A + B; N = A<0; Z = A==0
    SUB(21),            // A = A + B; N = A<0; Z = A==0
    MUL(22),            // A = A * B; N = A<0; Z = A==0
    DIV(23),            // A = A / B; N = A<0; Z = A==0
    MOD(24),            // A = A % B; N = A<0; Z = A==0
    CMP(25),            // TEMP = A - B; N = TEMP<0; Z = TEMP==0 (discard result, keep flags)
    SQRT(26);           //  A = SQRT(A); N = A<0; Z = A==0;

    private int _code;
    private int _arg;

    Opcode(int code) {
        this._code = code;
        this._arg = 0;
    }

    Opcode(int code, int arg) {
        _code = code;
        _arg = arg;
    }

    public int code() {
        return _code;
    }

    public int arg() {
        return _arg;
    }
}
