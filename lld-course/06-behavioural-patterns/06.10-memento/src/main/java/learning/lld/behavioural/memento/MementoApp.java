package learning.lld.behavioural.memento;

import learning.lld.behavioural.memento.editor.Editor;
import learning.lld.behavioural.memento.editor.History;

/**
 * Demonstrates Memento: save editor snapshots on a stack, then pop to undo.
 */
public final class MementoApp {

    private MementoApp() {
    }

    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        // Step 1: initial state — persist a snapshot after the first version.
        editor.setText("Version 1");
        history.push(editor.save());

        // Step 2: edit again — snapshot the new version (stack grows).
        editor.setText("Version 2");
        history.push(editor.save());

        // Step 3: edit again — current working state (not pushed yet, matching typical “live” text).
        editor.setText("Version 3");
        System.out.println("Current: " + editor.getText());

        // Undo once — restore from the last pushed memento (“Version 2”).
        editor.restore(history.pop());
        System.out.println("After 1 undo: " + editor.getText());

        // Undo again — restore the earlier memento (“Version 1”).
        editor.restore(history.pop());
        System.out.println("After 2 undo: " + editor.getText());
    }
}
