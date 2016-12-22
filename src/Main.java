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

    public static int binaryOrOctal() {
        System.out.print("Convert to Binary(1) or Octal(2)? ");
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

    public static void main(String[] args) {
        int input = 0;
        int quitControl = 0;
        while (quitControl != 3) {
            int control = 0;
            input = getInput();
            if (input == 69)
                System.out.println("Haha nice.");
            while (control != 1 && control != 2) {
                control = binaryOrOctal();
                if (control == 1) {
                    convertToBinary(input);
                    System.out.print("Enter another number(1), convert to Octal(2), or quit(3)? ");
                    quitControl = scan.nextInt();
                    if (quitControl == 1) {
                        System.out.println("-------------------------------");
                        break;
                    } else if (quitControl == 2) {
                        convertToOctal(input);
                        System.out.print("Enter another number(1) or quit(3)? ");
                        while (quitControl != 1 && quitControl != 3) {
                            quitControl = scan.nextInt();
                            if (quitControl == 1) {
                                System.out.println("-------------------------------");
                            } else if (quitControl == 3) {
                                System.out.println("Fin");
                                control = 1;
                                break;
                            } else {
                                System.out.print("Input 1 to enter another number or 3 to quit the program: ");
                            }
                        }
                    } else if (quitControl == 3) {
                        System.out.println("Fin");
                        break;
                    } else {
                        System.out.println("Input 1 to enter another number, 2 to convert your input to octal, or 3 to quit the program. ");
                    }
                } else if (control == 2) {
                    convertToOctal(input);
                    System.out.print("Enter another number(1), convert to binary(2), or quit(3)? ");
                    quitControl = scan.nextInt();
                    if (quitControl == 1) {
                        System.out.println("-------------------------------");
                        break;
                    } else if (quitControl == 2) {
                        convertToBinary(input);
                        System.out.print("Enter another number(1) or quit(3)? ");
                        while (quitControl != 1 && quitControl != 3) {
                            quitControl = scan.nextInt();
                            if (quitControl == 1) {
                                System.out.println("-------------------------------");
                            } else if (quitControl == 3) {
                                System.out.println("Fin");
                                control = 1;
                                break;
                            } else {
                                System.out.print("Input 1 to enter another number or 3 to quit the program: ");
                            }
                        }
                    } else if (quitControl == 3) {
                        System.out.println("Fin");
                        break;
                    } else {
                        System.out.println("Input 1 to enter another number, 2 to convert your input to binary, or 3 to quit the program. ");
                    }
                    break;
                } else {
                    System.out.println("Input 1 for Binary and 2 for Octal. ");
                }
            }
        }
    }
}
