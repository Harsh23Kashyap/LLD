package learning.structure.app;

import learning.structure.util.Greeter;

/*
 * CodeStructureApp
 *
 * This class is in package learning.structure.app — a different package than Greeter. The
 * import line tells the compiler where to find Greeter. The JVM still needs both packages on
 * the classpath when you run this class (here: java -cp out learning.structure.app.CodeStructureApp).
 *
 * package — first line of the file; declares which package owns the type. public class —
 * name matches file for public top-level classes. Without import you could still reference
 * Greeter with the fully qualified name learning.structure.util.Greeter, but import keeps
 * call sites short.
 */
public final class CodeStructureApp {

    private CodeStructureApp() {
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        System.out.println(greeter.hello("learner"));
    }
}
