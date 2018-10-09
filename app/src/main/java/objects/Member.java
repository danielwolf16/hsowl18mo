package objects;

public class Member {

    public static int number = 0;

    private int id;
    private String _firstname;
    private String _secondname;

    public Member(String firstname, String secondname) {
        number++;
        _firstname = firstname;
        _secondname = secondname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return _firstname;
    }

    public String getSecondname() {
        return _secondname;
    }
}
