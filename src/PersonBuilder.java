import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;
    public PersonBuilder(){

    }
    public PersonBuilder(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }



    public PersonBuilder setName(String name) {
        if("".equals(name)) throw new RuntimeException("укажите имя");
        this.name=name;
    return this;}

    public PersonBuilder setSurname(String surname) {
        if ("".equals(surname)) throw new RuntimeException("Укажите фамилию");
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new RuntimeException("Укажите возраст");
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {

        this.address = address;
        return this;
    }


    public Person build() {
        if (name == null || surname == null || age == null || address == null)
            throw new RuntimeException("Не заполнены нужные поля");
        return new Person(name, surname, age, address);
    }
}