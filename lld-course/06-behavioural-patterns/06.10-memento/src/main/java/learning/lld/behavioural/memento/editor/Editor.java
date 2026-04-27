package learning.lld.behavioural.memento.editor;

/**
 * Originator: owns the mutable document state and knows how to snapshot/restore itself via mementos.
 */
public final class Editor {

    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /** Captures the current text into a memento (does not change editor state). */
    public EditorMemento save() {
        return new EditorMemento(text);
    }

    /** Restores editor text from a previously saved memento. */
    public void restore(EditorMemento memento) {
        this.text = memento.getText();
    }
}
