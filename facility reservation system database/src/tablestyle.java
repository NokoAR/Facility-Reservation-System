import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class tablestyle {

    // Method to center text in all columns of the given table
    public static void centerTableText(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    // Method to color text in the "Status" column based on the value
    public static void setRoomTableCellRenderer(JTable table, int statusColumnIndex) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value != null) {
                    String status = value.toString();
                    setText(status);
                    setHorizontalAlignment(SwingConstants.CENTER); // Center the text
                    setFont(getFont().deriveFont(Font.BOLD)); // Make text bold

                    // Set the color based on the status
                    switch (status.toLowerCase()) {
                        case "available":
                            setForeground(new Color(0, 128, 0));
                            break;
                        case "pending":
                            setForeground(new Color(255, 140, 0));
                            break;
                        case "reserved":
                            setForeground(new Color(0, 0, 225));
                            break;
                        case "approved":
                            setForeground(new Color(0, 0, 225));
                            break;
                        case "cancelled":
                            setForeground(Color.RED);
                            break;
                        default:
                            setForeground(Color.BLACK);
                            break;
                    }
                }
            }
        };

        table.getColumnModel().getColumn(statusColumnIndex).setCellRenderer(renderer);
    }
        public static void styleTableHeader(JTable table) {
        JTableHeader header = table.getTableHeader();
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(255, 235, 89)); // Dark blue background (#35408E)
        headerRenderer.setForeground(Color.BLACK); // White text
        headerRenderer.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        header.setDefaultRenderer(headerRenderer);
        header.setFont(new Font("Arial", Font.BOLD, 14)); // Optional: Adjust header font
        header.setOpaque(true);
    }


}
