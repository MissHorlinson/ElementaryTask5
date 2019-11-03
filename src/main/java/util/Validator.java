package util;

public class Validator {

    public boolean isValid(String str) {
        if (isNumber(str)) {
            if (getInt(str) <= 0) {
                return false;
            } else
                return true;
        } else {
            return false;
        }
    }

    public boolean isNumber(String str) { return str.matches("\\d+"); }

    public int getInt(String str) {
        return Integer.parseInt(noTub(str));
    }

    public String noTub(String str) {
        return str.replaceAll("\\s+", "");
    }

    public String language(String lang) {
        lang = lang.replaceAll("\\s+", "").toUpperCase();
        if (lang.contains("RUS")) {
            return "RUS";
        } else if (lang.contains("ENG")) {
            return "ENG";
        } else {
            return lang;
        }
    }

    public boolean continueRequest(String answer) {
        answer = answer.replaceAll("\\s+", "").toUpperCase();
        if(answer.equals("Y") || answer.equals("YES"))
            return true;
        else
            return false;
    }
}
