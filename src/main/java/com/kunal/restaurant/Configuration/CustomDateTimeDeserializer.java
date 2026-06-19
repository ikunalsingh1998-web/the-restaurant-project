package com.kunal.restaurant.Configuration;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.expression.ParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDateTimeDeserializer extends StdDeserializer<Timestamp> {
	
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public CustomDateTimeDeserializer() {
        super(Timestamp.class);
    }
	
	@Override
	public Timestamp deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		JsonNode node = jp.getCodec().readTree(jp);
		String dateStr = node.asText();
		try {
			return new Timestamp(dateFormat.parse(dateStr).getTime());
		} catch (ParseException | java.text.ParseException e) {
			throw new IOException(e);
		}
	}

}
