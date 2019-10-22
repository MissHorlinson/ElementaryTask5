package controller;

import model.Number;
import service.NumberToString;
import util.*;

public class NumberController {
    private Input          input = new Input();
    private Output         output = new Output();
    private Parser         parser = new Parser();
    private NumberToString service = new NumberToString();


    public void takeParts () {
        output.startInstruction();
        Number model = new Number(parser.toInt(input.getString()));
        int num = model.getNumber();

        if (num == 0) {
            output.result("ноль");
        } else if (num < 10) {
            output.result(service.getUnits(num));
        } else if (num >= 10 && num < 100) {
            output.result(service.getDozens(num,1));
        } else if (num >= 100 && num < 1000) {
            output.result(service.getHundreds(num,1));
        } else if (num >= 1000 && num < 1000000) {
            output.result(service.getThousands(num));
        }
    }


}
