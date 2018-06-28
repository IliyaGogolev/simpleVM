# PNZ.asm
start:
  print_text "Positive Negative Zero"

repeat:
  newline
  print_text "Enter any number: "
  input_a

  print_a
  print_text " is "
  literal_b 0
  cmp
  jlt       is_negative
  jgt       is_positive

is_zero:
  print_text "zero"
  jmp        repeat

is_negative:
  print_text "negative"
  jmp        repeat

is_positive:
  print_text "positive"
  jmp        repeat

