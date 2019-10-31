import controller.LanguageController;
import controller.NumberControllerRUS;

public class Main {
    public static void main(String[] args) {
        while (true) {
            LanguageController controller = new LanguageController();
            controller.languageChose();

            if (!controller.shouldContinue())
                break;
        }
    }
}
