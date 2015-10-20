package core;

/**
 * Created by kuzin on 10/18/2015.
 */
public class User implements Comparable{
    String FIO;
    String country;
    String email;
    String gender;
    String password;
    String birth;
    ConsoleNoteBook consoleNoteBook;

    public ConsoleNoteBook getConsoleNoteBook() {
        return consoleNoteBook;
    }

    public void setConsoleNoteBook(ConsoleNoteBook consoleNoteBook) {
        this.consoleNoteBook = consoleNoteBook;
    }

    public String getEmail() {
        return email;
    }

    public String getFIO() {
        return FIO;
    }

    public String getBirth() {
        return birth;
    }

    public String getCountry() {
        return country;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if (hashCode()==o.hashCode()) return 0;
        return hashCode()>o.hashCode()?1:-1;
    }
}
