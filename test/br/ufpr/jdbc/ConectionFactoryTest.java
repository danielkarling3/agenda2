package br.ufpr.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConectionFactoryTest {

	@Test
	public void testGetConnection() {
		ConectionFactory factory = new ConectionFactory();
		assertNotNull(factory.getConnection());
		
	}

}
