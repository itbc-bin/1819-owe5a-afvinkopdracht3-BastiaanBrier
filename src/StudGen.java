public class StudGen {

    public static void main(String[] args) {

        Student[] studList = new Student[4];
        String[] names = {"Bastiaan", "Klaas", "Erik", "Violet"};
        int[] studNrs = {603049, 604085, 592435, 607064};
        for (int x = 0; x < 4; x++){
            studList[x] = new Student(names[x], studNrs[x]);
            studList[x].setNaam(names[x]);
            studList[x].setStudNr(studNrs[x]);
            System.out.println("Name of student "+ (x+1) + " is " + studList[x].getNaam());
            System.out.println("Student number of student "+ (x+1) + " is " + studList[x].getStudNr());
        }
    }

}