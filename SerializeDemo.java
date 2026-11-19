import java.io.*;

// Class khusus untuk Serialization
class SerializedEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    int age;

    public SerializedEmployee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SerializeDemo {

    // Menyimpan objek ke file
    public static void serialize(SerializedEmployee employee, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename))) {

            oos.writeObject(employee);
            System.out.println("Serialized: " + employee.name);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Membaca objek dari file
    public static SerializedEmployee deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename))) {

            return (SerializedEmployee) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {

        // Membuat objek karyawan
        SerializedEmployee emp1 = new SerializedEmployee("John", 30);
        SerializedEmployee emp2 = new SerializedEmployee("Siti", 27);
        SerializedEmployee emp3 = new SerializedEmployee("Budi", 35);

        // Serialize
        serialize(emp1, "emp1.ser");
        serialize(emp2, "emp2.ser");
        serialize(emp3, "emp3.ser");

        // Deserialize
        SerializedEmployee e1 = deserialize("emp1.ser");
        SerializedEmployee e2 = deserialize("emp2.ser");
        SerializedEmployee e3 = deserialize("emp3.ser");

        // Menampilkan hasil
        if (e1 != null)
            System.out.println("Deserialized: " + e1.name + ", " + e1.age);

        if (e2 != null)
            System.out.println("Deserialized: " + e2.name + ", " + e2.age);

        if (e3 != null)
            System.out.println("Deserialized: " + e3.name + ", " + e3.age);
    }
}