
public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вульф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder().setName("Антошка")
                .build();
        System.out.println("У мамы " + mom + " есть сын, " + son);
        mom.happyBirthday();
        System.out.println("Маме исполнилось: " + mom.getAge());
    }
}