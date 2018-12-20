
package org.jubaroo.mods.gmfirstlogin;

import com.wurmonline.server.players.Player;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerLoginListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Initiator implements WurmServerMod, PlayerLoginListener, Configurable {
    private static Logger logger;

    static {
        logger = Logger.getLogger(Initiator.class.getName());
    }

    @Override
    public void configure(Properties properties) {
        try {
            Config.doConfig(properties);
        } catch (IllegalArgumentException |
                ClassCastException e) {
            logger.log(Level.SEVERE, "Error in configure()", e);
        }
    }

    static void jDebug(String msg) {
        try {
            if (Constants.debug) {
                logger.log(Level.INFO, msg);
            }
        } catch (IllegalArgumentException |
                ClassCastException e) {
            logger.log(Level.SEVERE, "Error in jDebug()", e);
        }
    }

    @Override
    public void onPlayerLogin(Player player) {
        try {
            GmFirstLogin.activateGmOnLogin(player);
        } catch (IllegalArgumentException |
                ClassCastException e) {
            logger.log(Level.SEVERE, "Error in onPlayerLogin()", e);
        }
    }

    public String getVersion() {
        return "v1.0";
    }

}