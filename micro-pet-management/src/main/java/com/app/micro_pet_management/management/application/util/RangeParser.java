package com.app.micro_pet_management.management.application.util;

import java.math.BigDecimal;

public class RangeParser {
	
	private RangeParser() {
		throw new IllegalStateException("Utility class");
	}
	
	public static BigDecimal parseMin(String range) {
        try {
            if (range == null || !range.contains("-")) return null;
            return new BigDecimal(range.split("-")[0].trim());
        } catch (Exception e) {
            return null;
        }
    }

    public static BigDecimal parseMax(String range) {
        try {
            if (range == null || !range.contains("-")) return null;
            return new BigDecimal(range.split("-")[1].trim());
        } catch (Exception e) {
            return null;
        }
    }

}
