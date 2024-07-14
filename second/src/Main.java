import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.print("Enter the class name : ");
            Scanner scanner = new Scanner(System.in);
            String className = scanner.nextLine();
            // Get the class
            Class<?> clazz = Class.forName(className);
            // Finding the cons and making a new object
            Constructor<?> constructor = clazz.getConstructor();
            Object instance = constructor.newInstance();
            // Listing the methods
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method : " + method.getName() + "\r\nParameter type : ");
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.println(parameter.getType().getName() + " -> " + parameter.getName());
                }
                System.out.println("Return type : " + method.getReturnType().getName());
            }
            System.out.print("Enter the method name : ");
            String methodName = scanner.nextLine();
            Class<?>[] methodParamTypes = {String.class, String.class, int.class};
            System.out.print("Enter the first para : ");
            String inp1 = scanner.nextLine();
            System.out.print("Enter the second para : ");
            String inp2 = scanner.nextLine();
            System.out.print("Enter the third para : ");
            int inp3 = scanner.nextInt();
            Object[] methodParams = {inp1, inp2, inp3};
//            Finding the method
            Method methodToInvoke = clazz.getDeclaredMethod(methodName, methodParamTypes);
            methodToInvoke.setAccessible(true);
            Object result = methodToInvoke.invoke(instance, methodParams);
            System.out.println("Result of method " + methodName + ": " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class BestGuy {
    String name = "Masih";
    String lastName = "Roughani";
    int age = 19;

    public BestGuy() {
    }

    private String Test1(String name, String lastNme, int age) {
        return this.name + "-" + name + " <-> " + this.lastName + "-" + lastNme + " <-> " + (this.age + age);
    }

    private void Test2(int a, int b, String c) {
    }
}