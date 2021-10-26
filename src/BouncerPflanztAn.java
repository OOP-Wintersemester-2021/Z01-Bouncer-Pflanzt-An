import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;

/*
 * Bouncers Aufgabe besteht darin, in alle vorbereiteten Löcher auf der Wiese neue Blumen
 * einzupflanzen (= das Feld am Boden des Lochs grün einzufärben).
 *
 * Ausgangslage: Bouncer startet am linken Bildschirmrand und steht direkt auf dem Boden. Im
 * Boden sind in Abständen von mindestens einem Feld beliebig viele, beliebig tiefe Löcher. Weder
 * auf dem ersten noch auf dem letzten Feld des Bodens befindet sich ein Loch.
 *
 * Ziel: Bouncer steht ganz rechts am Bildschirmrand auf dem letzten Feld vor dem Ende der Karte. Die
 * untersten Felder aller Löcher sind jetzt grün eingefärbt.
 */

public class BouncerPflanztAn extends BouncerApp {

    @Override
    public void bounce() {
        // Weitere Karten mit ähnlichen aber nicht identischen Welten: Field02 und Field03
        loadMap("Field01");
    }

    public static void main(String[] args) {
        BouncerLauncher.launch("BouncerPflanztAn");
    }
}
