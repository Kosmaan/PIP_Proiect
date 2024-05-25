package ro.tuiasi.ac.Proiect_PIP;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.JComboBox;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

	@Test
	public void testInitInterface() {
		try {
			Interfata interfata = new Interfata();
			interfata.initInterface();
			assertTrue(true); // Dacă nu există nicio excepție, testul trece
		} catch (Exception e) {
			fail("initInterface aruncă o excepție: " + e.getMessage());
		}
	}

	private Citire citire;

	@Before
	public void setUp() {
		citire = new Citire();
	}

	@Test
	public void testCitireProfesori() {
		try {
			citire.citireProfesori();
			List<String> profesori = citire.profesori;
			assertNotNull(profesori);
			assertFalse(profesori.isEmpty()); // Verificăm dacă lista de profesori nu este goală
		} catch (Exception e) {
			fail("citireProfesori aruncă o excepție: " + e.getMessage());
		}
	}

	@Test
	public void testCitireMaterii() {
		try {
			citire.citireMaterii();
			List<String> materii = citire.materii;
			assertNotNull(materii);
			assertFalse(materii.isEmpty()); // Verificăm dacă lista de materii nu este goală
		} catch (Exception e) {
			fail("citireMaterii aruncă o excepție: " + e.getMessage());
		}
	}

	private Scriere scriere;

	@Before
	public void setUp1() {
		scriere = new Scriere();
	}

	@Test
	public void testReplaceText() {
		try {
			scriere.replaceText("numeProfesor", "John Doe");
			// Verificăm dacă metoda nu aruncă o excepție și presupunem că a funcționat
			// corect
			assertTrue(true);
		} catch (Exception e) {
			fail("replaceText aruncă o excepție: " + e.getMessage());
		}
	}

	private Interfata interfata;

	/*@Test
	public void testComboBox1Selection() throws InterruptedException {
		// Așteptăm ca interfața să fie complet afișată
		Thread.sleep(1000);
		// Obținem comboBox1
		JComboBox<String> comboBox1 = getChildNamed(interfata.getPanel(), "comboBox1");
		// Simulăm selectarea unei opțiuni în comboBox1
		comboBox1.setSelectedItem("lavinia");
		// Verificăm dacă selecția a fost setată corect
		assertEquals("Verificare selecție ComboBox1", "lavinia", comboBox1.getSelectedItem());
	}*/

}
