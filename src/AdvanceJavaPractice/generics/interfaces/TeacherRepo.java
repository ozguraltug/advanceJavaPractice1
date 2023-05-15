package AdvanceJavaPractice.generics.interfaces;

public class TeacherRepo implements Repository <Teacher>{
    @Override
    public void add(Teacher teacher) {
        System.out.println(teacher.getName()+" başarılı bir şekilde kaydeildi");
    }

    @Override
    public void get(Teacher teacher) {
        System.out.println(teacher.getName()+" bulundu");
    }

    @Override
    public void update(Teacher teacher) {
        System.out.println(teacher.getName()+"başarılı bir şekilde güncellendi ve yeni isim "+teacher.getName()+ " Hoca");
    }

    @Override
    public void delete(Teacher teacher) {
        System.out.println(teacher.getName()+" başarılı bir şekilde güncellendi");
    }
}
