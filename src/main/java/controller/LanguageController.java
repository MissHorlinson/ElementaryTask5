package controller;

import model.Number;
import util.*;

public class LanguageController {

    private Input               input = new Input();
    private Output              output = new Output();
    private Validator           validator = new Validator();
    private NumberControllerENG eng = new NumberControllerENG();
    private NumberControllerRUS rus = new NumberControllerRUS();

    public void languageChose() {
        output.startEng();
        Number model = new Number(getNumber());

        while (true) {
            output.languageInfo();
            String lang = validator.language(input.getString());

            if (lang.equals("ENG")) {
                eng.takeParts(model.getNumber());
                break;
            }
            if (lang.equals("RUS")) {
                rus.takeParts(model.getNumber());
                break;
            }

            output.nonexistentChoice();
            if (!shouldContinue())
                break;
        }
    }

    public int getNumber() {
        String number = input.getString();
        while (!validator.isValid(number)) {
            output.notNumber();
            number = input.getString();
        }
            return validator.getInt(number);
    }

    public boolean shouldContinue() {
        output.continueRequest();
        return validator.continueRequest(input.getString());
    }
}
