package pl.xthunderek.zenguard.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import pl.xthunderek.zenguard.utils.ChatUtil;
import pl.xthunderek.zenguard.basic.ZenGuard;
import pl.xthunderek.zenguard.utils.Config;
import pl.xthunderek.zenguard.utils.ItemBuilder;

public class ZenGuardCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if (args.length < 1){
            p.sendMessage(" ");
            p.sendMessage(ChatUtil.fix("&4ZenGuard Protection &8[&7(&fVersion: " + ZenGuard.getInstance().getDescription().getVersion() + "&7)&8, &7(&fAuthor[s]: xThunderek, 0xygenOfficial&7)&8]"));
            p.sendMessage(" ");
            p.sendMessage(ChatUtil.fix("&6/zenguard menu"));
            p.sendMessage(ChatUtil.fix("&6/zenguard reload"));
        }
        else {
            if (args[0].equalsIgnoreCase("menu")) {
                if (!p.hasPermission(Config.getString("general.permission"))) {
                    p.sendMessage(ChatUtil.fix("&8[&3ZenGuard&8] " + Config.getString("messages.no-permission")));
                }
                mainGui(p);
            }
            else if (args[0].equalsIgnoreCase("reload")){
                ZenGuard.getInstance().reloadConfig();
                p.sendMessage(ChatUtil.fix(Config.getString("messages.reload")));
            }
            else {
                p.sendMessage(ChatUtil.fix(Config.getString("messages.unknown-cmd")));
            }
            return false;
        }
        return false;
    }

    private static InventoryView mainGui(Player p){
        final Inventory inv = Bukkit.createInventory(p, 27, ChatUtil.fix(Config.getString("messages.gui-name")));
        final ItemBuilder hooks = new ItemBuilder(Material.DAYLIGHT_DETECTOR).setTitle(ChatUtil.fix(Config.getString("gui.hooks.name"))).addLore(ChatUtil.fix(ZenGuard.getAuthmeHook() ? "&7AuthMe: &a✔" : "&7AuthMe: &c✖"));
        final ItemBuilder reload = new ItemBuilder(Material.BOOK).setTitle(ChatUtil.fix(Config.getString("gui.reload.name"))).addLore(ChatUtil.fix(Config.getString("gui.reload.lore")));
        final ItemBuilder status = new ItemBuilder(Material.GOLD_BLOCK).setTitle(ChatUtil.fix(Config.getString("gui.trusted.name"))).addLore(ChatUtil.fix("&7Can have OP:")).addLores(Config.getConfig().getStringList("op-protection.list"));
        final ItemBuilder stats = new ItemBuilder(Material.NETHER_BRICK).setTitle(ChatUtil.fix(Config.getString("gui.actions.name"))).addLore(ChatUtil.fix("&7Command-Protection: &c") + Config.getString("stats.command-protection")).addLore(ChatUtil.fix("&7OP-Protection: &c") + Config.getString("stats.op-protection"));
        inv.setItem(16, stats.build());
        inv.setItem(14, status.build());
        inv.setItem(12, reload.build());
        inv.setItem(10, hooks.build());
        return p.openInventory(inv);
    }
}
