package controller;

import service.NumberToStringENG;
import util.*;

public class NumberControllerENG {
    private Output            output = new Output();
    private NumberToStringENG service = new NumberToStringENG();

    public void takeParts (int num) {
        if (num == 0) {
            output.result("zero");
        } else if (num < 10) {
            output.result(service.getUnit(num));
        } else if (num >= 10 && num < 100) {
            output.result(service.getDozen(num));
        } else if (num >= 100 && num < 1000) {
            output.result(service.getHundred(num));
        } else if (num >= 1000 && num < 1000000) {
            output.result(service.getThousand(num));
        } else if (num >= 1000000 && num < 2000000000) {
            output.result(service.getMillion(num));
        }
    }


}
