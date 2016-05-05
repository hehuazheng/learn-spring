package org.springframework.samples.xml;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * copy from springframework reference
 *
 */
public class SimpleDateFormatBeanDefinitionParser extends
		AbstractSingleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return SimpleDateFormat.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String pattern = element.getAttribute("pattern");
		builder.addConstructorArg(pattern);
		String lenient = element.getAttribute("lenient");
		if (StringUtils.hasText(lenient)) {
			builder.addPropertyValue("lenient", Boolean.valueOf(lenient));
		}
	}

}
