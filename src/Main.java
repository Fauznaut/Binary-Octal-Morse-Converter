/**
 * Created by Johnny on 12/21/2016.
 */
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static int getInput() {
        System.out.print("Enter a number: ");
        int input = scan.nextInt();
        return input;
    }

    public static int binaryOrMorseOrOctal() {
        System.out.print("Convert to Binary(1), Octal(2), or Morse(3)? ");
        return scan.nextInt();
    }

    public static void convertToBinary(int x) {
        int[] binaryArray = new int[31];
        int k = 0;
        int binaryArrayPower = binaryArray.length - 1;
        int firstOnePosition = binaryArray.length - 1;
        int returnControl = 0;
        while (x > 0) {
            if (x >= Math.pow(2, binaryArrayPower)) {
                binaryArray[k] = 1;
                if (k < firstOnePosition)
                    firstOnePosition = k;
                x -= Math.pow(2, binaryArrayPower);
            } else {
                binaryArray[k] = 0;
            }
            if (k < binaryArray.length - 1)
                k++;
            binaryArrayPower--;
        }
        System.out.println("Binary:");
        while (firstOnePosition < binaryArray.length - 1) {
            System.out.print(binaryArray[firstOnePosition] + " ");
            returnControl ++;
            firstOnePosition++;
            if (returnControl >= 15) {
                System.out.println();
                returnControl = 0;
            }
        }
        System.out.println();
    }

    public static void convertToOctal(int x) {
        int[] octalArray = new int[12];
        int k = 0;
        int octalArrayPower = octalArray.length - 1;
        int firstOctalPosition = octalArray.length - 1;
        while (x > 0) {
            if (x >= Math.pow(8, octalArrayPower)) {
                if (k < firstOctalPosition)
                    firstOctalPosition = k;
                for (int m = 1; m <= 7; m++) {
                    if (x >= m * Math.pow(8, octalArrayPower)) {
                        octalArray[k] = m;
                    } else {
                        break;
                    }
                }
                x -= octalArray[k] * Math.pow(8, octalArrayPower);
            } else {
                octalArray[k] = 0;
            }
            if (k < octalArray.length - 1)
                k++;
            octalArrayPower--;
        }
        System.out.println("Octal:");
        while (firstOctalPosition <= octalArray.length - 1) {
            System.out.print(octalArray[firstOctalPosition] + " ");
            firstOctalPosition++;
        }
        System.out.println();
    }

    public static void convertToMorse(int x) {
        String[] morseArray = new String[14];
        String inputAsString = Integer.toString(x);
        inputAsString = inputAsString.replace("1", ".----");
        inputAsString = inputAsString.replace("2", "..---");
        inputAsString = inputAsString.replace("3", "...--");
        inputAsString = inputAsString.replace("4", "....-");
        inputAsString = inputAsString.replace("5", ".....");
        inputAsString = inputAsString.replace("6", "-....");
        inputAsString = inputAsString.replace("7", "--...");
        inputAsString = inputAsString.replace("8", "---..");
        inputAsString = inputAsString.replace("9", "----.");
        inputAsString = inputAsString.replace("0", "-----");
        System.out.println("Morse:");
        System.out.println(inputAsString);
    }

    public static void main(String[] args) {
        int input = 0;
        int quitControl = 0;
        while (quitControl != 4) {
            int control = 0;
            input = getInput();
            if (input == 69)
                System.out.println("Haha nice.");
            while (control != 1 && control != 2 && control != 3) {
                control = binaryOrMorseOrOctal();
                if (control == 1) {
                    convertToBinary(input);
                    System.out.print("Enter another number(1), convert to Octal(2), convert to Morse(3), or quit(4)? ");
                    while (quitControl != 1 && quitControl != 2 && quitControl != 3 && quitControl != 4) {
                        quitControl = scan.nextInt();
                        if (quitControl == 1) {
                            System.out.println("-------------------------------");
                            break;
                        } else if (quitControl == 2) {
                            convertToOctal(input);
                            System.out.print("Enter another number(1), convert to Morse(2), or quit(4)? ");
                            while (quitControl != 1 && quitControl != 3 && quitControl != 4) {
                                quitControl = scan.nextInt();
                                if (quitControl == 1) {
                                    System.out.println("-------------------------------");
                                } else if (quitControl == 2) {
                                    convertToMorse(input);
                                    System.out.print("Enter another number(1) or quit(4)? ");
                                    while (quitControl != 1 && quitControl != 4) {
                                        quitControl = scan.nextInt();
                                        if (quitControl == 1) {
                                            System.out.println("-------------------------------");
                                            break;
                                        } else if (quitControl == 4) {
                                            System.out.println("End");
                                            control = 1;
                                            break;
                                        } else {
                                            System.out.print("Input 1 to enter another number or 4 to quit the program: ");
                                        }
                                    }
                                } else if (quitControl == 4) {
                                    System.out.println("End");
                                    control = 1;
                                    break;
                                } else {
                                    System.out.print("Input 1 to enter another number, 3 to convert to Morse, or 4 to quit the program: ");
                                }
                            }
                        } else if (quitControl == 3) {
                            convertToMorse(input);
                            System.out.print("Enter another number(1), convert to Octal(2), or quit(4)? ");
                            while (quitControl != 1 && quitControl != 2 && quitControl != 4) {
                                quitControl = scan.nextInt();
                                if (quitControl == 1) {
                                    System.out.println("-------------------------------");
                                } else if (quitControl == 2) {
                                    convertToOctal(input);
                                    System.out.print("Enter another number(1) or quit(4)? ");
                                    while (quitControl != 1 && quitControl != 4) {
                                        quitControl = scan.nextInt();
                                        if (quitControl == 1) {
                                            System.out.println("-------------------------------");
                                            break;
                                        } else if (quitControl == 4) {
                                            System.out.println("End");
                                            control = 1;
                                            break;
                                        } else {
                                            System.out.print("Input 1 to enter another number or 4 to quit the program: ");
                                        }
                                    }
                                }
                            }
                        } else if (quitControl == 4) {
                            System.out.println("End");
                            break;
                        } else {
                            System.out.print("Input 1 to enter another number, 2 to convert your input to octal, 3 to convert your input to Morse, or 4 to quit the program. ");
                        }
                    }
                } else if (control == 2) {
                    convertToOctal(input);
                    System.out.print("Enter another number(1), convert to Binary(2), convert to Morse(3), or quit(4)? ");
                    while (quitControl != 1 && quitControl != 2 && quitControl != 3 && quitControl != 4) {
                        quitControl = scan.nextInt();
                        if (quitControl == 1) {
                            System.out.println("-------------------------------");
                            break;
                        } else if (quitControl == 2) {
                            convertToBinary(input);
                            System.out.print("Enter another number(1), convert to Morse(2), or quit(4)? ");
                            while (quitControl != 1 && quitControl != 4) {
                                quitControl = scan.nextInt();
                                if (quitControl == 1) {
                                    System.out.println("-------------------------------");
                                } else if (quitControl == 2) {
                                    convertToMorse(input);
                                    System.out.print("Enter another number(1) or quit(4)? ");
                                    while (quitControl != 1 && quitControl != 4) {
                                        quitControl = scan.nextInt();
                                        if (quitControl == 1) {
                                            System.out.println("-------------------------------");
                                            break;
                                        } else if (quitControl == 4) {
                                            System.out.println("End");
                                            break;
                                        } else {
                                            System.out.print("Input 1 to enter another number or 4 to quit the program: ");
                                        }
                                    }
                                } else if (quitControl == 4) {
                                    System.out.println("End");
                                    break;
                                } else {
                                    System.out.print("Input 1 to enter another number, 2 to convert to Binary, 3 to convert to Morse, or 4 to quit the program: ");
                                }
                            }
                        } else if (quitControl == 3) {
                            convertToMorse(input);
                            System.out.print("Enter another number(1), convert to Binary(2), or quit(4)? ");
                            while (quitControl != 1 && quitControl != 2 && quitControl != 4) {
                                quitControl = scan.nextInt();
                                if (quitControl == 1) {
                                    System.out.println("-------------------------------");
                                } else if (quitControl == 2) {
                                    convertToBinary(input);
                                    System.out.print("Enter another number(1) or quit(4)? ");
                                    while (quitControl != 1 && quitControl != 4) {
                                        quitControl = scan.nextInt();
                                        if (quitControl == 1) {
                                            System.out.println("-------------------------------");
                                            break;
                                        } else if (quitControl == 4) {
                                            System.out.println("End");
                                            break;
                                        } else {
                                            System.out.print("Input 1 to enter another number or 4 to quit the program: ");
                                        }
                                    }
                                }
                            }
                        } else if (quitControl == 4) {
                            System.out.println("End");
                            break;
                        } else {
                            System.out.println("Input 1 to enter another number, 2 to convert your input to Binary, 3 to convert your input to Morse, or 4 to quit the program. ");
                        }
                    }
                } else if (control == 3) {
                    convertToMorse(input);
                    System.out.print("Enter another number(1), convert to Binary(2), convert to Octal(3), or quit(4)? ");
                    while (quitControl != 1 && quitControl != 2 && quitControl != 3 && quitControl != 4) {
                        quitControl = scan.nextInt();
                        if (quitControl == 1) {
                            System.out.println("-------------------------------");
                            break;
                        } else if (quitControl == 2) {
                            convertToBinary(input);
                            System.out.print("Enter another number(1), convert to Octal(2), or quit(4)? ");
                            while (quitControl != 1 && quitControl != 4) {
                                quitControl = scan.nextInt();
                                if (quitControl == 1) {
                                    System.out.println("-------------------------------");
                                } else if (quitControl == 2) {
                                    convertToOctal(input);
                                    System.out.print("Enter another number(1) or quit(4)? ");
                                    while (quitControl != 1 && quitControl != 4) {
                                        quitControl = scan.nextInt();
                                        if (quitControl == 1) {
                                            System.out.println("-------------------------------");
                                            break;
                                        } else if (quitControl == 4) {
                                            System.out.println("End");
                                            break;
                                        } else {
                                            System.out.print("Input 1 to enter another number or 4 to quit the program: ");
                                        }
                                    }
                                } else if (quitControl == 4) {
                                    System.out.println("End");
                                    break;
                                } else {
                                    System.out.print("Input 1 to enter another number, 2 to convert to Binary, 3 to convert to Morse, or 4 to quit the program: ");
                                }
                            }
                        } else if (quitControl == 3) {
                            convertToOctal(input);
                            System.out.print("Enter another number(1), convert to Binary(2), or quit(4)? ");
                            while (quitControl != 1 && quitControl != 2 && quitControl != 4) {
                                quitControl = scan.nextInt();
                                if (quitControl == 1) {
                                    System.out.println("-------------------------------");
                                } else if (quitControl == 2) {
                                    convertToBinary(input);
                                    System.out.print("Enter another number(1) or quit(4)? ");
                                    while (quitControl != 1 && quitControl != 4) {
                                        quitControl = scan.nextInt();
                                        if (quitControl == 1) {
                                            System.out.println("-------------------------------");
                                            break;
                                        } else if (quitControl == 4) {
                                            System.out.println("End");
                                            break;
                                        } else {
                                            System.out.print("Input 1 to enter another number or 4 to quit the program: ");
                                        }
                                    }
                                }
                            }
                        } else if (quitControl == 4) {
                            System.out.println("End");
                            break;
                        } else {
                            System.out.println("Input 1 to enter another number, 2 to convert your input to Binary, 3 to convert your input to Morse, or 4 to quit the program. ");
                        }
                    }
                } else {
                    System.out.println("Input 1 for Binary and 2 for Octal. ");
                }
            }
        }
    }
}