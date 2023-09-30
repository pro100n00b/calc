import java.util.List;
import java.util.Scanner;

class calc {
    static List<String> romanDigit = List.of("0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    static List<String> romanTens = List.of("0", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C");

    public static void main(String[] args) {
        calc(String.valueOf(0));
    }
    public static String calc(String input){
            while (true) {
            System.out.println("Введите значения (a + b,a / b, a * b, a - b):");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] nums = s.split(" ");

            if (nums.length != 3) {
                throw new RuntimeException("Не верный синтаксис");
            }
            String firstDigit = nums[0];
            String operation = nums[1];
            String secondDigit = nums[2];
            
            boolean asd = (Character.isDigit(firstDigit.charAt(0)));
            boolean dsa = (Character.isDigit(secondDigit.charAt(0)));
            String result;
            
            if (asd && dsa) {

                result = arabicOperation(firstDigit, secondDigit, operation);

            } else if (!asd && !dsa) {

                result = romanOperation(firstDigit, secondDigit, operation);


            } else {
                throw new RuntimeException("Нельзя использовать два разных вида Чисел");
            }
            System.out.println(result);
        }
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

        switch (operation) {
            case "-" -> result = firstIndexDigit - secondIndexDigit;
            case "+" -> result = firstIndexDigit + secondIndexDigit;
            case "/" -> result = firstIndexDigit / secondIndexDigit;
            case "*" -> result = firstIndexDigit * secondIndexDigit;
            default -> throw new RuntimeException("Неверная операция");
        }
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
        switch (firstRomanFromArabic) {
            case "0":
                firstRomanFromArabic = "";
                break;
        }

        switch (secondRomanFromArabc) {
            case "0":
                secondRomanFromArabc = "";
                break;
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
            switch (operation) {
                case "-" -> result = digitOne - digitTwo;
                case "+" -> result = digitOne + digitTwo;
                case "/" -> result = digitOne / digitTwo;
                case "*" -> result = digitOne * digitTwo;
                default -> throw new RuntimeException("Неверная операция");
            }
            return String.valueOf(result);
        }
    }
