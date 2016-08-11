package study.mq;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;

import com.alibaba.fastjson.JSON;

public class FastJsonMessageConverter extends AbstractMessageConverter {
	public static final String DEFAULT_CHARSET = "UTF-8";
	private String charset = DEFAULT_CHARSET;

	public void setCharset(String charset) {
		this.charset = charset;
	}

	@Override
	protected Message createMessage(Object obj, MessageProperties props) {
		byte[] bytes = null;
		String json = JSON.toJSONString(obj);
		try {
			bytes = json.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new MessageConversionException("conversion failure", e);
		}
		props.setContentType(MessageProperties.CONTENT_TYPE_JSON);
		props.setContentEncoding(charset);
		if (bytes != null) {
			props.setContentLength(bytes.length);
		}
		return new Message(bytes, props);
	}

	@Override
	public Object fromMessage(Message msg) throws MessageConversionException {
		return null;
	}

	public <T> T fromMessage(Message msg, Class<T> clazz)
			throws MessageConversionException {
		String json = "";
		try {
			json = new String(msg.getBody(), charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return JSON.parseObject(json, clazz);
	}
}
