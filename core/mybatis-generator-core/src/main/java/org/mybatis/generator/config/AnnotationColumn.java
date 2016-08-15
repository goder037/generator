/**
 *    Copyright 2006-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.config;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.util.List;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * The Class ColumnOverride.
 *
 * @author Jeff Butler
 */
public class AnnotationColumn extends PropertyHolder {

    private String columnName;

    private String annotationFullName;

    private String annotationContent;
    

    /**
     * Instantiates a new column override.
     *
     * @param columnName
     *            the column name
     */
    public AnnotationColumn(String columnName, String annotationFullName, String annotationContent) {
        super();
        this.columnName = columnName;
        this.annotationFullName = annotationFullName;
        this.annotationContent = annotationContent;
    }

    /**
     * Gets the column name.
     *
     * @return the column name
     */
    public String getColumnName() {
        return columnName;
    }
    
    public String getAnnotationFullName() {
		return annotationFullName;
	}

	public void setAnnotationFullName(String annotationFullName) {
		this.annotationFullName = annotationFullName;
	}

	public String getAnnotationContent() {
		return annotationContent;
	}

	public void setAnnotationContent(String annotationContent) {
		this.annotationContent = annotationContent;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
     * To xml element.
     *
     * @return the xml element
     */
    public XmlElement toXmlElement() {
        XmlElement xmlElement = new XmlElement("annotationColumn"); //$NON-NLS-1$
        xmlElement.addAttribute(new Attribute("column", columnName)); //$NON-NLS-1$

        if (stringHasValue(annotationFullName)) {
            xmlElement.addAttribute(new Attribute("annotationFullName", annotationFullName)); //$NON-NLS-1$
        }

        if (stringHasValue(annotationContent)) {
            xmlElement.addAttribute(new Attribute("annotationContent", annotationContent)); //$NON-NLS-1$
        }

        addPropertyXmlElements(xmlElement);

        return xmlElement;
    }

    /**
     * Validate.
     *
     * @param errors
     *            the errors
     * @param tableName
     *            the table name
     */
    public void validate(List<String> errors, String tableName) {
        if (!stringHasValue(columnName)) {
            errors.add(getString("ValidationError.28", //$NON-NLS-1$
                    tableName));
        }
        if (!stringHasValue(annotationFullName)) {
            errors.add(getString("ValidationError.28", //$NON-NLS-1$
                    tableName));
        }
        if (!stringHasValue(annotationContent)) {
            errors.add(getString("ValidationError.28", //$NON-NLS-1$
                    tableName));
        }
    }
}
