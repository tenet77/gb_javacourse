package lesson1;

public class homework {

    public static float calculate(float a, float b, float c, float d) {
//      3. Вычисление выражения
        return a * (b + (c / d));
    }

    public static boolean sumInInterval(int a, int b) {
//      4. Проверка интервала
        int sum = a + b;
        return (sum >= 10 && sum <=20);
    }

    public static void isPositive(int a) {
//      5. Проверка положительного числа
        if (a>=0) {
            System.out.println(a + " is positive");
        } else {
            System.out.println(a + " is negative");
        }
    }

    public static boolean isNegative(int a) {
//      6. Проверка отрицательного
        return (a<0);
    }

    public static void sayHello(String name) {
//      7. Вывести имя
        System.out.println("Привет, " + name + "!");
    }

    public static boolean isLeap(int y) {
//      8. Високосный год
        boolean result = false;

        if (y % 4 == 0 && y % 100 != 0) {
            result = true;
        } else if (y % 4 == 0 && y % 100 == 0 && y % 400 == 0) {
            result = true;
        }

        return result;
    }

    public static void main(String[] args) {
//        1. Создать метод main()
//        2. Инициализировать переменные

        byte b = 127;
        short sh = 32767;
        int i = 2_147_483_647;
        long l = 2000000000L;

        float f = 0.333f;
        double d = 0.5555;

        char c = 'a';

        boolean bool = true;

        System.out.println(calculate(1, 2, 3,4));
        System.out.println(sumInInterval(3, 18));
        isPositive(-1);
        System.out.println(isNegative(-9));
        sayHello("Yorik");
        System.out.println("2000 - " + isLeap(2000));

    }
}
