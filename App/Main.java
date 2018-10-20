package App;

public class Main {
    public static void main(String[] args){
        Restaurant bar = new Restaurant();

        bar.addTable(4);
        bar.addTable(4);
        bar.addTable(2);
        bar.addTable(3);

        bar.addCommensal(2);
        bar.addCommensal(3);
        bar.addCommensal(4);
        bar.addCommensal(2);
        bar.addCommensal(5);

        bar.freeTable(3);

        System.out.println(bar.toString());

        bar.freeTable(2);
    }
}
