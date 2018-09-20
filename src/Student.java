public class Student {

    private String naam;
    private int studNr;


    public Student(int studNr){
        this.studNr = studNr;
    }

    public Student(String naam, int studNr){
        if (!naam.equals("")) {
            this.naam = naam;
            this.studNr = studNr;
        } else{
            System.out.println("Name parameter should not be empty!");
        }
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getStudNr() {
        return studNr;
    }

    public void setStudNr(int studNr) {
        this.studNr = studNr;
    }
}
