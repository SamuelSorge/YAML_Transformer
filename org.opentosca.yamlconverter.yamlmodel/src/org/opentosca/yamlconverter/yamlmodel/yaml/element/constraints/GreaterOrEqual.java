package org.opentosca.yamlconverter.yamlmodel.yaml.element.constraints;

public class GreaterOrEqual extends TypeScalar<Comparable<?>> {

	public GreaterOrEqual(Class<Comparable<?>> dataType, Object constraintObject) {
		super(dataType, constraintObject);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean isValid(Comparable value) {
		return value.compareTo(this.constraintValue) >= 0;
	}
}
