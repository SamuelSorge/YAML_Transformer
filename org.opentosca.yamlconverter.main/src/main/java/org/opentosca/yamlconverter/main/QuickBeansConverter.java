package org.opentosca.yamlconverter.main;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.namespace.QName;

import org.opentosca.model.tosca.Definitions;
import org.opentosca.model.tosca.TEntityTemplate;
import org.opentosca.model.tosca.TNodeTemplate;
import org.opentosca.model.tosca.TServiceTemplate;
import org.opentosca.model.tosca.TTopologyTemplate;
import org.opentosca.yamlconverter.main.interfaces.IToscaBean2BeanConverter;
import org.opentosca.yamlconverter.yamlmodel.yaml.element.NodeTemplate;
import org.opentosca.yamlconverter.yamlmodel.yaml.element.YAMLFileRoot;

public class QuickBeansConverter implements IToscaBean2BeanConverter {

	@Override
	public YAMLFileRoot xmlb2yamlb(Definitions xmlroot) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Definitions yamlb2xmlb(YAMLFileRoot yamlBean) {
		final Map<String, NodeTemplate> nodetemps = yamlBean.getNode_templates();
		final TServiceTemplate servtemp = convertTo(nodetemps, new TServiceTemplate());
		final Definitions tdef = new Definitions();
		tdef.setId("blubb");
		tdef.setTargetNamespace("http://www.example.org/tosca/blubbtemplate");
		tdef.getServiceTemplateOrNodeTypeOrNodeTypeImplementation().add(servtemp);
		return tdef;
	}

	public TServiceTemplate convertTo(Map<String, NodeTemplate> yamlmap, TServiceTemplate arg1) {
		final TServiceTemplate serviceTemp = new TServiceTemplate();
		final TTopologyTemplate topoTemp = new TTopologyTemplate();
		final List<TEntityTemplate> nodelist = topoTemp.getNodeTemplateOrRelationshipTemplate();
		for (final Map.Entry<String, NodeTemplate> entry : yamlmap.entrySet()) {
			nodelist.add(toXMLNodeTempl(entry));
		}
		serviceTemp.setTopologyTemplate(topoTemp);
		serviceTemp.setId("serviceblubb");
		return serviceTemp;
	}

	private TNodeTemplate toXMLNodeTempl(Entry<String, NodeTemplate> entry) {
		final TNodeTemplate xNodeTemp = new TNodeTemplate();
		// final Properties prop = new Properties();
		// prop.setAny(entry.getValue().getProperties());
		// xNodeTemp.setProperties(prop);
		xNodeTemp.setName(entry.getKey());
		xNodeTemp.setType(new QName(entry.getValue().getType()));
		xNodeTemp.setId("blubb_" + entry.getKey());
		return xNodeTemp;
	}

}