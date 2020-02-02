package com.wing.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heweiye
 * @version 1.0
 * @description mybatis基本配置
 * @date 2019/9/11 14:00
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.wing.*.mapper")
public class MybatisPlusConfig {

	@Bean
	public org.apache.ibatis.session.Configuration configuration() {
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setUseActualParamName(false);
		return configuration;
	}

	/**
	 * mybatis-plus分页插件
	 *
	 * @return PaginationInterceptor
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor pageInterceptor = new PaginationInterceptor();
		pageInterceptor.setDialectType("mysql");
		// 最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制
		pageInterceptor.setLimit(500);

		List<ISqlParser> sqlParserList = new ArrayList<>();
		// 攻击SQL阻断解析器、加入解析链（阻止恶意的全表更新删除）
		sqlParserList.add(new BlockAttackSqlParser());
		pageInterceptor.setSqlParserList(sqlParserList);
		return pageInterceptor;
	}

	/**
	 * SQL执行效率插件<br>
	 * 设置 dev test 环境开启<br>
	 * 该插件只用于开发环境，不建议生产环境使用。
	 *
	 * @return
	 */
	@Bean
	@Profile({ "dev", "test" })
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		// maxTime SQL 执行最大时长，超过自动停止运行，有助于发现问题。
		performanceInterceptor.setMaxTime(1000);
		// format SQL SQL是否格式化，默认false。
		performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}

}
