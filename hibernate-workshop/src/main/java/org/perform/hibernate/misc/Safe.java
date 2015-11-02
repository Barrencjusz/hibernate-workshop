package org.perform.hibernate.misc;

public class Safe {

	@SuppressWarnings("unchecked")
	public static <RESULT> RESULT cast(Object object) {
		return (RESULT) object;
	}
}
