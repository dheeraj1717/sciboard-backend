package com.scient.labs.sciboard.config;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
	
	@Value("${spring.data.mongodb.database}")
	private String databaseName;
	

	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@Override
	@Bean
	public MongoCustomConversions customConversions() {
		List<Object> converters = new ArrayList<>();
		converters.add(new StringToZonedDateTimeConverter());
		converters.add(new ZonedDateTimeToStringConverter());
		return new MongoCustomConversions(converters);
	}

	public static class StringToZonedDateTimeConverter
			implements org.springframework.core.convert.converter.Converter<String, ZonedDateTime> {
		@Override
		public ZonedDateTime convert(String source) {
			return ZonedDateTime.parse(source, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}
	}

	public static class ZonedDateTimeToStringConverter
			implements org.springframework.core.convert.converter.Converter<ZonedDateTime, String> {
		@Override
		public String convert(ZonedDateTime source) {
			return source.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}
	}
}
