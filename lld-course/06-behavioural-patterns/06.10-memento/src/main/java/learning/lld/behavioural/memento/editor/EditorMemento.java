package learning.lld.behavioural.memento.editor;

/**
 * Memento: immutable snapshot of {@link Editor} state. The caretaker ({@link History}) stores
 * these objects but should not depend on their internals beyond what the originator needs to restore.
 */
public final class EditorMemento {

    private final String text;

    EditorMemento(String text) {
        this.text = text;
    }

    String getText() {
        return text;
    }
}
