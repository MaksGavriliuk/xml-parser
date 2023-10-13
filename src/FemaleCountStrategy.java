import java.util.List;

class FemaleCountStrategy implements StatisticsStrategy {
    @Override
    public void calculateStatistics(List<Student> students) {
        long femaleCount = students.stream()
                .filter(student -> student.getGender().equals("Ж"))
                .count();

        System.out.println("Количество женщин: " + femaleCount);
    }
}