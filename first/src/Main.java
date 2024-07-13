import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Class name : ");
            String className = scanner.nextLine();
            Class<?>[] constructorParamTypes = {String.class, String.class, int.class};
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(constructorParamTypes);
            if (constructor != null) {
                System.out.print("Enter the first parameter of the Object : ");
                String name = scanner.nextLine();
                System.out.print("Enter the second parameter of the Object : ");
                String lastName = scanner.nextLine();
                System.out.print("Enter the third parameter of the Object : ");
                int age = scanner.nextInt();
                Object instance = constructor.newInstance(name, lastName, age);
                Field field = clazz.getDeclaredField("name");
                field.setAccessible(true);
                field.set(instance, name);
                System.out.print("The name is " + field.get(instance) + "\r\n");
                field = clazz.getDeclaredField("age");
                field.setAccessible(true);
                field.set(instance, age);
                System.out.print("The age is " + field.get(instance) + "\r\n");
                field = clazz.getDeclaredField("lastName");
                field.setAccessible(true);
                field.set(instance, lastName);
                System.out.print("The lastname is " + field.get(instance));
            } else {
                System.out.print("Constructor was not found.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class BestPerson {
    private String name;
    private String lastName;
    private int age;

    public BestPerson(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
