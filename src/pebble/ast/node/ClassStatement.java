package pebble.ast.node;

import java.util.List;

public class ClassStatement extends ASTList {
    public ClassStatement(List<ASTree> c) {
        super(c);
    }

    public String name() {
        return ((ASTLeaf) child(0)).getToken().getText();
    }

    public String superClass() {
        if (numChildren() < 3)
            return null;
        else
            return ((ASTLeaf) child(1)).getToken().getText();
    }

    public ClassBody body() {
        return (ClassBody) child(numChildren() - 1);
    }

    public String toString() {
        String parent = superClass();
        if (parent == null)
            parent = "*";
        return "(class " + name() + " " + parent + " " + body() + ")";
    }
}
