package AdvanceJavaPractice.generics.interfaces;


/*Task: Okul yönetimi için öğrenci ve öğretmen kayıtlarını
-oluşturan
        -görüntüleyen
        -güncelleyen
        -silen
        Bir program yazınız
*/
public class SchoolManagement {

    public static void main(String[] args) {
       Student student=new Student("Fatih");
       StudentRepo studentRepo=new StudentRepo();
       Teacher teacher=new Teacher("Aksemsettin");
       TeacherRepo teacherRepo=new TeacherRepo();

       studentRepo.add(student);
       studentRepo.update(student);
       studentRepo.get(student);
       studentRepo.delete(student);

       teacherRepo.add(teacher);
       teacherRepo.update(teacher);
       teacherRepo.get(teacher);
       teacherRepo.delete(teacher);
    }
}
