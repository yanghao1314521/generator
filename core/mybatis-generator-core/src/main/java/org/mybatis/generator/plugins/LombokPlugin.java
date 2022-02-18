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

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yanghao
 */
public class LombokPlugin extends PluginAdapter {
    public LombokPlugin() {
    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addImportedType("lombok.EqualsAndHashCode");
        topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = false)");
        //topLevelClass.addImportedType("lombok.Getter");
        //topLevelClass.addImportedType("lombok.Setter");
        //topLevelClass.addImportedType("lombok.ToString");
        //topLevelClass.addAnnotation("@Getter");
        //topLevelClass.addAnnotation("@Setter");
        //topLevelClass.addAnnotation("@ToString");

        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* @author yanghao");
//        + this.date2Str(new Date())
        topLevelClass.addJavaDocLine("* Created by Mybatis Generator ");
        topLevelClass.addJavaDocLine("*/");
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass,
                                                      IntrospectedTable introspectedTable) {

        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addImportedType("lombok.EqualsAndHashCode");
        topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = false)");

        //topLevelClass.addImportedType("lombok.Getter");
        //topLevelClass.addImportedType("lombok.Setter");
        //topLevelClass.addImportedType("lombok.ToString");
        //topLevelClass.addAnnotation("@Getter");
        //topLevelClass.addAnnotation("@Setter");
        //topLevelClass.addAnnotation("@ToString");

        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* @author yanghao");
//        + this.date2Str(new Date())
        topLevelClass.addJavaDocLine("* Created by Mybatis Generator ");
        topLevelClass.addJavaDocLine("*/");
        return true;
    }


    @Override
    public boolean providerGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* @author yanghao");
//        + this.date2Str(new Date())
        topLevelClass.addJavaDocLine("* Created by Mybatis Generator ");
        topLevelClass.addJavaDocLine("*/");
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addAnnotation("@Data");

        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* @author yanghao");
//        + this.date2Str(new Date())
        topLevelClass.addJavaDocLine("* Created by Mybatis Generator ");
        topLevelClass.addJavaDocLine("*/");
        return true;
    }


    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    private String date2Str(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(date);
    }
}
