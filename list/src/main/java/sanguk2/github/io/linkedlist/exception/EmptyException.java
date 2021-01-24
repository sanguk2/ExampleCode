package sanguk2.github.io.linkedlist.exception;

import sanguk2.github.io.linkedlist.enums.Method;

public class EmptyException extends RuntimeException {
    Method occurredMethod;

    public EmptyException (Method occurredMethod) {
        this.occurredMethod = occurredMethod;
    }

    @Override
    public String toString() {
        return "occurred Method : " + occurredMethod.name() + "\nhead is null";
    }
}
