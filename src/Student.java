class Student {
    String name;
    int groupNum;
    boolean sex; //false - парень
    private int gpa; //GPA - grade point average (средний балл), не больше 5.
    static int factor = 300, stipend = 1200; //коэффициент для расчет стипендии для девочек. При GPA = 4, стипендия будет такая же как у парней. Стипендия 1200 рублей
    public Student (boolean sex, int gpa, int groupNum){
        this.sex = sex;
        this.gpa = gpa;
        this.groupNum = groupNum;
    }
    public Student (boolean sex, int gpa, int groupNum, String name){
        this.sex = sex;
        this.gpa = gpa;
        this.groupNum = groupNum;
        this.name = name;
    }
    public int getStipend () {
        if (!((gpa <= 5) & (gpa > 0))) {
            System.out.println("Средний балл от 1 до 5.");
            return 0;
        }
        if (sex) {
            return gpa*factor;
        }
        else {
            return (gpa >= 4) ? stipend : 0;
        }
    }
}