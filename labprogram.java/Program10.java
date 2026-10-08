import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Program10 extends JFrame {

    public Program10() {

        setTitle("Table Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("Table.txt"));

            String header = reader.readLine();

            String line;
            int rows = 1;

            while ((line = reader.readLine()) != null) {
                rows++;
            }

            reader.close();

            reader = new BufferedReader(new FileReader("Table.txt"));

            String firstLine = reader.readLine();

            int columns = firstLine.split(",").length;

            setLayout(new GridLayout(rows, columns, 5, 5));

            // Add header
            String[] headerData = firstLine.split(",");

            for (String value : headerData) {
                add(new JLabel(value, SwingConstants.CENTER));
            }

            // Add remaining rows
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                for (String value : data) {
                    add(new JLabel(value, SwingConstants.CENTER));
                }
            }

            reader.close();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error reading Table.txt: " + e.getMessage()
            );
        }

        setSize(500, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Program10();
    }
}