import java.util.Scanner;
import java.util.stream.IntStream;

public class MyArrayList {

  private String[] list;
  private int count = 0;
  private int size;
  private Scanner scanner;


  MyArrayList(Scanner scanner) {
    this.scanner = scanner;
  }


  public void createList() {

    System.out.print("Enter number of list elements : ");
    int size = scanner.nextInt();

    list = new String[size];

    setSize(size);
  }

  public void insertFront(String data) {
    if (!isFull()) {
      moveForward(0);
      list[0] = data;
      count++;
      System.out.println("Added to list! (" + data + ")");
    } else {
      System.out.println("List is full!");
    }

  }

  public void insertBefore(String data) {
    if (!isFull()) {
      System.out.print("Before : ");
      String toFind = scanner.next();
      int index = getIndexOf(toFind);
      if (index == -1) {
        System.out.println("No this element in list!");
        return;
      }
      moveForward(index);
      list[index] = data;
      count++;
      System.out.println("Added to list! (" + data + ")");
    } else {
      System.out.println("List is full!");
    }
  }

  public void insertLast(String data) {
    if (!isFull()) {
      list[count] = data;
      count++;
      System.out.println("Added to list! (" + data + ")");
    } else {
      System.out.println("List is full!");
    }
  }

  public void delete(String data) {
    if(!isEmpty()) {
      int index = getIndexOf(data);
      if (index == -1) {
        System.out.println("No this element in list!");
        return;
      }
      moveBackward(index);
      count--;
    } else {
      System.out.println("List is empty!");

    }
  }

  private int getIndexOf(String value) {
    for (int i = 0; i < list.length; i++) {
      if (list[i].equals(value)) {
        return i;
      }
    }

    return -1;
  }

  private void moveForward(int index) {
    for (int i = count; i > index; i--) {
      list[i] = list[i - 1];
    }
  }

  private void moveBackward(int index) {
    for (int i = index; i < count - 1; i++) {
      list[i] = list[i + 1];
    }
    list[count - 1] = null;
  }

  public void traverse() {
    System.out.print("Traverse : ");
    IntStream.range(0, count).forEach(i -> System.out.printf("%s ", list[i]));
    System.out.print("\n");

  }

  public boolean isEmpty() {
    return count == 0;
  }

  public boolean isFull() {
    return count == size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
