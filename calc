import java.util.Scanner;
import java.util.Arrays;

class calc {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите значения (a + b,a / b, a * b, a - b):");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] nums = s.split(" ");


            int check = nums.length;
            if (check > 3){
                System.out.print("throws Exception");
                break;
            }
            String[] stroka9 = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] stroka10 = {"0", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
            try {
                String firstnum = nums[0];
                String operation = nums[1];
                String secondnum = nums[2];
            }  catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("throws Exception" + "\n");
            break;
             }  catch (StringIndexOutOfBoundsException e) {
            System.out.print("throws Exception" + "\n");
            break;
        }
            String firstnum = nums[0];
            String operation = nums[1];
            String secondnum = nums[2];
            try {


                boolean asd = (Character.isDigit(firstnum.charAt(0)));
                boolean dsa = (Character.isDigit(secondnum.charAt(0)));
            }catch (StringIndexOutOfBoundsException e){
                System.out.print("throws Exception" + "\n");
                break;
            }



            boolean asd = (Character.isDigit(firstnum.charAt(0)));
            boolean dsa = (Character.isDigit(secondnum.charAt(0)));
            if (asd == dsa) {
                if (asd == true) {
                    int num_one = Integer.parseInt(firstnum);
                    int num_two = Integer.parseInt(secondnum);
                    if( num_one  > 10)  {
                        System.out.print("throws Exception");
                        break;
                    }
                    if( num_two  > 10)  {
                        System.out.print("throws Exception");
                        break;
                    }
                    switch (operation) {
                        case "-":
                            int result = num_one - num_two;
                            System.out.println(result);
                    }
                    switch (operation) {
                        case "+":
                            int result = num_one + num_two;
                            System.out.println(result);
                    }

                    switch (operation) {
                        case "/":
                            int result = num_one / num_two;
                            System.out.println(result);
                    }

                    switch (operation) {
                        case "*":
                            int result = num_one * num_two;
                            System.out.println(result);
                    }

                } else if (asd == false) {

                    int index_one = Arrays.asList(stroka9).indexOf(firstnum);
                    int index_two = Arrays.asList(stroka9).indexOf(secondnum);

                    if (index_two == -1){
                       System.out.print("throws Exception");
                       break;
                    }
                    if (index_one == -1){
                        System.out.print("throws Exception");
                        break;
                    }

                    int result = 0;
                    switch (operation) {
                        case "-":
                            result = index_one - index_two;
                            break;
                    }
                    switch (operation) {
                        case "+":
                            result = index_one + index_two;
                            break;
                    }

                    switch (operation) {
                        case "/":
                            result = index_one / index_two;
                            break;
                    }

                    switch (operation) {
                        case "*":
                            result = index_one * index_two;
                            break;
                    }
                    if (result <= 0){
                        System.out.print("throws Exception");
                        break;
                    }
                    String last_result = Integer.toString(result);
                    int tenorone = last_result.length();


                    if (tenorone != 1) {
                        char[] charArray = last_result.toCharArray();

                        int[] intArray = new int[charArray.length];
                        for (int i = 0; i < charArray.length; i++) {
                            intArray[i] = Character.getNumericValue(charArray[i]);
                        }

                        String number = Arrays.asList(stroka10).get(intArray[0]);
                        String anothernum = Arrays.asList(stroka9).get(intArray[1]);
                        switch (number) {
                            case "0":
                                number = "";
                                break;
                        };

                        switch (anothernum) {
                            case "0":
                                anothernum = "";
                                break;
                        };

                        String out_num = number + anothernum;

                        switch (result) {
                            case 100:
                                out_num = "C";
                                break;
                        }

                        System.out.println(out_num);

                    } else {
                        int daj = Integer.parseInt(last_result);
                        String number = Arrays.asList(stroka9).get(daj);
                        System.out.println(number);

                    }
                }
            } else {
                System.out.print("throws Exception" + "\n");
                break;

            }

    }
}
}
