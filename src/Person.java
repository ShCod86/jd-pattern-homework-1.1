import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;

    /* Не понимаю зачем здесь кострукторы, если мы будем использовать билдер */
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.city = personBuilder.city;
    }

    public boolean hasAge() {
        return this.age >= 0;
    }

    public boolean hasAddress() {
        return this.city != null;
    }

    public void setCity(String city) {
        if (!hasAddress()) {
            this.city = city;
        }
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setCity(this.city);
    }

    @Override
    public String toString() {
        return "Person " +
                "имя '" + name + '\'' +
                ", фамилия '" + surname + '\'' +
                ", возраст " + age +
                ", город проживания '" + city + '\'';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }
}
