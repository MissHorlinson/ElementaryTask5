package controller;

import model.Number;
import util.*;

public class NumberController {
    private Input  input = new Input();
    private Output output = new Output();
    private Parser parser = new Parser();

    private String[][] num_1_9 =     {{"ноль", "один", "два", "три", "четыре", "пять", "шесть","семь","восемь","девять"},{"","одна","две"}};
    private String[]   num_11_19 =   {"","одиннадцать","двенадцать","тринадцать","четырнадцать", "пятнадцать","шестнадцать","семнадцать","восемнадцать","девятнадцать","двадцать"};
    private String[]   num_10_90 =   {"","десять","двадцать","тридцать","сорок","пятьдесят","шестьдесят", "семьдесят","восемьдесят","девяносто"};
    private String[]   num_100_900 = {"","сто","двести","триста","четыреста","пятьсот","шестьсот","семьсот", "восемьсот","девятьсот"};
    private String[]   forms =       {"тысяча", "тысячи", "тысяч"};

    public void takeParts () {
        output.startInstruction();
        Number model = new Number(parser.toInt(input.getString()));
        int num = model.getNumber();

        if (num == 0) {
            System.out.println(num_1_9[num]);
        } else if (num < 10) {
            System.out.println(getUnits(num));
        } else if (num >= 10 && num < 100) {
            System.out.println(getDozens(num));
        } else if (num >= 100 && num < 1000) {
            System.out.println(getHundreds(num));
        } else if (num >= 1000 && num < 99999) {
            System.out.println(getThousands(num));
        }
    }

    public String getUnits(int num) {
        String stringView = num_1_9[0][num];
        return stringView;
    }

    public String getDozens(int num) {
        int dozen = num / 10;
        int unit = num % 10;
        String stringView;

        if(num > 10 && num < 20) {
            stringView = num_11_19[unit];
        } else {
            stringView = num_10_90[dozen] + " " + getUnits(unit);
        }
        return stringView;
    }

    public String getHundreds(int num) {
        int hundreds = num / 100;
        int dozen = num % 100;

        return num_100_900[hundreds] + " " + getDozens(dozen);
    }

    public String getThousands(int num) {
        int thousand = num / 1000;
        int hundreds = num % 1000;
        int form = thousand % 10;

        if(thousand < 10) {
            return getUnitForm(form) + " " + getThousandForm(form) + " " + getHundreds(hundreds);
        }
        else if(thousand >= 10 && thousand <= 20) {
            return getDozens(thousand) + " " + forms[2] + " " + getHundreds(hundreds);
        }



        else if(thousand > 20 && thousand < 100) {
            return getDozenThousands(thousand) + " " + getThousandForm(form) + " " + getHundreds(hundreds);
        }

        else if(thousand >= 100 && thousand < 1000) {
            return getHundreds(thousand) + " " + getThousandForm(form) + " " + getHundreds(hundreds);
        }
        return null;
    }

    public String getDozenThousands(int num) {
        int dozen = num / 10;
        int unit = num % 10;
        String stringView;

        if(num > 10 && num < 20) {
            stringView = num_11_19[unit];
        } else {
            stringView = num_10_90[dozen] + " " + getUnitForm(unit);
        }
        return stringView;
    }

    public String getUnitForm(int num) {
        if (num == 1) {
            return num_1_9[1][num];
        }
        if (num == 2) {
            return num_1_9[1][num];
        } else
            return num_1_9[0][num];
    }

    public String getThousandForm(int num) {
        if (num == 1) {
            return forms[0];
        } else if (num > 1 && num <5) {
            return forms[1];
        } else {
            return forms[2];
        }
    }
}
