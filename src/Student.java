import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
class Student {

    private String surname;
    private int age;
    private String gender;

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getInfo() {
        return "\nФамилия: " + this.getSurname() +
                "\nВозраст: " + this.getAge() +
                "\nПол: " + this.getGender();
    }

}