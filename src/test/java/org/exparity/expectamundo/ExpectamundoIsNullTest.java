
package org.exparity.expectamundo;

import org.exparity.expectamundo.testutils.types.SimpleType;
import org.junit.Test;
import static org.exparity.expectamundo.Expactamundo.expect;
import static org.exparity.expectamundo.Expactamundo.prototype;
import static org.exparity.expectamundo.Expactamundo.verify;
import static org.exparity.stub.random.RandomBuilder.aRandomString;

/**
 * Unit Test for {@link Expactamundo} invocations of the {@link NullExpectation} expectation
 * 
 * @author Stewart Bissett
 */
public class ExpectamundoIsNullTest {

	@Test
	public void canCheckForIsNull() {
		SimpleType expected = prototype(SimpleType.class);
		expect(expected.getValue()).nullValue();
		verify(new SimpleType(null)).matches(expected);
	}

	@Test(expected = AssertionError.class)
	public void canCheckForIsNotNull() {
		SimpleType expected = prototype(SimpleType.class);
		expect(expected.getValue()).nullValue();
		verify(new SimpleType(aRandomString())).matches(expected);
	}

}
