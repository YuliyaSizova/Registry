package fabric;

/**
 * Внутри этого класса мы передаём сообщение о том,
 * была или не была добавлена запись. Вообще не знаю,
 * правильный ли такой подход, просто при передаче сообщения
 * через запросы GET/POST эта надпись появляется каждый раз
 * при обновлении страницы. В данном случае этот класс
 * используется в чисто "косметических" целях.
 * @author Ivan
 */
public class AnswerBean {
    private String message;
    
    // Геттеры и сеттеры - всё, из чего состоит JavaBean
    public AnswerBean() {
        message = null;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
