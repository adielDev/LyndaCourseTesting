package adiel.lyndacoursetesting;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * Created by recntrek7 on 06/02/17.
 */

public class RuleExample implements MethodRule {
    @Override
    public Statement apply(Statement base, FrameworkMethod method, Object target) {
        final String className = method.getMethod().getDeclaringClass().getSimpleName();
        final String methodName = method.getName();

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println(String.format("rule example execting %s method is %s ",className,methodName));
               // this.evaluate();
               // System.out.println(String.format("rule example done execting %s method is %s ",className,methodName));
            }
        };
    }
}
