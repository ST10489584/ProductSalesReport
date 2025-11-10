import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductSalesApp extends JFrame {
    private JTextArea textArea; //Shows the product sales data
    private JLabel yearsLabel; //Shows the number of years processed
    private ProductSales ps; //ProductSales instance

    public ProductSalesApp() {
        setTitle("Product Sales Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //The sample product sales data with 2 years, 3 products each
        int[] salesData = {300, 150, 700, 250, 200, 600};
        ps = new ProductSales(salesData);

        //The text area inside a scroll pane
        textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea);
        add(scroll, BorderLayout.CENTER);

        //The labels at the bottom for "years processed"
        yearsLabel = new JLabel("Years Processed: ");
        add(yearsLabel, BorderLayout.SOUTH);

        //The panel for buttons, stacked vertically
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton loadBtn = new JButton("Load Product Data"); //load buton
        JButton saveBtn = new JButton("Save Product Data"); //Save button

        loadBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Adding the buttons with space between them
        buttonPanel.add(loadBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); //10px space added
        buttonPanel.add(saveBtn);

        add(buttonPanel, BorderLayout.NORTH);

        //The menu bar
        JMenuBar menuBar = new JMenuBar();

        //File menu with the exit button
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        //The tools menu with Load, Save, Clear options
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadMenu = new JMenuItem("Load Product Data");
        JMenuItem saveMenu = new JMenuItem("Save Product Data");
        JMenuItem clearMenu = new JMenuItem("Clear");
        toolsMenu.add(loadMenu);
        toolsMenu.add(saveMenu);
        toolsMenu.add(clearMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        //The action for loading the data, its used by button and menu
        ActionListener loadAction = e -> {
            textArea.setText(""); // Clear text area
            textArea.append("Total Sales: " + ps.GetTotalSales() + "\n");
            textArea.append("Average Sales: " + (int)ps.GetAverageSales() + "\n"); // now shows 366
            textArea.append("Sales over limit: " + ps.GetSalesOverLimit() + "\n");
            textArea.append("Sales under limit: " + ps.GetSalesUnderLimit() + "\n");
            yearsLabel.setText("Years Processed: " + ps.GetProductsProcessed());
        };

        loadBtn.addActionListener(loadAction);
        loadMenu.addActionListener(loadAction);

        //The action for saving data to the file
        ActionListener saveAction = e -> {
            try (PrintWriter pw = new PrintWriter("data.txt")) {
                pw.println("DATA LOG");
                pw.println("Total Sales: " + ps.GetTotalSales());
                pw.println("Average Sales: " + (int)ps.GetAverageSales());
                pw.println("Sales over limit: " + ps.GetSalesOverLimit());
                pw.println("Sales under limit: " + ps.GetSalesUnderLimit());
                pw.println("Years Processed: " + ps.GetProductsProcessed());
                JOptionPane.showMessageDialog(this, "Data saved to data.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        };

        saveBtn.addActionListener(saveAction);
        saveMenu.addActionListener(saveAction);

        //Clearing the text area and the label
        clearMenu.addActionListener(e -> {
            textArea.setText("");
            yearsLabel.setText("Years Processed: ");
        });

        //To exit the application
        exitItem.addActionListener(e -> System.exit(0));
    }

    //The main method to launch the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductSalesApp().setVisible(true);
        });
    }
}
