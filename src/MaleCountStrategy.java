import java.util.List;

class MaleCountStrategy implements StatisticsStrategy {
    @Override
    public void calculateStatistics(List<Student> students) {
        long maleCount = students.stream()
                .filter(student -> student.getGender().equals("М"))
                .count();

        System.out.println("Количество мужчин: " + maleCount);
    }
}