package ru.tanz.chat;

import org.bukkit.Bukkit;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tanz.StaffChat;
import ru.tanz.utils.ConfigUtil;

public class ChatManager{


    public void handle(AsyncPlayerChatEvent event) {
        StaffChat.getChatStyles().stream()
                .filter(chatNext -> event.getMessage().startsWith(chatNext.getSymbol()))
                .findFirst()
                .ifPresent(command -> {
                    if(event.getPlayer().hasPermission(command.getPermission())) {
                        event.setCancelled(true);
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            if (player.hasPermission(command.getPermission())) {
                                String msg = ConfigUtil.color(command.getPrefix()
                                        + " "
                                        + event.getMessage().substring(1)
                                        + " "
                                        + command.getSender().replace("%player%",
                                        event.getPlayer().getName()));
                                player.sendMessage(msg);
                                event.setCancelled(true);
                            }
                        });
                    }
                }
            );
    }

}
