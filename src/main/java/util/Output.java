package util;

public class Output {

    public void startEng() {
        System.out.println("Enter the number");
    }

    public void notNumber() { System.out.println("Not valid data"); }

    public void languageInfo() { System.out.println("Chose the language\n 1. ENG\n 2. RUS\n------------------"); }

    public void nonexistentChoice() { System.out.println("No this language.");}

    public void continueRequest()  { System.out.println("Please enter y - yes, if you want to try again"); }

    public void result(String string) { System.out.println(string); }
}
