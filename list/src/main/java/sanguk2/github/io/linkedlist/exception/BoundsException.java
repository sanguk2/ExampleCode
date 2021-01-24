package sanguk2.github.io.linkedlist.exception;

import sanguk2.github.io.linkedlist.enums.Method;

public class BoundsException extends RuntimeException {
    Method occurredMethod;
    int occurredIndex;

    public BoundsException(Method occurredMethod, int occurredIndex) {
        super();

        this.occurredMethod = occurredMethod;
        this.occurredIndex = occurredIndex;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("occurred Method : " + occurredMethod.name() + "\nout of bound : ");

        if (occurredIndex < 0) {
            sb.append("Negative numbers are not selectable");
        } else {
            sb.append("occurred index : " + occurredIndex);
        }

        return sb.toString();
    }
}
