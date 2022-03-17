import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;
    private static User current;
    private static SimpleNote simpleNote = new SimpleNote();
    private static DateNote dateNote = new DateNote();

    public static void main(String[] args) throws IOException {
        User user = new User("user", "user");
        User admin = new User("admin", "admin");
        User moderator = new User("moderator", "moderator");
        current = login();
        do {
            switch (menu()) {
                case 1: User temp = login();
                        switch (temp.getStatus()) {//Тут загружаем данные пользователей
                            case ADMIN: current = admin;
                            case MODERATOR: current = moderator;
                            case USER: current = user;
                        }
                        break;
                case 2: if (current.getStatus() == Status.ADMIN || current.getStatus() == Status.MODERATOR) createNote();
                        else System.out.println("У вас недостаточно прав для создания заметки");
                        break;
                case 3: System.out.println("Введите ключевое слово для поиска");
                        String searchWorld = reader.readLine();
                        simpleNote.searchNote(searchWorld);
                        dateNote.searchNote(searchWorld);
                        break;
                case 4: reader.close();
                        System.exit(0);
                        break;
            }
            switch (current.getStatus()) {//Тут сохраняем данные пользователей
                case ADMIN: admin = current;
                case MODERATOR: moderator = current;
                case USER: user = current;
            }
        }
        while(true);
    }
    public static User login() throws IOException {
        System.out.println("Введите логин");
        String login = reader.readLine();
        System.out.println("Введите пароль");
        String password = reader.readLine();
        return new User(login, password);
    }
    public static int menu() throws IOException {
        int select = 0;
        do {
            System.out.println("\nВведите цифру, соответствующую пункту меню:\n" +
                    "1. Выполнить вход под другим пользователем.\n" +
                    "2. Создание новой заметки.\n" +
                    "3. Поиск заметки по названию.\n" +
                    "4. Выход из приложения.\n");
            select = Integer.parseInt(reader.readLine());

        } while ((select < 1) && (select > 4));
        return select;
    }
    public static void createNote() throws IOException {
        int selectN = 0;
        do{
            System.out.println("Для создания простой заметки введите 1. Для создания заметки с датой введите 2.");
            selectN = Integer.parseInt(reader.readLine());
        } while((selectN < 1) || (selectN > 2));
        System.out.println("Введите заголовок заметки");
        String noteHead = reader.readLine();
        System.out.println("Введите заметку");
        String noteString = reader.readLine();
        String tempHead[];
        String tempNote[];
        boolean flag = false;
        switch (selectN) {
            case 1: tempHead = simpleNote.getHead();
                    tempNote = simpleNote.getNote();
                    for (int i = 0; i < 5; i++) {
                        //System.out.println(tempHead[i] + " " + tempHead[i].equals("EmptyHead"));
                        if (tempHead[i].equals("EmptyHead")) {
                            tempHead[i] = noteHead;
                            tempNote[i] = noteString;
                            simpleNote.setHead(tempHead);
                            simpleNote.setNote(tempNote);
                            System.out.println(tempHead);
                            System.out.println(tempNote);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) System.out.println("Пустые простые заметки закончились. Попробуйте выбрать заметки с датой.");
                    break;
            case 2: tempHead = dateNote.getHead();
                    tempNote = dateNote.getNote();
                    for (int i = 0; i < 5; i++) {
                        if (tempHead[i].substring(0, 9).equals("EmptyHead")) {
                            tempHead[i] = noteHead + " " + new Date();
                            tempNote[i] = noteString;
                            dateNote.setHead(tempHead);
                            dateNote.setNote(tempNote);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) System.out.println("Пустые заметки с датой закончились. Попробуйте выбрать простые заметки.");
                    break;
        }
    }
}
