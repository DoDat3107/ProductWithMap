public class Student {
    private int id;
    private String name;
    private String gender;
    private double toan;
    private double van;
    private double anh;
    private static int nextID = 1;

    public Student(String name, String gender, double toan, double van, double anh) {
        this.id = nextID++;
        this.name = name;
        this.gender = gender;
        this.toan = toan;
        this.van = van;
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getVan() {
        return van;
    }

    public void setVan(double van) {
        this.van = van;
    }

    public double getAnh() {
        return anh;
    }

    public void setAnh(double anh) {
        this.anh = anh;
    }

    public double getAvg() {
        return (toan + van + anh) / 3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", toan=" + toan +
                ", van=" + van +
                ", anh=" + anh +
                '}';
    }
}
