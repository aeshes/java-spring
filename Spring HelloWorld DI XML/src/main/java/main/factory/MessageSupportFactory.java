package main.factory;

import main.base.MessageProvider;
import main.base.MessageRenderer;

import java.io.FileInputStream;
import java.util.Properties;

public class MessageSupportFactory {

    private static MessageSupportFactory instance;

    private Properties props;
    private MessageProvider provider;
    private MessageRenderer renderer;

    private MessageSupportFactory() {
        props = new Properties();
        try {
            props.load(new FileInputStream("src/main/resources/settings.properties"));

            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageProvider getProvider() {
        return provider;
    }

    public MessageRenderer getRenderer() {
        return renderer;
    }
}
