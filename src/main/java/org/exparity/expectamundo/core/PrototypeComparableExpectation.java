
package org.exparity.expectamundo.core;

import org.exparity.expectamundo.core.expectations.IsComparableTo;

/**
 * @author Stewart Bissett
 */
public class PrototypeComparableExpectation<T extends Comparable<T>> extends PrototypeObjectExpectation {

	public PrototypeComparableExpectation(final Prototype<?> prototype, final PrototypeProperty property) {
		super(prototype, property);
	}

	public void isComparableTo(final T comparable) {
		hasExpectation(new IsComparableTo<T>(comparable));
	}
}
