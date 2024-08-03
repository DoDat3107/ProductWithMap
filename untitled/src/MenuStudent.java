import java.util.Map;
import java.util.Scanner;

public class MenuStudent {
    private StudentManager studentManager = new StudentManager();
    private Scanner input = new Scanner(System.in);

    public void selectMenu() {
        int choice;
        do {
            System.out.println("========== Quản lý sinh viên ==========");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Tìm kiếm sinh viên theo Id");
            System.out.println("5. Danh sách sinh viên theo tên gần đúng");
            System.out.println("6. Sinh viên có điểm trung bình cao nhất");
            System.out.println("7. Hiển thị tất cả sinh viên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showSearchByIdMenu();
                    break;
                case 5:
                    showSearchByNameMenu();
                    break;
                case 6:
                    showTopStudentMenu();
                    break;
                case 7:
                    showMenuList();
                    break;
                case 0:
                    System.out.println("Đang thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);
    }

    private void showMenuAdd() {
        System.out.print("Nhập tên sinh viên: ");
        String name = input.nextLine();
        System.out.print("Nhập giới tính sinh viên: ");
        String gender = input.nextLine();
        System.out.print("Nhập điểm Toán: ");
        double toan = input.nextDouble();
        System.out.print("Nhập điểm Văn: ");
        double van = input.nextDouble();
        System.out.print("Nhập điểm Anh: ");
        double anh = input.nextDouble();
        Student student = new Student(name, gender, toan, van, anh);
        studentManager.saveStudent(student);
        System.out.println("Sinh viên đã được thêm thành công!");
    }

    private void showMenuEdit() {
        System.out.print("Nhập ID sinh viên cần sửa: ");
        int id = input.nextInt();
        Student student = studentManager.getStudentById(id);
        if (student == null) {
            System.out.println("Sinh viên không tồn tại.");
            return;
        }

        System.out.print("Nhập tên mới (hiện tại: " + student.getName() + "): ");
        String name = input.nextLine();

        System.out.print("Nhập giới tính mới (hiện tại: " + student.getGender() + "): ");
        String gender = input.nextLine();

        System.out.print("Nhập điểm Toán mới (hiện tại: " + student.getToan() + "): ");
        double toan = input.nextDouble();

        System.out.print("Nhập điểm Văn mới (hiện tại: " + student.getVan() + "): ");
        double van = input.nextDouble();

        System.out.print("Nhập điểm Anh mới (hiện tại: " + student.getAnh() + "): ");
        double anh = input.nextDouble();

        Student updatedStudent = new Student(name, gender, toan, van, anh);
        updatedStudent.setId(id);
        studentManager.saveStudent(updatedStudent);
        System.out.println("Thông tin sinh viên đã được cập nhật.");
    }

    private void showMenuRemove() {
        System.out.print("Nhập ID sinh viên cần xóa: ");
        int id = input.nextInt();
        studentManager.deleteStudent(id);
        System.out.println("Sinh viên đã được xóa (nếu tồn tại).");
    }

    private void showSearchByIdMenu() {
        System.out.print("Nhập ID sinh viên cần tìm: ");
        int id = input.nextInt();
        Student student = studentManager.getStudentById(id);
        if (student == null) {
            System.out.println("Sinh viên không tồn tại.");
        } else {
            System.out.println(student);
        }
    }

    private void showSearchByNameMenu() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = input.nextLine();
        Map<Integer, Student> result = studentManager.getStudentByName(name);
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào với tên gần đúng.");
        } else {
            for (Student student : result.values()) {
                System.out.println(student);
            }
        }
    }

    private void showTopStudentMenu() {
        Student topStudent = studentManager.getMaxAvg();
        if (topStudent == null) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("Sinh viên có điểm trung bình cao nhất:");
            System.out.println(topStudent);
        }
    }

    private void showMenuList() {
        Map<Integer, Student> allStudents = studentManager.getAllStudents();
        if (allStudents.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            for (Student student : allStudents.values()) {
                System.out.println(student);
            }
        }
    }
}
