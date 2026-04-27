package learning.lld.behavioural.memento.editor;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Caretaker: stores a stack of mementos for undo. It does not interpret memento contents;
 * only the originator ({@link Editor}) should read them via {@link Editor#restore(EditorMemento)}.
 */
public final class History {

    private final Deque<EditorMemento> mementos = new ArrayDeque<>();

    public void push(EditorMemento memento) {
        mementos.addLast(memento);
    }

    public EditorMemento pop() {
        return mementos.removeLast();
    }
}
