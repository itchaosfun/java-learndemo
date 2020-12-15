package project;


import java.lang.reflect.Field;

public class CopyUtils {
    public static void copyProperties(Object src, Object target){

        Field[] srcFields = src.getClass().getDeclaredFields();
        Class<?> targetClass = target.getClass();

        for (Field field : srcFields) {

            try {
                String name = field.getName();
                Class<?> srcFieldType = field.getType();
                Field targetField = targetClass.getDeclaredField(name);
                Class<?> targetFieldType = targetField.getType();
                field.setAccessible(true);
                targetField.setAccessible(true);
                if (srcFieldType.getSimpleName().equals(targetFieldType.getSimpleName())){
                    System.out.println("fileName = " + name + ", value = " + field.get(src));
                    targetField.set(target, field.get(src));
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        copyProperties(a,b);

        System.out.println("a = " + a.toString() + ",, b = " + b.toString());
    }
}
