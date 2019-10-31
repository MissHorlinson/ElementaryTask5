package controller;

import service.NumberToStringRUS;
import util.*;

public class NumberControllerRUS {
    private Output            output = new Output();
    private NumberToStringRUS service = new NumberToStringRUS();

    public void takeParts (int num) {
        if (num == 0) {
            output.result("ноль");
        } else if (num < 10) {
            output.result(service.getUnit(num));
        } else if (num >= 10 && num < 100) {
            output.result(service.getDozen(num, 0));
        } else if (num >= 100 && num < 1000) {
            output.result(service.getHundred(num, 0));
        } else if (num >= 1000 && num < 1000000) {
            output.result(service.getThousand(num));
        } else if (num >= 1000000 && num < 1000000000) {
            output.result(service.getMillion(num));
        }
    }


}
