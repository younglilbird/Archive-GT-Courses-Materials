//I worked on the homework assignment alone, using only course materials.
public class Dog {
    private String name;
    private String type;
    private int age;
    private int visitCounter;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
    public int getAge() {
        return this.age;
    }
    public void setVisitCounter(int visitCounter) {
        if (visitCounter >= 0) {
            this.visitCounter = visitCounter;
        }
    }
    public int getVisitCounter() {
        return this.visitCounter;
    }

    public Dog(String name, String type, int age, int visitCounter) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.visitCounter = visitCounter;
    }
    Dog(String name, String type) {
        this(name, type, 3, 2);
    }
    public String toString() {
        String result1 = "I am a " + this.type + " named " + this.name + " and I am " + this.age + " years old.";
        if (this.visitCounter > 0) {
            return result1 + " I have visited the vet before " + this.visitCounter + " times.";
        } else {
            return result1 + " I have never visited the vet before.";
        }
    }
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Dog other = (Dog) obj;
        boolean compare = this.age == other.age && this.name.equals(other.name);
        return (compare && this.type.equals(other.type) && this.visitCounter == other.visitCounter);
    }
    public void visitVet() {
        if (this.visitCounter <= 0) {
            System.out.println("This is my first visit and I am a little scared!");
        } else {
            System.out.println("I have been here " + this.visitCounter + " times. The vet isn't that scary!");
        }
        this.visitCounter++;
    }
}