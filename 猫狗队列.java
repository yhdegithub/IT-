import java.util.*;

public class Main {
    static Queue<Cat> cats;
    static Queue<Dog> dogs;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().toString());
        Main m = new Main();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().toString().trim();

            if (line.equals("pollDog")) {
                m.pollDogs();
            } else if (line.equals("pollCat")) {
                m.pollCats();
            } else if (line.equals("pollAll")) {
                m.pollAll();
            } else if (line.equals("isEmpty")) {
                System.out.println(m.isEmpty());
            } else if (line.equals("isDogEmpty")) {
                System.out.println(m.isDogEmpty());
            } else if (line.equals("isCatEmpty")) {
                System.out.println(m.isCatEmpty());
            } else {
                String[] ss = line.split(" ");
                int num = Integer.parseInt(ss[2]);
                if (ss[1].equals("cat")) {
                    m.cats.offer(new Cat(num, count++));
                } else {
                    m.dogs.offer(new Dog(num, count++));
                }

            }


        }
    }

    // 判断狗为空
    public String isDogEmpty() {
        if (dogs.isEmpty())
            return "yes";
        else
            return "no";
    }

    // 判断猫为空
    public String isCatEmpty() {
        if (cats.isEmpty())
            return "yes";
        else
            return "no";
    }

    // 判断猫为空 ，狗为为空
    public String isEmpty() {
        if (cats.isEmpty() && dogs.isEmpty())
            return "yes";
        else
            return "no";
    }

    // 清空猫队列
    public void pollCats() {
        while (!cats.isEmpty()) {
            System.out.println(cats.poll());
        }
    }

    // 清空狗队列
    public void pollDogs() {
        while (!dogs.isEmpty()) {
            System.out.println(dogs.poll());
        }
    }

    // 清空所有猫狗队列
    public void pollAll() {
        while (!cats.isEmpty() && !dogs.isEmpty()) {
            if (cats.peek().cnt <= dogs.peek().cnt)
                System.out.println(cats.poll());
            else
                System.out.println(dogs.poll());

        }
        while (!cats.isEmpty()) {
            System.out.println(cats.poll());
        }
        while (!dogs.isEmpty()) {
            System.out.println(dogs.poll());
        }


    }

    Main() {
        this.cats = new LinkedList<>();
        this.dogs = new LinkedList<>();
    }

    /**
     * 设置一个猫狗类，主要用使用id标识不用序号， cnt标识不同入队时间
     */
    // 设置一个猫类
    static class Cat {
        String s = "cat";
        int id;
        int cnt;

        Cat(int id, int cnt) {
            this.id = id;
            this.cnt = cnt;
        }

        public String toString() {
            return s + " " + id;
        }
    }

    //  设置一个狗类
    static class Dog {
        String s = "dog";
        int id;
        int cnt;

        Dog(int id, int cnt) {
            this.id = id;
            this.cnt = cnt;
        }

        public String toString() {
            return s + " " + id;
        }
    }
}