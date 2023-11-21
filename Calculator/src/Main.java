import java.io.IOException;
import java.util.Scanner;

class Main {


    public static void main(String[] args)  throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String input = scanner.nextLine();
        String result = calc(input);
        if (result==null) {
        } else{
            System.out.println(result);
        }
    }
    public static String calc(String input) throws IOException {
        String[] massiveOfSigns = {"+", "-", "*", "/"};
        char[] charArray = input.toCharArray();
        int numberOfSigns = 0;
        String sign = null;
        String result = null;
        int preresult = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < massiveOfSigns.length; j++) {
                if (Character.toString(charArray[i]).equals(massiveOfSigns[j])) {
                    numberOfSigns = numberOfSigns + 1;
                    sign = Character.toString(charArray[i]);
                }
            }
        }
        if (numberOfSigns != 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception");
            }
        } else {
            switch (sign) {
                case "+":
                    String[] massiveOfNumbers1 = input.split("\\+");
                    if (getCondition(massiveOfNumbers1)) {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            System.out.println("throws Exception");
                        }
                    } else if (getNumber(massiveOfNumbers1)) {
                        int a = Integer.parseInt(massiveOfNumbers1[0]);
                        int b = Integer.parseInt(massiveOfNumbers1[1]);
                        preresult = a + b;
                        result = Integer.toString(preresult);
                    } else {
                        int a = Integer.parseInt(Convert.valueOf(massiveOfNumbers1[0]).getConverting());
                        int b = Integer.parseInt(Convert.valueOf(massiveOfNumbers1[1]).getConverting());
                        preresult = a + b;
                        if (preresult >= 1) {
                        result = getRoman(preresult);
                        } else {
                            try {
                                throw new IOException();
                            } catch (IOException e) {
                                System.out.println("throws Exception");
                            }
                        }
                    }
                    break;
                case "-":
                    String[] massiveOfNumbers2 = input.split("-");
                    if (getCondition(massiveOfNumbers2)) {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            System.out.println("throws Exception");
                        }
                    } else if (getNumber(massiveOfNumbers2)) {
                        int a = Integer.parseInt(massiveOfNumbers2[0]);
                        int b = Integer.parseInt(massiveOfNumbers2[1]);
                        preresult = a - b;
                        result = Integer.toString(preresult);
                    } else {
                        int a = Integer.parseInt(Convert.valueOf(massiveOfNumbers2[0]).getConverting());
                        int b = Integer.parseInt(Convert.valueOf(massiveOfNumbers2[1]).getConverting());
                        preresult = a - b;
                        if (preresult >= 1) {
                            result = getRoman(preresult);
                        } else {
                            try {
                                throw new IOException();
                            } catch (IOException e) {
                                System.out.println("throws Exception");
                            }
                        }
                    }
                    break;
                case "*":
                    String[] massiveOfNumbers3 = input.split("\\*");
                    if (getCondition(massiveOfNumbers3)) {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            System.out.println("throws Exception");
                        }
                    } else if (getNumber(massiveOfNumbers3)) {
                        int a = Integer.parseInt(massiveOfNumbers3[0]);
                        int b = Integer.parseInt(massiveOfNumbers3[1]);
                        preresult = a * b;
                        result = Integer.toString(preresult);
                    } else {
                        int a = Integer.parseInt(Convert.valueOf(massiveOfNumbers3[0]).getConverting());
                        int b = Integer.parseInt(Convert.valueOf(massiveOfNumbers3[1]).getConverting());
                        preresult = a * b;
                        if (preresult >= 1) {
                            result = getRoman(preresult);
                        } else {
                            try {
                                throw new IOException();
                            } catch (IOException e) {
                                System.out.println("throws Exception");
                            }
                        }
                    }
                    break;
                case "/":
                    String[] massiveOfNumbers4 = input.split("/");
                    if (getCondition(massiveOfNumbers4)) {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            System.out.println("throws Exception");
                        }
                    } else if (getNumber(massiveOfNumbers4)) {
                        int a = Integer.parseInt(massiveOfNumbers4[0]);
                        int b = Integer.parseInt(massiveOfNumbers4[1]);
                        preresult = a/b;
                        result = Integer.toString(preresult);
                    } else {
                        int a = Integer.parseInt(Convert.valueOf(massiveOfNumbers4[0]).getConverting());
                        int b = Integer.parseInt(Convert.valueOf(massiveOfNumbers4[1]).getConverting());
                        preresult = a/b;
                        if (preresult >= 1) {
                            result = getRoman(preresult);
                        } else {
                            try {
                                throw new IOException();
                            } catch (IOException e) {
                                System.out.println("throws Exception");
                            }
                        }
                    }
                    break;
            }
        }
        return result;
    }
    public static boolean getCondition(String[] massive) {
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabicNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int numberOfRomanNumbers = 0;
        int numberOfArabicNumbers = 0;
        for (int k = 0; k < massive.length; k++ ) {
            for (int l = 0; l < romanNumbers.length; l++) {
                if (massive[k].equals(romanNumbers[l])) {
                    numberOfRomanNumbers = numberOfRomanNumbers + 1;
                }
            }
            for (int m = 0; m < arabicNumbers.length; m++) {
                if (massive[k].equals(arabicNumbers[m])) {
                    numberOfArabicNumbers = numberOfArabicNumbers + 1;
                }
            }
        }
        int multiply = numberOfArabicNumbers*numberOfRomanNumbers;
        int addition = numberOfArabicNumbers+numberOfRomanNumbers;
        return multiply != 0 | addition != 2;
    }
    public static boolean getNumber(String[] massive) {
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabicNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int numberOfRomanNumbers = 0;
        int numberOfArabicNumbers = 0;
        for (int n = 0; n < massive.length; n++ ) {
            for (int p = 0; p < romanNumbers.length; p++) {
                if (massive[n].equals(romanNumbers[p])) {
                    numberOfRomanNumbers = numberOfRomanNumbers + 1;
                }
            }
            for (int q = 0; q < arabicNumbers.length; q++) {
                if (massive[n].equals(arabicNumbers[q])) {
                    numberOfArabicNumbers = numberOfArabicNumbers + 1;
                }
            }
        }
        return numberOfArabicNumbers!=0;
    }
    public static String getRoman(int preresult) {
        String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabic = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0;
        String result = "";
        while (index < roman.length) {
            while (preresult >= arabic[index]) {
                int decade = preresult / arabic[index];
                preresult = preresult % arabic[index];
                for (int r = 0; r < decade; r++) {
                    result = result + roman[index];
                }
            }
            index++;
        }
    return result;
    }
}
