//Написать класс Студент с полями имя, возраст. Создать массив Студентов.
//        Выполнить сортировку по оценке выше 8 баллов и сортировать результат
//        по имени.
//ТОРЯШИЕВ ЖАРГАЛ Б763-2А


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Иван", 7.5));
        students.add(new Student("Мария", 9.2));
        students.add(new Student("Петр", 8.8));
        students.add(new Student("Анна", 6.5));
        students.add(new Student("Дмитрий", 9.5));
        students.add(new Student("Елена", 8.5));
        students.add(new Student("Алексей", 7.0));
        students.add(new Student("Ольга", 9.0));

        StudentFilter gradeFilter = (student) -> student.getGrade() > 8.0;

        StudentSorter nameSorter = (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName());

        System.out.println(" ВСЕ СТУДЕНТЫ ");
        for (Student s : students) {
            System.out.println(s);
        }

        List<Student> excellentStudents = new ArrayList<>();
        for (Student s : students) {
            if (gradeFilter.test(s)) {
                excellentStudents.add(s);
            }
        }

        for (int i = 0; i < excellentStudents.size() - 1; i++) {
            for (int j = 0; j < excellentStudents.size() - i - 1; j++) {
                if (nameSorter.compare(excellentStudents.get(j), excellentStudents.get(j + 1)) > 0) {
                    Student temp = excellentStudents.get(j);
                    excellentStudents.set(j, excellentStudents.get(j + 1));
                    excellentStudents.set(j + 1, temp);
                }
            }
        }

        System.out.println("\n СТУДЕНТЫ С ОЦЕНКОЙ ВЫШЕ 8 БАЛЛОВ (ОТСОРТИРОВАНЫ ПО ИМЕНИ) ");
        if (excellentStudents.isEmpty()) {
            System.out.println("Студентов с оценкой выше 8 баллов нет");
        } else {
            for (Student s : excellentStudents) {
                System.out.println(s);
            }
        }

        System.out.println("\n СТАТИСТИКА ");
        System.out.println("Всего студентов: " + students.size());
        System.out.println("Студентов с оценкой > 8: " + excellentStudents.size());

        System.out.println("\n ПРОВЕРКА РАБОТЫ ФУНКЦИОНАЛЬНЫХ ИНТЕРФЕЙСОВ ");

        System.out.println("Студент Мария имеет оценку > 8: " + gradeFilter.test(students.get(1)));
        System.out.println("Студент Иван имеет оценку > 8: " + gradeFilter.test(students.get(0)));

        System.out.println("Сравнение Мария и Анна по имени: " +
                nameSorter.compare(students.get(1), students.get(3)));
    }
}