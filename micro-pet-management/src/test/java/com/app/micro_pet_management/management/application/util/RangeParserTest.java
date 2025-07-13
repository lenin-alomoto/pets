package com.app.micro_pet_management.management.application.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class RangeParserTest {

	@Test
	void parseMin_validRange_returnsMin() {
		assertEquals(new BigDecimal("10"), RangeParser.parseMin("10 - 20"));
		assertEquals(new BigDecimal("5"), RangeParser.parseMin("5-15"));
		assertEquals(new BigDecimal("0"), RangeParser.parseMin("0 - 0"));
	}

	@Test
	void parseMin_invalidOrNull_returnsNull() {
		assertNull(RangeParser.parseMin(null));
		assertNull(RangeParser.parseMin("10"));
		assertNull(RangeParser.parseMin("abc - 10"));
		assertNull(RangeParser.parseMin(" - 10"));
		assertNull(RangeParser.parseMin(" - "));
	}

	@Test
	void parseMax_validRange_returnsMax() {
		assertEquals(new BigDecimal("20"), RangeParser.parseMax("10 - 20"));
		assertEquals(new BigDecimal("15"), RangeParser.parseMax("5-15"));
		assertEquals(new BigDecimal("0"), RangeParser.parseMax("0 - 0"));
	}

	@Test
	void parseMax_invalidOrNull_returnsNull() {
		assertNull(RangeParser.parseMax(null));
		assertNull(RangeParser.parseMax("20"));
		assertNull(RangeParser.parseMax("10 - abc"));
		assertNull(RangeParser.parseMax("10 - "));
		assertNull(RangeParser.parseMax(" - "));
	}

}
