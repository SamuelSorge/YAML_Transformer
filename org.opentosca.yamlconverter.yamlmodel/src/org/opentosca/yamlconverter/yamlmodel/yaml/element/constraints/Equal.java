package org.opentosca.yamlconverter.yamlmodel.yaml.element.constraints;

public class Equal<T> extends TypeScalar<T> {

	public Equal(Class<T> dataType, Object constraintObject) {
		super(dataType, constraintObject);
	}

	@Override
	public boolean isValid(T value) {
		return this.constraintValue.equals(value);
	}

}
