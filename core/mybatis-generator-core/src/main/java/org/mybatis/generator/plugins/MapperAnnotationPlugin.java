/*
 *    Copyright 2006-2022 the original author or authors.
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
package org.mybatis.generator.plugins;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.IntrospectedTable.TargetRuntime;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 *
 *    mapper add               @Mapper Annotation
 * mapper add   @Repository  Annotation
 * mapper 's method add    throws SQLException
 * @author yanghao
 */
public class MapperAnnotationPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {

        if (introspectedTable.getTargetRuntime() == TargetRuntime.MYBATIS3) {
            // don't need to do this for MYBATIS3_DSQL as that runtime already adds this annotation
            interfaze.addImportedType(
                    new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));
            //$NON-NLS-1$
            interfaze.addAnnotation("@Repository");
            // don't need to do this for MYBATIS3_DSQL as that runtime already adds this annotation
            interfaze.addImportedType(
                    new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));
            //$NON-NLS-1$
            interfaze.addAnnotation("@Mapper");
            //$NON-NLS-1$

            // don't need to do this for MYBATIS3_DSQL as that runtime already adds this annotation
            interfaze.addImportedType(
                    new FullyQualifiedJavaType("java.sql.SQLException"));
            List<Method> methods = interfaze.getMethods();
            for (Method method : methods) {
                method.addException(new FullyQualifiedJavaType("java.sql.SQLException"));
            }
        }
        interfaze.addJavaDocLine("/**");
        interfaze.addJavaDocLine("* @author yanghao");
//        + this.date2Str(new Date())
        interfaze.addJavaDocLine("* Created by Mybatis Generator " );
        interfaze.addJavaDocLine("*/");
        return true;
    }

    private String date2Str(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(date);
    }
}
