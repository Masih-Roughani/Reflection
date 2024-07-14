import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.print("Enter the class name : ");
            Scanner scanner = new Scanner(System.in);
            String className = scanner.nextLine();
            Class<?> clazz = Class.forName(className);
//            Listing the conses
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            System.out.println("Constructors : ");
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
            System.out.print("Enter the constructor numbers to use from 0 to " + (constructors.length - 1) + " : ");
            int cons = scanner.nextInt();
            Constructor<?> selectedConstructor = constructors[cons];
            System.out.print("Enter the first para : ");
            scanner.nextLine();
            String inp1 = scanner.nextLine();
            System.out.print("Enter the second para : ");
            int inp2 = scanner.nextInt();
            Object instance = selectedConstructor.newInstance(inp1, inp2);
//            Showing fields and the values of them
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(instance);
                System.out.println("Field : " + field.getName() + ", Value : " + value);
            }

//            Changing the value
            System.out.print("Name of the field to update : ");
            String fieldNameToUpdate = scanner.next();
            Field fieldToUpdate = clazz.getDeclaredField(fieldNameToUpdate);
            fieldToUpdate.setAccessible(true);
            System.out.print("Enter the new value : ");
//            Thinking it is int
            int newValueString = scanner.nextInt();
            fieldToUpdate.set(instance, newValueString);

//            Showing new value
            Object newValue = fieldToUpdate.get(instance);
            System.out.println("Updated Field : " + fieldNameToUpdate + " , New Value : " + newValue);
//            Calling the method
            System.out.print("Enter the name of the method to call : ");
            scanner.nextLine();
            String methodName = scanner.nextLine();
            Method method = clazz.getDeclaredMethod(methodName, String.class, int.class);
            method.setAccessible(true);
            System.out.print("Enter the first para : ");
            String inp3 = scanner.nextLine();
            System.out.print("Enter the second para : ");
            int inp4 = scanner.nextInt();
            Object result = method.invoke(instance, inp3, inp4);
//            Printing the result
            System.out.print("Method Result : " + result);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}

class FinallyOver {
    String name;
    int money;

    public FinallyOver(String name, int price) {
        this.name = name;
        this.money = price;
    }

    public FinallyOver(String name) {
        this.name = name;
    }

    public FinallyOver(int price) {
        this.money = price;
    }

    private String test1(String a, String b) {
        return a + b;
    }

    private String test2(String a, int b) {
        return a + b;
    }
}