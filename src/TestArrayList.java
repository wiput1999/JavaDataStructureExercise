import java.awt.SystemTray;
import java.util.Scanner;

public class TestArrayList {

  private Scanner scanner = new Scanner(System.in);
  private MyArrayList list = new MyArrayList(scanner);

  private void printMenu() {

    System.out.println("List Menu");
    System.out.println("=========================");
    System.out.println("\t1. Create List");
    System.out.println("\t2. Insert At Front");
    System.out.println("\t3. Insert Before Node");
    System.out.println("\t4. Insert At Last");
    System.out.println("\t5. Delete Node");
    System.out.println("\t6. Traverse");
    System.out.println("\t7. Quit");
    System.out.println("=========================");
    System.out.print("Please Enter Menu Number (1-7) : ");
  }

  private int getAction() {
    printMenu();
    int b = scanner.nextInt();
    return b;
  }

  private String getData() {
    System.out.print("Data : ");
    String data = scanner.next();
    return data;
  }

  public void menu() {
    int choice = getAction();
    String data;

    switch (choice) {
      case 1:
        list.createList();
        break;
      case 2:
        data = getData();
        list.insertFront(data);
        break;
      case 3:
        data = getData();
        list.insertBefore(data);
        break;
      case 4:
        data = getData();
        list.insertLast(data);
        break;
      case 5:
        data = getData();
        list.delete(data);
        break;
      case 6:
        list.traverse();
        break;
      case 7:
        System.exit(0);
        break;
    }
  }

  public static void main(String[] args) {

    TestArrayList obj = new TestArrayList();

    for (; ; ) {
      obj.menu();
    }
  }
}
