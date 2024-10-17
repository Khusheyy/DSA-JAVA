// oops! in java
// every object follow the blue-print / prototype of its class

// constructor of a class has the same name as the class
// a constructor does not return anything , they are just like methods
// it can be called only "once" when after the obj is created
 class Pen{
      String color;//stores color of the pen
      String type;// ballpoint pen // gel pen
  // this is a function , in class called - method()
    public void write(){
        System.out.println(this.type+" pen is writing for youuu");
    }

    public void display_color(){
        System.out.println(this.color);
        // here "this" keyword - refers to current object in a method
        //is function ko kisne call kiya h (konse object ne call kiya h ) - uska color batao/uska tyoe batao
    }

    public void display_type(){
        System.out.println(this.type);
    }

    Pen() {
        System.out.println("constuctor is called");
    }
}

class Student{
    String name;
    int age;
    int roll_no;
    String subject_chosen;

    public Student(Student s1) {
    }

    public void display_info(){
        System.out.println("Name of the student : "+this.name);
        System.out.println("Age of the student : "+this.age);
        System.out.println("roll number of the student : "+this.roll_no);
        System.out.println("Subject chosen by the student : "+this.subject_chosen);
    }

    Student(String name, int age, int roll_no, String subject_chosen){
        System.out.println("constuctor is called ");
    }
}


public class OOPS {
    public static void main(String[] args) {

        // so this is main function where i'll create objects of class pen
        Pen mypen = new Pen();
        //creating obj mypen of class-pen

        mypen.color = "blue";
        mypen.type = "ball-point";

        mypen.write();
        mypen.display_color();
        mypen.display_type();

        Pen pen2 = new Pen();
        pen2.type = "gel";
        pen2.color = "black";

        pen2.write();
        pen2.display_color();
        pen2.display_type();


        //student class
        Student s1 = new Student("khushi" , 17 , 14 , "computer science");
//        s1.name = "khushi";
//        s1.age = 17;
//        s1.roll_no = 14;
//        s1.subject_chosen = "computer science " ;

       s1.display_info();

       Student s2 = new Student(s1);
       s2.display_info();
    }
}