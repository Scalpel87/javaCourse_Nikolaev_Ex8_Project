public class User {
    private String login;
    private String password;
    private Status status;
    private String[][] note = new String[][]{{"Empty", "Empty", "Empty", "Empty", "Empty"}, {"EmptyNote", "EmptyNote", "EmptyNote", "EmptyNote", "EmptyNote"}};

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        if (login.equals("admin") && password.equals("admin")) status = Status.ADMIN;
        else    if (login.equals("user") && password.equals("user")) status = Status.USER;
                else    if (login.equals("moderator") && password.equals("moderator")) status = Status.MODERATOR;
                        else throw new MyExeption("Введена неверная пара логин-пароль.");
    }

    public Status getStatus() {
        return status;
    }

    public String[][] getNote() {
        return note;
    }
}
