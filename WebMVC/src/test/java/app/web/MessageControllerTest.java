package app.web;

import app.data.MessageRepository;
import app.data.model.Message;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class MessageControllerTest {

    @Test
    public void shouldShowRecentMessages() throws Exception {
        List<Message> expectedMessages = createMsgList(20);
        MessageRepository mockRepository = mock(MessageRepository.class);

        when(mockRepository.find(Long.MAX_VALUE, 20))
                .thenReturn(expectedMessages);

        MessageController controller = new MessageController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/messages.jsp"))
                .build();

        mockMvc.perform(get("/messages"))
                .andExpect(view().name("messages"))
                .andExpect(model().attributeExists("messagesList"));
    }

    private List<Message> createMsgList(int count) {
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            messages.add(new Message("Message " + i, new Date()));
        }
        return messages;
    }
}
