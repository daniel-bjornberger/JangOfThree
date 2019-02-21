package guestbook;

public class Visitors {
    private String firstName;
    private String messeges;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMesseges() {
        return messeges;
    }

    public void setMesseges(String messeges) {
        this.messeges = messeges;
    }

    public Visitors(String firstName, String messeges){
        this.firstName=firstName;
        this.messeges=messeges;
    }

}
