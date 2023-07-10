package com.scient.labs.sciboard.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class ZonedDateTimeCodec implements Codec<ZonedDateTime> {

    @Override
    public void encode(BsonWriter writer, ZonedDateTime value, EncoderContext encoderContext) {
        writer.writeDateTime(value.toInstant().toEpochMilli());
    }

    @Override
    public ZonedDateTime decode(BsonReader reader, DecoderContext decoderContext) {
        long timestamp = reader.readDateTime();
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault());
    }

    @Override
    public Class<ZonedDateTime> getEncoderClass() {
        return ZonedDateTime.class;
    }
}
