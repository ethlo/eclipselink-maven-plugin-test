package com.ethlo.persistence.tools.eclipselink.test.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class Ip4Converter implements AttributeConverter<String, Long>
{
    @Override
	public Long convertToDatabaseColumn(String dotIp)
	{
		long result = 0;
		final String[] ipAddressInArray = dotIp.split("\\.");
		for (int i = 3; i >= 0; i--)
		{
			final long ip = Long.parseLong(ipAddressInArray[3 - i]);
			result |= ip << (i * 8);
		}
		return result;
	}

	@Override
	public String convertToEntityAttribute(Long ipLng)
	{
    	final StringBuilder result = new StringBuilder(15);
    	for (int i = 0; i < 4; i++) {
    		result.insert(0,Long.toString(ipLng & 0xff));
    		if (i < 3) {
    			result.insert(0,'.');
    		}
    		ipLng = ipLng >> 8;
    	}
    	return result.toString();
    }
}
