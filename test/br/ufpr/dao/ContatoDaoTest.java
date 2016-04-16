package br.ufpr.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;



import org.junit.Test;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import br.ufpr.modelo.Contato;

public class ContatoDaoTest {

	@Test
	public void test() throws ParseException {
		
ContatoDao contatoDao = new ContatoDao();
		
		String data = "16/07/2008";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(data));
		Contato contato = new Contato("Sou eu",
					"danielantoniokarling3@gmail.com",
					"Rua tom Jobim", 
					cal);
		contatoDao.adiciona(contato);
		
		ContatoDao contatoDao2 = new ContatoDao();
		ArrayList<Contato> resultado = contatoDao2.getLista();
		for (Contato r : resultado) {
			  System.out.println("Nome: " + r.getNome());
			  System.out.println("Email: " + r.getEmail());
			  System.out.println("Endereço: " + r.getEndereco());
			  System.out.println("Data de Nascimento: " +r.getDataNascimento());
			  
			}
		
		
	}

}
