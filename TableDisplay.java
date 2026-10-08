import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class TableDisplay extends JFrame {
TableDisplay(String filename) throws IOException {
setTitle("Table Display");
ArrayList<String[]> rows = new ArrayList<>();
BufferedReader br = new BufferedReader(new FileReader(filename));
String line;
int cols = 0;
while ((line = br.readLine()) != null) {
String[] parts = line.split(",");
cols = parts.length;
rows.add(parts);
}
br.close();
setLayout(new GridLayout(rows.size(), cols, 5, 5));
for (String[] row : rows) {
for (String cell : row) {
JLabel label = new JLabel(cell, SwingConstants.CENTER);
label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
add(label);
}
}
setSize(400, 200);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public static void main(String[] args) throws IOException {
new TableDisplay("Table.txt");
}
}