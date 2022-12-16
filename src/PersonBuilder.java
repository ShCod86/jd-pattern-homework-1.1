public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() {

        if (name == null) {
            throw new IllegalStateException("Для начала укажите имя");
        } else if (surname == null) {
            throw new IllegalStateException("Вы не указали фамилию");
        } else if (age < 0) {
            throw new IllegalStateException("Возраст не может быть отрицательным");
        }
        return new Person(this);
    }

}
