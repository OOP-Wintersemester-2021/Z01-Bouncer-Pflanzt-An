import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class BouncerPflanztAn extends BouncerApp {

    @Override
    public void bounce() {
        loadMap("Field01");
    }

    public static void main(String[] args) {
        BouncerLauncher.launch("BouncerPflanztAn");
    }
}
