# simpleVM

SIMPLE VM

Input Files "Hello.out", "PNZ.out", and "Primes.out" all contain compiled programs written in a simple bytecode or "intcode". Virtual machine loads up a specified file and executes the bytecode. Each bytecode file has the following format. "Int32" values are in high-low byte order, so the number 1 is written as the bytes 00 00 00 01.

# .OUT FILE FORMAT
Int32  code_count               # number of 32-bit integers that follow
Int32  code[ code_count ]      # 'code_count' number of 32-bit integers representing opcodes and operands
Int32  string_count            # number of strings that follow
String strings[ string_count ] # Set of strings. The format of a string is described next.

# STRING FORMAT (PER STRING IN .OUT FILE)
Int32  character_count
Byte   characters[ character_count ]  # ASCII values

Here is a screen shot of Hello.out. It shows:

code_count:      4
code:            15, 0, 12, 0
string_count:    1
character_count: 12
characters:      Hello World!


REGISTERS

The Simple VM has the following registers:

ip : Int32   (Instruction Pointer)
a  : Int32
b  : Int32
n  : Logical (AKA Boolean)
z  : Logical

The should all start at zero/false.

MEMORY

The Simple VM has an array of 128 Int32 variables referred to as the MEMORY.

OPCODES

The Simple VM has the following opcodes. Each opcode is followed by zero or one operands. Opcodes with operands are marked with a (1) afterwards. The operands are referred to as ARG.

  0  HALT          - Stops execution
  1  JMP(1)        - IP = ARG
  2  JEQ(1)        - if Z  (the Z flag is true) then IP = ARG
  3  JNE(1)        - if !Z (the Z flag is false) then IP = ARG
  4  JGT(1)        - if !N and !Z then IP = ARG
  5  JGE(1)        - if !N or Z then IP = ARG
  6  JLT(1)        - if N and !Z then IP = ARG
  7  JLE(1)        - if N or Z then IP = ARG
  8  LITERAL_A(1)  - A = ARG
  9  LITERAL_B(1)  - B = ARG
 10  INPUT_A       - A = (integer read from console)
 11  INPUT_B       - B = (integer read from console)
 12  NEWLINE       - Prints a newline to the console
 13  PRINT_A       - Prints the value of A without a newline
 14  PRINT_B       - Prints the value of B without a newline
 15  PRINT_TEXT(1) - Prints strings[ARG] without a newline
 16  READ_A(1)     - A = MEMORY[ARG]
 17  READ_B(1)     - B = MEMORY[ARG]
 18  WRITE_A(1)    - MEMORY[ARG] = A
 19  WRITE_B(1)    - MEMORY[ARG] = B
 20  ADD           - A = A + B; N = A<0; Z = A==0
 21  SUB           - A = A - B; N = A<0; Z = A==0
 22  MUL           - A = A * B; N = A<0; Z = A==0
 23  DIV           - A = A / B; N = A<0; Z = A==0
 24  MOD           - A = A % B; N = A<0; Z = A==0
 25  CMP           - TEMP = A - B; N = TEMP<0; Z = TEMP==0 (discard result, keep flags)
 26  SQRT          - A = SQRT(A); N = A<0; Z = A==0


Program executed from the command line.

Once you load a program start an execution loop that continually evaluates code[IP] until the HALT instruction is given. VM increments IP by 2 if the instruction has an argument or by 1 if not. Special care taken by changing IP during a JUMP instruction.

DISASSEMBLER

TODO: Disassembler that prints out the bytes for each command in hex form followed by the mnemonics, one command per line, and finally the list of strings at the end.


ASSEMBLER

TODO: Using the specs and files from Part 1, write an assembler that can assemble the included ".asm" source files. It does not need to be very elegant or handle any unusual syntax - using substrings and such rather than "real parsing" is fine. Extra: Use your assembler write a simple new program 
