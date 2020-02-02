package com.wing.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author heweiye
 * @version 1.0
 * @description mybatis  代码自动生成演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 * @date 2019/9/11 14:00
 */
public class CodeGenerator {

	/**
	 * <p>
	 * 读取控制台内容
	 * </p>
	 */
	@SuppressWarnings("resource")
	public static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (!StringUtils.isEmpty(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}

	public static void main(String[] args) {
		/*
		 * 全局配置
		 */
		GlobalConfig globalConfig = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
		// 生成文件的输出目录【默认 D 盘根目录】
		globalConfig.setOutputDir(projectPath + "/System-Admin/organization/src/main/java");
		// 开发人员
		globalConfig.setAuthor("heweiye");
		// 是否打开输出目录
		globalConfig.setOpen(false);
		// 开启 BaseResultMap
		globalConfig.setBaseResultMap(true);
		globalConfig.setIdType(IdType.AUTO);

		/*
		 * 代码生成器
		 */
		AutoGenerator autoGenerator = new AutoGenerator();
		autoGenerator.setGlobalConfig(globalConfig);
		// 数据源配置
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setUrl("jdbc:mysql://192.168.37.109:3306/wing_admin?useUnicode=true&characterEncoding=utf8");
		dataSourceConfig.setSchemaName("public");
		dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
		dataSourceConfig.setUsername("root");
		dataSourceConfig.setPassword("root");
		// 数据库类型
		dataSourceConfig.setDbType(DbType.MYSQL);
		// 数据库信息查询
		dataSourceConfig.setDbQuery(new MySqlQuery());
		autoGenerator.setDataSource(dataSourceConfig);
		// 包配置
		PackageConfig packageConfig = new PackageConfig();
		String moduleName = scanner("模块名");
		packageConfig.setModuleName(moduleName);
		packageConfig.setParent("com.wing");
		autoGenerator.setPackageInfo(packageConfig);
		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		// 表前缀
		strategy.setTablePrefix(new String[] { "tb_", "tb_v2_","tb_thirdparty_" });
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		// 写于父类中的公共字段
		// strategy.setSuperEntityColumns(new String[]{"id"});
		strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setEntitySerialVersionUID(true);
		// 是否为lombok模型
		strategy.setEntityLombokModel(true);
		// 生成实体时，生成字段注解
		strategy.setEntityTableFieldAnnotationEnable(true);
		// 逻辑删除属性名称
		strategy.setLogicDeleteFieldName("isDeleted");
		autoGenerator.setStrategy(strategy);
		// 模板 相关配置
		TemplateConfig templateConfig = new TemplateConfig();
		templateConfig.setXml(null);
		autoGenerator.setTemplate(templateConfig);

		// 自定义配置
		InjectionConfig injectionConfig = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};

		// 如果模板引擎是 freemarker
		String templatePath = "/templates/mapper.xml.ftl";

		// 自定义输出配置
		List<FileOutConfig> focList = new ArrayList<>();
		// 自定义配置会被优先输出
		focList.add(new FileOutConfig(templatePath) {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/System-Admin/organization/src/main/resources/mybatis/xml/" + moduleName + "/" + tableInfo.getEntityName()
						+ "Mapper" + StringPool.DOT_XML;
			}
		});

		injectionConfig.setFileOutConfigList(focList);
		autoGenerator.setCfg(injectionConfig);

		autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
		autoGenerator.execute();
	}

}