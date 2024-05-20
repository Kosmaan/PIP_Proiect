package ro.tuiasi.ac.Proiect_PIP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Interfata {
	public void initInterface() {
		Citire c = new Citire();
		c.citireProfesori();
		
		Scriere s = new Scriere();
		
		JFrame frame = new JFrame("Completare fisa doc ! ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500); // Mărimea ferestrei
		frame.setLayout(new BorderLayout());

// Crearea primului panel pentru secțiunea stângă
// Crearea primului panel pentru secțiunea stângă
// Crearea primului panel pentru secțiunea stângă
		JPanel panelStanga = new JPanel(new GridBagLayout()); // Utilizăm GridBagLayout
		GridBagConstraints gbcStanga = new GridBagConstraints();
		gbcStanga.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
		gbcStanga.weightx = 1; // Distribuie spațiul pe orizontală
		gbcStanga.insets = new Insets(10, 60, 10, 60); // Adăugăm padding mai mare

// Adăugăm combobox-uri pentru secțiunea stângă
		String[] itemsStanga = { "Nume Profesor", "Functia", "Asistent" };
		String[] profi = { "lavinia", "cosmin", "alex" };
		for (int i = 0; i < itemsStanga.length; i++) {
			JComboBox comboBox = new JComboBox<>(c.profesori);
			comboBox.setRenderer(new MyComboBoxRenderer(itemsStanga[i]));
			comboBox.setSelectedIndex(-1);
			comboBox.setFont(new Font("Arial", Font.PLAIN, 14)); // Personalizăm fontul
			comboBox.setPreferredSize(new Dimension(300, 70)); // Mărim butonul
			gbcStanga.gridy = i; // Setăm poziția verticală
			panelStanga.add(comboBox, gbcStanga);
			comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String selectedValueProfesori = (String) comboBox.getSelectedItem();
					s.replaceText("numeProfesor", selectedValueProfesori);
			        System.out.println("Selected Value: " + selectedValueProfesori);
				}
			});
		}
// Crearea celui de-al doilea panel pentru secțiunea dreaptă
		JPanel panelDreapta = new JPanel(new GridBagLayout()); // Utilizăm GridBagLayout
		GridBagConstraints gbcDreapta = new GridBagConstraints();
		gbcDreapta.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
		gbcDreapta.weightx = 1; // Distribuie spațiul pe orizontală
		gbcDreapta.insets = new Insets(10, 60, 10, 60); // Adăugăm padding mai mare

// Adăugăm combobox-uri pentru secțiunea dreaptă
		String[] itemsDreapta = { "Grupa", "Laboratorul", "Disciplina" };
		for (int i = 0; i < itemsDreapta.length; i++) {
			JComboBox comboBox = new JComboBox<>(profi);
			comboBox.setRenderer(new MyComboBoxRenderer(itemsDreapta[i]));
			comboBox.setSelectedIndex(-1);
			comboBox.setFont(new Font("Arial", Font.PLAIN, 14)); // Personalizăm fontul
			comboBox.setPreferredSize(new Dimension(300, 70)); // Mărim butonul
			gbcDreapta.gridy = i; // Setăm poziția verticală
			panelDreapta.add(comboBox, gbcDreapta);
			comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String selectedValue = (String) comboBox.getSelectedItem();
			        System.out.println("Selected Value: " + selectedValue);
				}
			});
		}
		JPanel panelCentral = new JPanel(new GridBagLayout()); // Utilizăm GridBagLayout
		GridBagConstraints gbcCentral = new GridBagConstraints();
		gbcCentral.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
		gbcCentral.weightx = 1; // Distribuie spațiul pe orizontală
		gbcCentral.gridy = 0; // Setăm poziția verticală

// Adăugăm un buton pentru a salva datele
		JButton saveButton = new JButton("Salvează");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
// Logica pentru salvarea datelor
				System.out.println("Datele au fost salvate.");

			}
		});
		panelCentral.add(saveButton, gbcCentral); // Adăugăm butonul de salvare mai întâi

		JButton closeButton = new JButton("Închide");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		gbcCentral.gridy = 1; // Setăm poziția verticală pentru butonul de închidere
		panelCentral.add(closeButton, gbcCentral);

		gbcCentral.gridy = 1; // Setăm poziția verticală pentru butonul de salvare
		panelCentral.add(saveButton, gbcCentral);

		frame.add(panelStanga, BorderLayout.WEST);
		frame.add(panelCentral, BorderLayout.SOUTH); // Adăugăm panoul central în partea de jos
		frame.add(panelDreapta, BorderLayout.EAST);

		frame.setVisible(true);
	}

}
class MyComboBoxRenderer extends JLabel implements ListCellRenderer
{
    private String _title;

    public MyComboBoxRenderer(String title)
    {
        _title = title;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean hasFocus)
    {
        if (index == -1 && value == null) setText(_title);
        else setText(value.toString());
        return this;
    }
}