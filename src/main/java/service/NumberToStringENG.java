package service;

public class NumberToStringENG {
    private String[] num_1_9 = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String[] num_11_19 = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private String[] num_10_90 = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private String[] forms = {"hundred", "thousand", "million"};

    public String getUnit(int num) {
        return num_1_9[num];
    }

    public String getDozen(int num) {
        int dozen = num / 10;
        int unit = num % 10;
        String stringView;

        if (num > 10 && num < 20) {
            stringView = num_11_19[unit];
        } else {
            stringView = num_10_90[dozen] + " " + getUnit(unit);
        }
        return stringView;
    }

    public String getHundred(int num) {
        int hundred = num / 100;
        int dozen = num % 100;

        if (hundred == 0 ) {
            return "";
        } else {
            return num_1_9[hundred] + " " + forms[0] + " " + getDozen(dozen);
        }
    }

    public String getThousand(int num) {
        int thousand = num / 1000;
        int hundred = num % 1000;

        if (thousand <= 10) {
            return getUnit(thousand) + " " + forms[1] + " " + getHundred(hundred);
        } else if (thousand > 10 && thousand < 100){
            return getDozen(thousand) + " " + forms[1] + " " + getHundred(hundred);
        }  else {
            return getHundred(thousand) + " " + forms[1] + " " + getHundred(hundred);
        }
    }

    public String getMillion(int num) {
        int million = num / 1000000;
        int thousand = num % 1000000;

        if (million <= 10) {
            return getUnit(million) + " " + forms[2] + " " + getThousand(thousand);
        } else if (million > 10 && million < 100) {
            return getDozen(million) + " " + forms[2] + " " + getThousand(thousand);
        } else /*if (million >= 100 && million <= 999999)*/{
            return getHundred(million) + " " + forms[2] + " " + getThousand(thousand);
        }
    }
}
