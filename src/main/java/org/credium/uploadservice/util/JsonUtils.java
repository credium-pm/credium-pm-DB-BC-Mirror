package org.credium.uploadservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;

public final class JsonUtils {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final TypeFactory typeFactory = objectMapper.getTypeFactory();

	public static <T> List<T> jsonToObject(final String json, final Class<T> clazz) {
		try {
			return objectMapper.readValue(json, typeFactory.constructCollectionType(List.class, clazz));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

}
