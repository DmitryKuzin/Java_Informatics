package core;

/**
 * Created by dmitriy on 07.09.15.
 */
public class Note implements Comparable<Note>{
    public Note(String FIO,String birthday,String phone,String email,String address){
        this.FIO=FIO;
        this.phone=phone;
        this.birthday=birthday;
        this.email=email;
        this.address=address;
    }
    public Note(){}

    @Override
    public int hashCode() {
        return FIO.hashCode();
    }

    String FIO;
    String birthday;
    String phone;
    String email;
    String address;

    public String getFIO() {
        return FIO;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int compareTo(Note o) {
        return FIO.compareTo(o.FIO);
    }
}
