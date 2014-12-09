
package org.exparity.expectamundo.core;


/**
 * @author Stewart Bissett
 */
public class PrototypePropertyMatcher {

	private final PrototypeProperty property;
	private final PropertyExpectation expectation;

	public PrototypePropertyMatcher(final PrototypeProperty property, final PropertyExpectation expectation) {
		this.property = property;
		this.expectation = expectation;
	}

	public boolean matches(final Object actual) {
		return expectation.matches(actual);
	}

	public String getPropertyPath() {
		return property.getPath();
	}

	public Object getPropertyValue(final Object actual) {
		return property.getPropertyValue(actual);
	}

	public String getExpectation() {
		return expectation.describe();
	}

	@Override
	public String toString() {
		return "Expectation [" + getPropertyPath() + "=" + getExpectation() + "]";
	}
}