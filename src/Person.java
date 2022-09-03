import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected String name;
    protected String surname;
    private OptionalInt age;
    private String address;

    public Person(String name, String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = null;
    }

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = null;
        this.address = null;
    }

    public boolean hasAge() {
        return this.age.isPresent();
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return (hasAge() ? age.getAsInt() : 0);
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(this.age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person[name=").append(name).append(", surname=")
                .append(surname).append(",age=").append(age).append(",address ").append(address);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(name, surname, age, address);
    }
}

