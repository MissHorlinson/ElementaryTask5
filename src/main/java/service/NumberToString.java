package service;

public class NumberToString {

    private String[][] num_1_9 =     {{"", "один", "два", "три", "четыре", "пять", "шесть","семь","восемь","девять"},{"","одна","две"}};
    private String[]   num_11_19 =   {"","одиннадцать","двенадцать","тринадцать","четырнадцать", "пятнадцать","шестнадцать","семнадцать","восемнадцать","девятнадцать","двадцать"};
    private String[]   num_10_90 =   {"","десять","двадцать","тридцать","сорок","пятьдесят","шестьдесят", "семьдесят","восемьдесят","девяносто"};
    private String[]   num_100_900 = {"","сто","двести","триста","четыреста","пятьсот","шестьсот","семьсот", "восемьсот","девятьсот"};
    private String[]   forms =       {"тысяча", "тысячи", "тысяч"};

    public String getUnits(int num) {
        String stringView = num_1_9[0][num];
        return stringView;
    }

    public String getDozens(int num, int mode) {
        int dozen = num / 10;
        int unit = num % 10;
        String stringView ;

        if (num > 10 && num < 20) {
            stringView = num_11_19[unit];
        } else if (mode == 1) {
            stringView = num_10_90[dozen] + " " + getUnits(unit);
        } else {
            stringView = num_10_90[dozen] + " " + getUnitForm(unit);
        }
        return stringView;
    }

    public String getHundreds(int num, int mode) {
        int hundreds = num / 100;
        int dozen = num % 100;

        return num_100_900[hundreds] + " " + getDozens(dozen, mode);
    }

    public String getThousands(int num) {
        int thousand = num / 1000;
        int hundreds = num % 1000;
        int form = thousand % 10;

        if (thousand < 10) {
            return getUnitForm(form) + " " + getThousandForm(form) + " " + getHundreds(hundreds,1);
        } else if (thousand >= 10 && thousand <= 20) {
            return getDozens(thousand,1) + " " + forms[2] + " " + getHundreds(hundreds,1);
        }

        else if (thousand > 20 && thousand < 100) {
            return getDozens(thousand, 2) + " " + getThousandForm(form) + " " + getHundreds(hundreds,1);
        } else if (thousand >= 100 && thousand < 1000) {
            return getHundreds(thousand,2) + " " + getThousandForm(form) + " " + getHundreds(hundreds,1);
        }
        return null;
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
