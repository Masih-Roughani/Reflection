import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        interFace proxyInstance = (interFace) Proxy.newProxyInstance(interFace.class.getClassLoader(), new Class<?>[]{interFace.class}, new BestGuy());
        System.out.println(proxyInstance.test1("Masih is here"));
        System.out.println(proxyInstance.test2(12, 21));
        System.out.println(proxyInstance.test3(true, true));
    }
}

class BestGuy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        return switch (method.getName()) {
            case "test1" -> "yo, watch this ->  " + args[0];
            case "test2" -> (int) args[0] + (int) args[1];
            case "test3" -> (boolean) args[0] && (boolean) args[1];
            default -> throw new IllegalStateException("not found : " + method.getName());
        };
    }
}

interface interFace {
    String test1(String name);

    int test2(int a, int b);

    boolean test3(boolean a, boolean b);
}
