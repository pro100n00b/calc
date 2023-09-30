import java.util.List;
import java.util.Scanner;

class calc {
    static List<String> romanDigit = List.of("0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    static List<String> romanTens = List.of("0", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C");

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите значения (a + b,a / b, a * b, a - b):");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            System.out.println(Calc(s));
        }
    }
    public static String Calc(String input) {

        String[] digits = input.split(" ");


        if (digits.length != 3) {
            throw new RuntimeException("Не верный синтаксис");
        }
        String firstDigit = digits[0];
        String operation = digits[1];
        String secondDigit = digits[2];

        boolean romanOrArabicCheck = (Character.isDigit(firstDigit.charAt(0)));
        boolean romanOrArabicCheckSecondDigit = (Character.isDigit(secondDigit.charAt(0)));
        String result;

        if (romanOrArabicCheck && romanOrArabicCheckSecondDigit) {

            result = arabicOperation(firstDigit, secondDigit, operation);

        } else if (!romanOrArabicCheck && !romanOrArabicCheckSecondDigit) {

            result = romanOperation(firstDigit, secondDigit, operation);


        } else {
            throw new RuntimeException("Нельзя использовать два разных вида цисел");
        }

        return result;
    }


    private static String romanOperation(String firstDigit, String secondDigit, String operation) {
        int result;
        int firstIndexDigit = romanDigit.indexOf(firstDigit);
        int secondIndexDigit = romanDigit.indexOf(secondDigit);

        if (secondIndexDigit == -1) {
            throw new RuntimeException("Неверное значение");
        }
        if (firstIndexDigit == -1) {
            throw new RuntimeException("Неверное значение");
        }

        result = getOperationResult(operation, firstIndexDigit, secondIndexDigit);
        if (result <= 0) {
            throw new RuntimeException("Результат не может быть меньше/равен 0");
        }
        if (result == 100){
            return "C";
        }
        String resultString = Integer.toString(result);

        return getRomanFromArabic(resultString);
    }

    private static String getRomanFromArabic(String resultString) {

        if ( resultString.length() != 1){
        String firstRomanFromArabic = romanTens.get(Integer.parseInt(resultString.substring(0,1)));
        String secondRomanFromArabc = romanDigit.get(Integer.parseInt(resultString.substring(1,2)));
        if (firstRomanFromArabic.equals("0")) {
                firstRomanFromArabic = "";
        }

        if (secondRomanFromArabc.equals("0")) {
                secondRomanFromArabc = "";

        }

        return firstRomanFromArabic + secondRomanFromArabc;}
        else {
            return romanDigit.get(Integer.parseInt(resultString.substring(0,1)));
        }

    }
    private static String arabicOperation (String firstDigit, String secondDigit, String operation){
            int result;
            int digitOne = Integer.parseInt(firstDigit);
            int digitTwo = Integer.parseInt(secondDigit);
            if (digitOne > 10) {
                throw new RuntimeException("Число больше десяти");
            }
        if (digitTwo > 10) {
            throw new RuntimeException("Число больше десяти");

        }
        result = getOperationResult(operation, digitOne, digitTwo);
        return String.valueOf(result);
        }

    private static int getOperationResult(String operation, int digitOne, int digitTwo) {
        int result;
        switch (operation) {
            case "-" -> result = digitOne - digitTwo;
            case "+" -> result = digitOne + digitTwo;
            case "/" -> result = digitOne / digitTwo;
            case "*" -> result = digitOne * digitTwo;
            default -> throw new RuntimeException("Неверная операция");
        }
        return result;
    }
}
