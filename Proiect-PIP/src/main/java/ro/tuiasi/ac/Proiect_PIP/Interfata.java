package ro.tuiasi.ac.Proiect_PIP;

import javax.swing.*;

import org.w3c.dom.html.HTMLSelectElement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Interfata {
	public void initInterface() {
		Citire c = new Citire();
		c.citireProfesori();
		c.citireMaterii();
		c.citireGrupe(1);
		
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
		String[] itemsStanga = { "numeProfesor", "functieProfesor", "numeAsistent" };
		String[] profi = { "lavinia", "cosmin", "alex" };
		String[] functii_profesori = { "Profesor", "Conferentiar", "Sef lucrari", "Asistent" };
		JComboBox comboBox1 = new JComboBox<>(c.profesori);
		comboBox1.setRenderer(new MyComboBoxRenderer(itemsStanga[0]));
		comboBox1.setSelectedIndex(-1);
		comboBox1.setFont(new Font("Arial", Font.PLAIN, 14)); // Personalizăm fontul
		comboBox1.setPreferredSize(new Dimension(300, 70)); // Mărim butonul
		gbcStanga.gridy = 0; // Setăm poziția verticală
		panelStanga.add(comboBox1, gbcStanga);
		comboBox1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValueProfesori = (String) comboBox1.getSelectedItem();
		        System.out.println("Selected Value: " + selectedValueProfesori);
			}
		});
		
		JComboBox comboBox2 = new JComboBox<>(functii_profesori);
		comboBox2.setRenderer(new MyComboBoxRenderer(itemsStanga[1]));
		comboBox2.setSelectedIndex(-1);
		comboBox2.setFont(new Font("Arial", Font.PLAIN, 14)); // Personalizăm fontul
		comboBox2.setPreferredSize(new Dimension(300, 70)); // Mărim butonul
		gbcStanga.gridy = 1; // Setăm poziția verticală
		panelStanga.add(comboBox2, gbcStanga);
		comboBox2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValueProfesori = (String) comboBox2.getSelectedItem();
		        System.out.println("Selected Value: " + selectedValueProfesori);
			}
		});
		
		JComboBox comboBox3 = new JComboBox<>(c.profesori);
		comboBox3.setRenderer(new MyComboBoxRenderer(itemsStanga[2]));
		comboBox3.setSelectedIndex(-1);
		comboBox3.setFont(new Font("Arial", Font.PLAIN, 14)); // Personalizăm fontul
		comboBox3.setPreferredSize(new Dimension(300, 70)); // Mărim butonul
		gbcStanga.gridy = 2; // Setăm poziția verticală
		panelStanga.add(comboBox3, gbcStanga);
		comboBox3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValueProfesori = (String) comboBox3.getSelectedItem();
		        System.out.println("Selected Value: " + selectedValueProfesori);
			}
		});
		
		JTextField textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(300, 50));
		gbcStanga.gridy = 3;
		panelStanga.add(textField1, gbcStanga);
		
// Crearea celui de-al doilea panel pentru secțiunea dreaptă
		JPanel panelDreapta = new JPanel(new GridBagLayout()); // Utilizăm GridBagLayout
		GridBagConstraints gbcDreapta = new GridBagConstraints();
		gbcDreapta.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
		gbcDreapta.weightx = 1; // Distribuie spațiul pe orizontală
		gbcDreapta.insets = new Insets(10, 60, 10, 60); // Adăugăm padding mai mare

// Adăugăm combobox-uri pentru secțiunea dreaptă
		String[] itemsDreapta = { "numeGrupe", "numeLaborator", "numeMaterie" };
		String[] laboratoare = { "A0-1", "A0-2", "A0-3", "A0-4", "A0-5", "A0-6", "A0-7", "A0-8", "A0-9", "A0-10", "A0-11", "A0-12" };
		JComboBox comboBox4 = new JComboBox<>(c.grupe);
		comboBox4.setRenderer(new MyComboBoxRenderer(itemsDreapta[0]));
		comboBox4.setSelectedIndex(-1);
		comboBox4.setFont(new Font("Arial", Font.PLAIN, 14)); // Personalizăm fontul
		comboBox4.setPreferredSize(new Dimension(300, 70)); // Mărim butonul
		gbcDreapta.gridy = 0; // Setăm poziția verticală
		panelDreapta.add(comboBox4, gbcDreapta);
		comboBox4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValue = (String) comboBox4.getSelectedItem();
		        System.out.println("Selected Value: " + selectedValue);
			}
		});
		
		JComboBox comboBox5 = new JComboBox<>(laboratoare);
		comboBox5.setRenderer(new MyComboBoxRenderer(itemsDreapta[1]));
		comboBox5.setSelectedIndex(-1);
		comboBox5.setFont(new Font("Arial", Font.PLAIN, 14)); // Personalizăm fontul
		comboBox5.setPreferredSize(new Dimension(300, 70)); // Mărim butonul
		gbcDreapta.gridy = 1; // Setăm poziția verticală
		panelDreapta.add(comboBox5, gbcDreapta);
		comboBox5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValue = (String) comboBox5.getSelectedItem();
		        System.out.println("Selected Value: " + selectedValue);
			}
		});
		
		JComboBox comboBox6 = new JComboBox<>(c.materii);
		comboBox6.setRenderer(new MyComboBoxRenderer(itemsDreapta[2]));
		comboBox6.setSelectedIndex(-1);
		comboBox6.setFont(new Font("Arial", Font.PLAIN, 14)); // Personalizăm fontul
		comboBox6.setPreferredSize(new Dimension(300, 70)); // Mărim butonul
		gbcDreapta.gridy = 2; // Setăm poziția verticală
		panelDreapta.add(comboBox6, gbcDreapta);
		comboBox6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValue = (String) comboBox6.getSelectedItem();
		        System.out.println("Selected Value: " + selectedValue);
			}
		});
		
		JTextField textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension(300, 50));
		gbcDreapta.gridy = 3;
		panelDreapta.add(textField2, gbcDreapta);
		
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
				s.replaceText("numeProfesor", (String) comboBox1.getSelectedItem());
				s.replaceText("functieProfesor", (String) comboBox2.getSelectedItem());
				s.replaceText("numeAsistent", (String) comboBox3.getSelectedItem());
				s.replaceText("numeGrupe", (String) comboBox4.getSelectedItem());
				s.replaceText("numeLaborator", (String) comboBox5.getSelectedItem());
				s.replaceText("numeMaterie", (String) comboBox6.getSelectedItem());
				s.replaceText("dataCompletare", textField1.getText());
				s.replaceText("dataFinala", textField2.getText());
				if (c.studenti.isEmpty())
					c.citireStudenti(1, (String) comboBox4.getSelectedItem());
				int nrStudenti = c.studenti.size();
				String nrStud = Integer.toString(nrStudenti);
				s.replaceText("nrStudenti", nrStud);
				/*
				s.replaceText("Num_std6", "Imi bag");
				s.replaceText("Num_std7", "Imi bag00000");
				s.replaceText("Num_std8", "Imi bacvbsesag");
				s.replaceText("Num_std9", "Imi bagawd");
				s.replaceText("Num_std10", "Imi awdwadwabag");
				*/
				
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