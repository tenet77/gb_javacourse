package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {

//        1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать
//        это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем
//        загаданное, или меньше. После победы или проигрыша выводится запрос –
//        «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

//        2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
//        "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
//        "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//                сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не
//                угадано, компьютер показывает буквы которые стоят на своих местах.
//                apple – загаданное
//        apricot - ответ игрока
//        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//        Для сравнения двух слов посимвольно, можно пользоваться:
//        String str = "apple";
//        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//        Играем до тех пор, пока игрок не отгадает слово
//        Используем только маленькие буквы

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter game number (1/2): ");
        byte gameNumber = scanner.nextByte();
        scanner.nextLine();

        switch (gameNumber) {
            case 1 -> gameOne();
            case 2 -> {
                        try {
                            gameSecond();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
            }

        }

    }

    private static ArrayList<String> fillWords() throws IOException {

        ArrayList<String> result = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("hw3Worlds.txt"));
        while (reader.ready()) {
            result.add(reader.readLine());
        }
        reader.close();

        return result;
    }

    private static String fillPrompt(String prompt, String word, String guess) {

        char[] promptArray = prompt.toCharArray();
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            int index = 0;
            while ((index = word.indexOf(c, index)) != -1) {
                promptArray[index] = c;
                index++;
            }
        }
        return String.valueOf(promptArray);
    }

    private static void gameSecond() throws IOException {

        ArrayList<String> words = fillWords();

        Scanner scanner = new Scanner(System.in);

        int index = (int) (Math.random() * (words.size() - 1));
        String word = words.get(index);
        String prompt = "___________________________";
        while (true) {
            System.out.print("Enter world: ");
            String guess = scanner.nextLine();
            if (guess.equals(word) || guess.equals("99")) {
                System.out.println("Good job.");
                break;
            }
            prompt = fillPrompt(prompt, word, guess);
            System.out.println(prompt);
        }
    }

    private static void gameOne() {

        Scanner scanner = new Scanner(System.in);

        head:
        while (true) {
            byte number = (byte) (Math.random() * 9);
            byte guess = -1;
            while (guess != number) {
                System.out.print("Enter number: ");
                guess = scanner.nextByte();
                if (guess == 99) {
                    break head;
                } else if (number > guess) {
                    System.out.println("Enter a larger number");
                } else if (number < guess) {
                    System.out.println("Enter a lower number");
                } else System.out.println("You win");
            }
            System.out.print("Would you play again (1 - yes / 0 - no): ");
            guess = scanner.nextByte();
            if (guess == 0) break;
        }
    }
}
