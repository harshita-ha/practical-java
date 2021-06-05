package com.course.practicaljava.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateUtil {
	
	private static final long minDay = LocalDate.of(2010,Month.JANUARY,10).toEpochDay();
	private static final long maxDay = LocalDate.now().toEpochDay();
	
	public static LocalDate generateRandom() {
		long randomDay = minDay + ThreadLocalRandom.current().nextLong(maxDay-minDay);
		return LocalDate.ofEpochDay(randomDay);
	}

}
