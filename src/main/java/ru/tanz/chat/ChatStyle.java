package ru.tanz.chat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PROTECTED, makeFinal = true)
public class ChatStyle {



    String prefix;
    String symbol;
    String permission;
    String sender;

    public ChatStyle(String prefix, String symbol, String permission, String sender) {
        this.prefix = prefix;
        this.symbol = symbol;
        this.permission = permission;
        this.sender = sender;
    }
}
