import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the class name : ");
            String className = scanner.nextLine();
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            // Listing all the private fields
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(instance);
                System.out.println("Field name -> " + field.getName() + " -> Value -> " + value);
            }
            System.out.print("Enter the name of the field to update: ");
            String fieldNameToUpdate = scanner.nextLine();
            System.out.print("Enter the new value: ");
            String newValueString = scanner.nextLine();
            // Finding field and changing its value
            Field fieldToUpdate = clazz.getDeclaredField(fieldNameToUpdate);
            fieldToUpdate.setAccessible(true);
            // Finding datatype and putting new value
            if (fieldToUpdate.getType() == int.class) {
                int newValue = Integer.parseInt(newValueString);
                fieldToUpdate.setInt(instance, newValue);
            } else if (fieldToUpdate.getType() == String.class) {
                fieldToUpdate.set(instance, newValueString);
            } else if (fieldToUpdate.getType() == double.class) {
                double newValue = Double.parseDouble(newValueString);
                fieldToUpdate.setDouble(instance, newValue);
            } else if (fieldToUpdate.getType() == boolean.class) {
                boolean newValue = Boolean.parseBoolean(newValueString);
                fieldToUpdate.setBoolean(instance, newValue);
            }
            System.out.print("Updated Field: " + fieldNameToUpdate + ", New Value: " + fieldToUpdate.get(instance));
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}

class BestGuy {
    String name;
    String lastName;
    int age;
    double money;
}
