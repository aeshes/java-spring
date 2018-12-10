package main.app;


import main.base.MessageProvider;
import main.base.MessageRenderer;
import main.factory.MessageSupportFactory;

public class Main {
    public static void main(String[] args) {
        MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
        MessageRenderer mr = MessageSupportFactory.getInstance().getRenderer();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
