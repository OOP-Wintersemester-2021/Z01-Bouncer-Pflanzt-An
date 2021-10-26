import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;
import de.ur.mi.bouncer.world.fields.FieldColor;

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
        plant();
    }

    /*
     * Zentrale Methode des Programms. Hier wird der Weg über den Boden und das Bepflanzen
     * der Löcher implementiert.
     *
     * Vorbedingung: Bouncer steht ganz links auf dem ersten Feld der Karte und direkt auf dem Boden
     * Ziel: Bouncer steht ganz rechts auf dem letzten Feld vor dem Kartenende direkt auf dem Boden und
     * hat alle Löcher im Boden bepflanzt.
     */
    private void plant() {
        while (bouncer.canMoveForward()) {
           plantIfOnPlotOrMove();
        }
    }

    /*
     * Bouncer prüft, ob er sich auf einem der Löcher befindet. Falls ja, bepflanzt er dieses. Falls nicht,
     * geht er einen Schritt weiter in seine aktuelle Blickrichtung.
     *
     * Vorbedingung: Bouncer steht auf einem Feld direkt über dem Boden und blickt nach Osten.
     * Ziel: Bouncer steht genau ein Feld hinter seiner ursprünglichen Position auf dem Boden und blickt
     * nach Osten. Falls sich unter seiner ursprünglichen Position ein Loch befunden hat, hat er am
     * Boden des Lochs eine neue Blume gepflanzt.
     */
    private void plantIfOnPlotOrMove() {
        if (bouncer.canMoveRight()) {
            enterPlot();
            bouncer.paintField(FieldColor.GREEN);
            exitPlot();
        } else {
            bouncer.move();
        }
    }

    /*
     * Bouncer betritt das Loch unter ihm und wandert bis zu dessen Boden.
     *
     * Vorbedingung: Bouncer steht direkt über einem der Löcher im Boden.
     * Ziel: Bouncer steht auf dem letzten Feld des Lochs und blickt nach Süden.
     */
    private void enterPlot() {
        turnRight();
        while(bouncer.canMoveForward()) {
            bouncer.move();
        }
    }

    /*
     * Bouncer verlässt das Loch, in dem er sich befindet-
     *
     * Vorbedingung: Bouncer steht auf einem der Felder des Lochs und blickt nach Süden.
     * Ziel: Bouncer steht direkt auf dem Boden auf dem Feld direkt östlich vom Loch und blickt nach Osten.
     */
    private void exitPlot() {
        turnAround();
        while(bouncer.canNotMoveRight()) {
            bouncer.move();
        }
        turnRight();
        bouncer.move();
    }

    /*
     * Bouncer dreht sich entgegen dem Uhrzeigersinn um 270°
     *
     * Vorbedingung: -
     * Ziel: Bouncer schaut relativ zur Ausgangslage in eine um 90° nach rechts verschobene Blickrichtung.
     */
    private void turnRight() {
        for (int i = 0; i < 3; i++) {
            bouncer.turnLeft();
        }
    }

    /*
     * Bouncer dreht sich entgegen dem Uhrzeigersinn um 180°.
     *
     * Vorbedingung: -
     * Ziel: Bouncer schaut relativ zur Ausgangslage in die entgegengesetzte Richtung.
     */
    private void turnAround() {
        bouncer.turnLeft();
        bouncer.turnLeft();
    }

    public static void main(String[] args) {
        BouncerLauncher.launch("BouncerPflanztAn");
    }
}
