package nishabot_b.main;

import java.util.Properties;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nishabot_b.entidades.comandos.Nisha;
import nishabot_b.utilidades.CargadorConfig;

public class NishabotMain extends ListenerAdapter {

    private static JDA objBot;

    public static void main(String[] args) throws LoginException, InterruptedException {
        Properties config = CargadorConfig.cargar("res/ficheros/config/config.xml");
        String token = config.getProperty("token");

        objBot = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
        objBot.getPresence().setPresence(Game.listening("!nisha"), false);
        objBot.addEventListener(new NishabotMain());
    }

    public void onMessageReceived(MessageReceivedEvent ev) {
        if(!ev.getMessage().getContentRaw().startsWith("!")) return;
        if(ev.getAuthor().isBot()) return;

        String[] arrArgs = ev.getMessage().getContentRaw().substring(1).toLowerCase().split(" ");
        evaluarComando(arrArgs, ev);
    }

    private void evaluarComando(String[] arrArgs, MessageReceivedEvent ev) {
        String comando = arrArgs[0];

        if(comando.equals("nisha")) {
            new Nisha().enviarFoto(ev.getChannel());
        }
    }

}
