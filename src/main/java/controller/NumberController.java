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
            output.result(num_1_9[0][num]);
        } else if (num < 10) {
            output.result(getUnits(num));
        } else if (num >= 10 && num < 100) {
            output.result(getDozens(num));
        } else if (num >= 100 && num < 1000) {
            output.result(getHundreds(num));
        } else if (num >= 1000 && num < 1000000) {
            output.result(getThousands(num));
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

        if (num > 10 && num < 20) {
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

        if (thousand < 10) {
            return getUnitForm(form) + " " + getThousandForm(form) + " " + getHundreds(hundreds);
        } else if (thousand >= 10 && thousand <= 20) {
            return getDozens(thousand) + " " + forms[2] + " " + getHundreds(hundreds);
        } else if (thousand > 20 && thousand < 100) {
            return getDozenThousands(thousand) + " " + getThousandForm(form) + " " + getHundreds(hundreds);
        } else if (thousand >= 100 && thousand < 1000) {
            return getHundredThousands(thousand) + " " + getThousandForm(form) + " " + getHundreds(hundreds);
        }
        return null;
    }

    public String getDozenThousands(int num) {
        int dozen = num / 10;
        int unit = num % 10;
        String stringView;

        if (num > 10 && num < 20) {
            stringView = num_11_19[unit];
        } else {
            stringView = num_10_90[dozen] + " " + getUnitForm(unit);
        }
        return stringView;
    }

    public String getHundredThousands(int num) {
        int hundreds = num / 100;
        int dozen = num % 100;

        return num_100_900[hundreds] + " " + getDozenThousands(dozen);
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
