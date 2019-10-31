package service;

import java.util.Arrays;

public class NumberToStringRUS {

    private String[][] num_1_9 =     {{"", "один", "два", "три", "четыре", "пять", "шесть","семь","восемь","девять"},{"","одна","две"}};
    private String[]   num_11_19 =   {"","одиннадцать","двенадцать","тринадцать","четырнадцать", "пятнадцать","шестнадцать","семнадцать","восемнадцать","девятнадцать"};
    private String[]   num_10_90 =   {"","десять","двадцать","тридцать","сорок","пятьдесят","шестьдесят", "семьдесят","восемьдесят","девяносто"};
    private String[]   num_100_900 = {"","сто","двести","триста","четыреста","пятьсот","шестьсот","семьсот", "восемьсот","девятьсот"};
    private String[][] forms =       {{"тысяча", "тысячи", "тысяч"}, {"миллион", "миллиона", "миллионов"}};


    public String getUnit(int num) {
        return num_1_9[0][num];
    }

    public String getDozen(int num, int mode) {
        int dozen = num / 10;
        int unit = num % 10;

        if (num > 10 && num < 20) {
            return num_11_19[unit];
        } else if (mode == 0) {
            return num_10_90[dozen] + " " + getUnit(unit);
        } else {
            return num_10_90[dozen] + " " + getUnitForm(unit);
        }
    }

    public String getHundred(int num, int mode) {
        int hundreds = num / 100;
        int dozen = num % 100;

        return num_100_900[hundreds] + " " + getDozen(dozen, mode);
    }

    public String getThousand(int num) {
        int thousand = num / 1000;
        int hundreds = num % 1000;

        int form = thousand % 100;

        if (thousand < 10) {
            return getUnitForm(form) + " " + getThousandForm(form) + " " + getHundred(hundreds, 0);
        } else if (thousand >= 10 && thousand <= 20) {
            return getDozen(thousand, 0) + " " + forms[0][2] + " " + getHundred(hundreds, 0);
        } else if (thousand > 20 && thousand < 100) {
            return getDozen(thousand, 1) + " " + getThousandForm(form) + " " + getHundred(hundreds, 0);
        } else  {
            return getHundred(thousand, 1) + " " + getThousandForm(form) + " " + getHundred(hundreds, 0);
        }
    }

    public String getMillion(int num) {
        int million = num / 1000000;
        int thousand = num % 1000000;

        int form = million % 100;

        if (million < 10) {
            return getUnit(million) + " " + getMillionForm(form) + " " + getThousand(thousand);
        } else if (million >= 10 && million <= 20) {
            return getDozen(million, 0) + " " + forms[1][2] + " " + getThousand(thousand);
        } else if (million > 20 && million < 100) {
            return getDozen(million, 0) + " " + getMillionForm(form) + " " + getThousand(thousand);
        } else if (million >= 100 && million < 2000){
            return getHundred(million, 0) + " " + getMillionForm(form) + " " + getThousand(thousand);
        }

        return null;
    }

    public String getUnitForm(int num) {
        if (num == 1) {
            return num_1_9[1][num];
        }
        if (num == 2) {
            return num_1_9[1][num];
        } else {
            return num_1_9[0][num];
        }
    }

    public String getThousandForm(int num) {
        if(num >10 && num < 20) {
            return forms[0][2];
        }

        int form = num % 10;
        if (form == 1) {
            return forms[0][0];
        } else if (form > 1 && form <5) {
            return forms[0][1];
        } else {
            return forms[0][2];
        }
    }

    public String getMillionForm(int num) {
        if(num > 10 && num < 20) {
            return forms[1][2];
        }

        int form = num % 10;
        if (form == 1) {
            return forms[1][0];
        } else if (form > 1 && form <5) {
            return forms[1][1];
        } else {
            return forms[1][2];
        }
    }
}
