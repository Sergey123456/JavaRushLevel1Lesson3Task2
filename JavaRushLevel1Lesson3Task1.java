import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JavaRushLevel1Lesson3Task1 {

    public static Scanner sc = new Scanner(System.in);
    public static Random rnd = new Random();

    public static void main(String[] args) {
		String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
				  "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
				  "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
		guessTheWord(words);
    }

   public static void guessTheWord(String[] ar) {
		System.out.println("Компьютер загадал СЛОВО из списка ниже, постарайтесь угадать слово!!!");
		System.out.println(Arrays.toString(ar));
		String n;
		int index = rnd.nextInt(ar.length);
		String word = ar[index];
		System.out.println("Загадано слово: " + word); // ЗАГАДАННОЕ СЛОВО
		boolean quit = false;
		do {
			System.out.print("Введите слово: "); // ЗАГАДАННОЕ СЛОВО
			n = sc.nextLine();
			if (n.equals(word)) {
				 System.out.println("Вы угадали! Поздравляем! Приходите ещё!");
				 quit = true;
			} else {
				System.out.println("Вы не угадали! Соболезнуем!");
				System.out.print("Угаданные буквы: ");
				int	wordLenght	= word.length(),
						nLenght		= n.length();
				for (int i = 0; i < 15; i++) {
					System.out.print(i < wordLenght && i < nLenght && word.charAt(i) == n.charAt(i) ? word.charAt(i) : "#");
				}
				System.out.println();
				quit = quitMenu();
			}
      } while (!quit);
   }

	private static boolean quitMenu() {
		String	n;
		boolean	quit = false;
		
		do {
			System.out.println("Хотите попробовать ещё раз? (y/n)");
			n = sc.nextLine();

			switch (n) {
				case "y" :
					quit = false;
					break;
				case "n":
					quit = true;
					break;
				default :
					System.out.println("Вы ввели некорректное значение!");
			}
		} while (!(n.equals("y") || n.equals("n")));
		
		return quit;
	}
}
