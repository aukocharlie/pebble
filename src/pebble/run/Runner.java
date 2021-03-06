package pebble.run;

import javassist.gluonj.util.Loader;
import pebble.run.evaluator.ArrayEvaluator;
import pebble.run.evaluator.ClassEvaluator;
import pebble.run.evaluator.ClosureEvaluator;
import pebble.run.evaluator.NativeEvaluator;
import pebble.run.interpreter.ClassInterpreter;

public class Runner {
    public static void main(String[] args) throws Throwable {
        // 通过GluonJ解释器来执行, 它会进行Reviser注解类的替换
        // 它将会调用第一个参数的main方法, 第二个为main方法的参数, 第三个为包含Reviser注解的类对象
        Loader.run(ClassInterpreter.class, args, ClassEvaluator.class,
                ArrayEvaluator.class, NativeEvaluator.class,
                ClosureEvaluator.class);
    }
}
