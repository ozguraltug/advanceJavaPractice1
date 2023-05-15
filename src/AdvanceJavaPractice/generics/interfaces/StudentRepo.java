package AdvanceJavaPractice.generics.interfaces;

public class StudentRepo implements Repository<Student>{
    @Override
    public void add(Student student) {

        System.out.println(student.getName()+" başarıyla kaydedildi");
    }

    @Override
    public void get(Student student) {

        System.out.println(student.getName()+" bulundu");

    }

    @Override
    public void update(Student student) {
        System.out.println(student.getName()+
                " başarılı bir şekilde güncellendi ve yeni isim "
                +student.getName()+" Sultan");

    }

    @Override
    public void delete(Student student) {
        System.out.println(student.getName()+" başarılı bir şekilde silindi");

    }
}
