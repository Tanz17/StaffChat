package ru.tanz;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import ru.tanz.chat.ChatManager;
import ru.tanz.chat.ChatStyle;
import ru.tanz.commands.ReloadCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class StaffChat extends JavaPlugin implements Listener {

    private static StaffChat instance;

    private static List<ChatStyle> chatStyles = new ArrayList<>();

    public static List<ChatStyle> getChatStyles() {
        return chatStyles;
    }

    public static StaffChat getInstance() {
        return instance;
    }
    public static ChatManager chatManager = new ChatManager();

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        registerChats();
        getCommand("tstaffchat").setExecutor(new ReloadCommand());
        Logger log = Logger.getLogger("");
        log.info("§e| §c████████╗ █████╗ ███╗  ██╗███████╗");
        log.info("§e| §c╚══██╔══╝██╔══██╗████╗ ██║╚════██║");
        log.info("§e| §c   ██║   ███████║██╔██╗██║  ███╔═╝");
        log.info("§e| §c   ██║   ██╔══██║██║╚████║██╔══╝  ");
        log.info("§e| §c   ██║   ██║  ██║██║ ╚███║███████╗");
        log.info("§e| §c   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚══╝╚══════╝");
        log.info("");
        log.info("§e| §fПлагин §ctStaffChat §7& §fВерсия плагина - §a1.0");
        log.info("§e| §fРазработчик - §e§nvk.com/tanz_ind");
    }

    @EventHandler
    public void onSendChat(AsyncPlayerChatEvent event){
        chatManager.handle(event);
    }

    public void registerChats(){
        if(getConfig().getConfigurationSection("chats").getKeys(false) != null &&
                !getConfig().getConfigurationSection("chats").getKeys(false).isEmpty()){
            chatStyles.clear();
            getConfig().getConfigurationSection("chats").getKeys(false)
                    .forEach(chat -> chatStyles.add(new ChatStyle(
                            getConfig().getString("chats." + chat + ".prefix"),
                            getConfig().getString("chats." + chat + ".symbol"),
                            getConfig().getString("chats." + chat + ".permission"),
                            getConfig().getString("chats." + chat + ".sender"))));
        } else{
            throw new RuntimeException("Список чатов пуст");
        }
    }

    @Override
    public void onDisable() {
        Logger log = Logger.getLogger("");
        log.info("§e| §c████████╗ █████╗ ███╗  ██╗███████╗");
        log.info("§e| §c╚══██╔══╝██╔══██╗████╗ ██║╚════██║");
        log.info("§e| §c   ██║   ███████║██╔██╗██║  ███╔═╝");
        log.info("§e| §c   ██║   ██╔══██║██║╚████║██╔══╝  ");
        log.info("§e| §c   ██║   ██║  ██║██║ ╚███║███████╗");
        log.info("§e| §c   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚══╝╚══════╝");
        log.info("");
        log.info("§e| §fПлагин §ctStaffChat §7& §fВерсия плагина - §a1.0");
        log.info("§e| §fРазработчик - §e§nvk.com/tanz_ind");

    }
}
