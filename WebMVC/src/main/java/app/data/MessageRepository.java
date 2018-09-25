package app.data;

import app.data.model.Message;

import java.util.List;

public interface MessageRepository {
    List<Message> find(long max, int count);
}
