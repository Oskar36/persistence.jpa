package com.txurdi.persistencia.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LibroTest {
	static ValidatorFactory factory = null;
	static Validator validator = null;
	static Editorial ediMock = null;
	static Libro lMock = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		factory = null;
		validator = null;
	}

	@Before
	public void setUp() throws Exception {
		ediMock = new Editorial(2, "Ivrea");
		lMock = new Libro("Oshi no ko", ediMock);
	}

	@After
	public void tearDown() throws Exception {
		ediMock = null;
		lMock = null;
	}

	@Test
	public void testLibroOkay() {
		Set<ConstraintViolation<Libro>> violaciones = validator.validate(lMock);
		assertTrue("El libro deberia ser valido", violaciones.isEmpty());
	}

	@Test
	public void testLibroValidaciones() {
	
		// null
		lMock.setNombre(null);
		Set<ConstraintViolation<Libro>> violaciones = validator.validate(lMock);
		assertFalse("El libro NO deberia ser valido", violaciones.isEmpty());
		
		// 1 letra
		lMock.setNombre("a");
		violaciones = validator.validate(lMock);
		assertFalse("El libro NO deberia ser valido, only una letra", violaciones.isEmpty());
		// 2 letras
		lMock.setNombre("ab");
		violaciones = validator.validate(lMock);
		assertTrue("El libro  deberia ser valido", violaciones.isEmpty());
		/*
		// 255 letras
		//lMock.setNombre("ab");

		// 256 letras
		//lMock.setNombre("ab");
		 */
		 
	}

}
