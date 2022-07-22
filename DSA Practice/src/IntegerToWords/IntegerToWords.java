package IntegerToWords;

public class IntegerToWords {
    public static void main(String[] args) {
        System.out.println(convert(991));
    }

    public static String numberToWords(int num) {

        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};


        String result = "";

        //1234567
        if(String.valueOf(num).length() == 7){


            result += units[(num/1000)] + " thousand ";
            result += units[((num%1000)/100)] + " hundred ";
            result += tens[(num%100/10)] + " ";
            result += units[(num%10)];
        }
        System.out.println(tens[((num/1000)%100)/10]);
        if(String.valueOf(num).length() == 6){
            result += units[(num/100000)] + " Hundred ";
            result += tens[((num/1000)%100)/10] + " ";
            result += units[(num%10)] + " thousand ";
            result += units[((num%1000)/100)] + " hundred ";
            result += tens[(num%100/10)] + " ";
            result += units[(num%10)];
        }
        if(String.valueOf(num).length() == 5){
            result += units[(num/1000)] + " thousand ";
            result += units[((num%1000)/100)] + " hundred ";
            result += tens[(num%100/10)] + " ";
            result += units[(num%10)];
        }
        if(String.valueOf(num).length() == 4){
            result += units[(num/1000)] + " thousand ";
            result += units[((num%1000)/100)] + " hundred ";
            result += tens[((num%100)/10)] + " ";
            result += units[(num%10)];
        }
        if(String.valueOf(num).length() == 3){
            result += units[(num/100)] + " hundred ";
            result += tens[(num%100/10)] + " ";
            result += units[(num%10)];
        }
        if(String.valueOf(num).length() == 2){
            result += tens[(num/10)] + " ";
            result += units[(num%10)];
        }
        if(String.valueOf(num).length() == 1){
            result += units[(num%10)];
        }
        return  result;
    }

    public static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    public static final String[] tens = {
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    public static String convert(final int num) {
        if (num < 0) {
            return "minus " + convert(-num);
        }

        if (num < 20) {
            return units[num];
        }

        if (num < 100) {
            return tens[num / 10] + ((num % 10 != 0) ? " " : "") + units[num % 10];
        }

        if (num < 1000) {
            return units[num / 100] + " Hundred" + ((num % 100 != 0) ? " " : "") + convert(num % 100);
        }

        if (num < 1000000) {
            return convert(num / 1000) + " Thousand" + ((num % 1000 != 0) ? " " : "") + convert(num % 1000);
        }

        if (num < 1000000000) {
            return convert(num / 1000000) + " Million" + ((num % 1000000 != 0) ? " " : "") + convert(num % 1000000);
        }

        return convert(num / 1000000000) + " Billion"  + ((num % 1000000000 != 0) ? " " : "") + convert(num % 1000000000);
    }
}
