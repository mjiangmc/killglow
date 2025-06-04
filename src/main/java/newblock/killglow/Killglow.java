package newblock.killglow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class Killglow extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // 注册事件监听器
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(ChatColor.GREEN + "Killglow 插件已启用！");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "Killglow 插件已禁用！");
    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {
        if (event.getEntity().getKiller() instanceof Player) {
            Player killer = event.getEntity().getKiller();

            // 给击杀者添加发光效果（隐藏粒子，持续40 ticks = 2秒）
            PotionEffect glowEffect = new PotionEffect(
                    PotionEffectType.GLOWING,
                    40, // 2秒
                    1,
                    false, // ambient
                    false // 不显示粒子
            );

            killer.addPotionEffect(glowEffect);
        }
    }
}
