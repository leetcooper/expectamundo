
package org.exparity.expectamundo;

import java.util.Collection;
import org.exparity.expectamundo.core.PrototypeCollectionExpectation;
import org.exparity.expectamundo.core.PrototypeComparableExpectation;
import org.exparity.expectamundo.core.PrototypeFactory;
import org.exparity.expectamundo.core.PrototypeObjectExpectation;
import org.exparity.expectamundo.core.PrototypeVerifier;
import org.exparity.expectamundo.core.TypeReference;
import static org.exparity.expectamundo.core.PrototypeMatcherContext.currentPrototype;

/**
 * @author Stewart Bissett
 */
public class Expactamundo {

	private static PrototypeFactory factory = new PrototypeFactory();

	/**
	 * Prepare a new prototype
	 */
	public static <T> T prototype(final Class<T> type) {
		return factory.createPrototype(type);
	}

	/**
	 * Prepare a new prototype.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T prototype(final TypeReference<T> typeRef) {
		return (T) factory.createPrototype(typeRef.getType());
	}

	/**
	 * Setup an expecation for a property on a {@link Prototype}
	 */
	public static <E, T extends Collection<E>> PrototypeCollectionExpectation<E, T> expect(final T property) {
		if (currentPrototype() == null) {
			throw new IllegalArgumentException("You can only set an expectation for a property create with Expactamundo.prototype()");
		} else if (currentPrototype().getActiveProperty() == null) {
			throw new IllegalArgumentException("You can only set an expectation for a property create with Expactamundo.prototype()");
		} else {
			return new PrototypeCollectionExpectation<E, T>(currentPrototype(), currentPrototype().getActiveProperty());
		}
	}

	/**
	 * Setup an expecation for a property on a {@link Prototype}
	 */
	public static <T extends Comparable<T>> PrototypeComparableExpectation<T> expect(final T property) {
		if (currentPrototype() == null) {
			throw new IllegalArgumentException("You can only set an expectation for a property create with Expactamundo.prototype()");
		} else if (currentPrototype().getActiveProperty() == null) {
			throw new IllegalArgumentException("You can only set an expectation for a property create with Expactamundo.prototype()");
		} else {
			return new PrototypeComparableExpectation<T>(currentPrototype(), currentPrototype().getActiveProperty());
		}
	}

	/**
	 * Setup an expecation for a property on a {@link Prototype}
	 */
	public static PrototypeObjectExpectation expect(final Object property) {
		if (currentPrototype() == null) {
			throw new IllegalArgumentException("You can only set an expectation for a property create with Expactamundo.prototype()");
		} else if (currentPrototype().getActiveProperty() == null) {
			throw new IllegalArgumentException("You can only set an expectation for a property create with Expactamundo.prototype()");
		} else {
			return new PrototypeObjectExpectation(currentPrototype(), currentPrototype().getActiveProperty());
		}
	}

	public static <T> PrototypeVerifier<T> verify(final T test) {
		return new PrototypeVerifier<T>(test);
	}
}