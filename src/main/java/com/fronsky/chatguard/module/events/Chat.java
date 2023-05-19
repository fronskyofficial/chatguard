package com.fronsky.chatguard.module.events;

import com.fronsky.chatguard.logic.utils.Language;
import com.fronsky.chatguard.module.ChatGuardModule;
import com.fronsky.chatguard.module.data.Data;
import com.fronsky.chatguard.module.objects.SpamChecker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Chat implements Listener {
    private final Data data;
    private final boolean censorInsteadOfBlock;
    private final Collection<String> bannedWords;

    public Chat() {
        data = ChatGuardModule.getData();
        censorInsteadOfBlock = data.getConfig().get().getBoolean("censorInsteadOfBlock");
        bannedWords = new HashSet<>();
        Collection<String> bannedWordsConfig = data.getConfig().get().getStringList("bannedWords");

        bannedWords.addAll(bannedWordsConfig);
        Collection<String> tempBannedWords = Arrays.asList("1488", "8=D", "A55hole", "abortion", "ahole", "AIDS", "AIDs", "ainujin", "ainuzin", "akimekura", "Anal", "anus", "anuses", "Anushead", "anuslick", "anuss", "aokan", "Arsch", "Arschloch", "arse", "arsed", "arsehole", "arseholed", "arseholes", "arseholing", "arselicker", "arses", "Ass", "asshat", "asshole", "assholed", "assholes", "assholing", "asslick", "asslicker", "asses", "Auschwitz", "b00bs", "b00bz", "b1tc", "Baise", "bakachon", "bakatyon", "Ballsack", "Ballzack", "BAMF", "Bastard", "Beaner", "Beeatch", "beeeyotch", "beefwhistle", "beeotch", "Beetch", "beeyotch", "Bellend", "bestiality", "beyitch", "beyotch", "Biach", "bin laden", "binladen", "biotch", "bitch", "bitches", "Bitching", "blad", "bladt", "blowjob", "blow job", "blowme", "blow me", "blyad", "blyadt", "bon3r", "boner", "boobs", "boobz", "Btch", "Bukakke", "Bullshit", "bung", "butagorosi", "butthead", "Butthole", "Buttplug", "c0ck", "Cabron", "Cacca", "Cadela", "Cagada", "Cameljockey", "Caralho", "castrate", "Cazzo", "ceemen", "ch1nk", "chankoro", "chieokure", "chikusatsu", "Ching chong", "Chinga", "Chingada Madre", "Chingado", "Chingate", "chink", "chinpo", "Chlamydia", "choad", "chode", "chonga", "chonko", "chonkoro", "chourimbo", "chourinbo", "chourippo", "chuurembo", "chuurenbo", "circlejerk", "cl1t", "cli7", "clit", "clitoris", "cocain", "Cocaine", "cock", "Cocksucker", "Coglione", "Coglioni", "coitus", "coituss", "cojelon", "cojones", "condom", "coon", "coon hunt", "coon kill", "coonhunt", "coonkill", "Cooter", "cotton pic", "cotton pik", "cottonpic", "cottonpik", "Crackhead", "crap", "CSAM", "Culear", "Culero", "Culo", "Cum", "cumming", "cun7", "cunt", "cvn7", "cvnt", "cyka", "d1kc", "d4go", "dago", "Darkie", "Deez Nuts", "Deez Nutz", "deeznut", "deeznuts", "deeznutz", "Dickhead", "dick", "dicks", "dikc", "dildo", "Dio Bestia", "dong", "dongs", "douche", "Downie", "Dumass", "Dumbass", "Durka durka", "Dyke", "Ejaculate", "Encule", "enjokousai", "enzyokousai", "etahinin", "etambo", "etanbo", "f0ck", "f0kc", "f3lch", "facking", "fag", "faggot", "fags", "faggots", "Fanculo", "Fanny", "fatass", "fck", "Fckn", "fcuk", "fcuuk", "felch", "fellatio", "Fetish", "Fgt", "FiCKDiCH", "Figlio di Puttana", "fku", "fock", "fokc", "foreskin", "Fotze", "Foutre", "fucc", "fuck", "fucks", "fuckd", "fucked", "fucker", "fuckers", "fucking", "fuckr", "fuct", "fujinoyamai", "fukashokumin", "Fupa", "fuuck", "fuuckd", "fuucked", "fuucker", "fuucking", "fuuckr", "fuuuck", "fuuuckd", "fuuucked", "fuuucker", "fuuucking", "fuuuckr", "fuuuuck", "fuuuuckd", "fuuuucked", "fuuuucker", "fuuuucking", "fuuuuckr", "fuuuuuck", "fuuuuuckd", "fuuuuucked", "fuuuuucker", "fuuuuucking", "fuuuuuckr", "fuuuuuuck", "fuuuuuuckd", "fuuuuuucked", "fuuuuuucker", "fuuuuuucking", "fuuuuuuckr", "fuuuuuuuck", "fuuuuuuuckd", "fuuuuuuucked", "fuuuuuuucker", "fuuuuuuucking", "fuuuuuuuckr", "fuuuuuuuuck", "fuuuuuuuuckd", "fuuuuuuuucked", "fuuuuuuuucker", "fuuuuuuuucking", "fuuuuuuuuckr", "fuuuuuuuuuck", "fuuuuuuuuuckd", "fuuuuuuuuucked", "fuuuuuuuuucker", "fuuuuuuuuucking", "fuuuuuuuuuckr", "fuuuuuuuuuu", "fvck", "fxck", "fxuxcxk", "g000k", "g00k", "g0ok", "gestapo", "go0k", "god damn", "goddamn", "goldenshowers", "golliwogg", "gollywog", "Gooch", "gook", "goook", "Gyp", "h0m0", "h0mo", "h1tl3", "h1tle", "hairpie", "hakujakusha", "hakuroubyo", "hakuzyakusya", "hantoujin", "hantouzin", "Herpes", "hitl3r", "hitler", "hitlr", "holocaust", "hom0", "homo", "honky", "Hooker", "hor3", "hore", "hukasyokumin", "Hure", "Hurensohn", "huzinoyamai", "hymen", "inc3st", "incest", "Inculato", "Injun", "intercourse", "inugoroshi", "inugorosi", "j1g4b0", "j1g4bo", "j1gab0", "j1gabo", "Jack Off", "jackass", "jap", "JerkOff", "jig4b0", "jig4bo", "jigabo", "Jigaboo", "jiggaboo", "jizz", "Joder", "Joto", "Jungle Bunny", "junglebunny", "k k k", "k1k3", "kichigai", "kik3", "Kike", "kikeiji", "kikeizi", "Kilurself", "kitigai", "kkk", "klu klux", "Klu Klux Klan", "kluklux", "knobhead", "koon hunt", "koon kill", "koonhunt", "koonkill", "koroshiteyaru", "koumoujin", "koumouzin", "ku klux klan", "kun7", "kurombo", "Kurva", "Kurwa", "kxkxk", "l3sb0", "lesbo", "lezbo", "lezzie", "m07th3rfukr", "m0th3rfvk3r", "m0th3rfvker", "Madonna Puttana", "manberries", "manko", "manshaft", "Maricon", "Masterbat", "masterbate", "Masturbacion", "masturbait", "Masturbare", "Masturbate", "Masturbazione", "Merda", "Merde", "Meth", "Mierda", "milf", "Minge", "Miststück", "mitsukuchi", "mitukuti", "Molest", "molester", "molestor", "Mong", "Moon Cricket", "moth3rfucer", "moth3rfvk3r", "moth3rfvker", "motherfucker", "Mulatto", "n1663r", "n1664", "n166a", "n166er", "n1g3r", "n1German", "n1gg3r", "n1gGerman", "n3gro", "n4g3r", "n4gg3r", "n4gGerman", "n4z1", "nag3r", "nagg3r", "nagGerman", "natzi", "naz1", "nazi", "nazl", "neGerman", "ngGerman", "nggr", "NhigGerman", "ni666", "ni66a", "ni66er", "ni66g", "ni6g", "ni6g6", "ni6gg", "Nig", "nig66", "nig6g", "nigar", "niGerman", "nigg3", "nigg6", "nigga", "niggaz", "nigGerman", "nigger", "nigglet", "niggr", "nigguh", "niggur", "niggy", "niglet", "Nignog", "nimpinin", "ninpinin", "Nipples", "niqqa", "niqqer", "Nonce", "nugga", "Nutsack", "Nutted", "nygGerman", "omeko", "Orgy", "p3n15", "p3n1s", "p3ni5", "p3nis", "p3nl5", "p3nls", "Paki", "Panties", "Pedo", "pedoph", "pedophile", "pen15", "pen1s", "Pendejo", "peni5", "penile", "penis", "Penis", "penl5", "penls", "penus", "Perra", "phag", "phaggot", "phagot", "phuck", "Pikey", "Pinche", "Pizda", "Polla", "Porca Madonna", "Porch monkey", "Porn", "Pornhub", "Porra", "pr1ck", "preteen", "prick", "pu555y", "pu55y", "pub1c", "Pube", "pubic", "pun4ni", "pun4nl", "Punal", "punan1", "punani", "punanl", "puss1", "puss3", "puss5", "pusse", "pussi", "pussy", "pussys", "Pussies", "pusss1", "pussse", "pusssi", "pusssl", "pusssy", "Pussy", "Puta", "Putain", "Pute", "Puto", "Puttana", "Puttane", "Puttaniere", "puzzy", "pvssy", "queef", "r3c7um", "r4p15t", "r4p1st", "r4p3", "r4pi5t", "r4pist", "raape", "raghead", "raibyo", "Raip", "rap15t", "rap1st", "Rapage", "rape", "Raped", "rapi5t", "Raping", "rapist", "rectum", "Red Tube", "Reggin", "reipu", "retard", "Ricchione", "rimjob", "rimming", "rizzape", "rompari", "Salaud", "Salope", "sangokujin", "sangokuzin", "santorum", "Scheiße", "Schlampe", "Schlampe", "schlong", "Schwuchtel", "Scrote", "secks", "seishinhakujaku", "seishinijo", "seisinhakuzyaku", "seisinizyo", "Semen", "semushiotoko", "semusiotoko", "sh|t", "sh|thead", "sh|tstain", "sh17", "sh17head", "sh17stain", "sh1t", "sh1thead", "sh1tstain", "Shat", "Shemale", "shi7", "shi7head", "shi7stain", "shinajin", "shinheimin", "shirakko", "shit", "shithead", "shitstain", "shitting", "Shitty", "shokubutsuningen", "sinazin", "sinheimin", "Skank", "slut", "SMD", "Sodom", "sofa king", "sofaking", "Spanishick", "Spanishook", "Spanishunk", "STD", "STDs", "Succhia Cazzi", "suck my", "suckmy", "syokubutuningen", "Taint", "Tapatte", "Tapette", "Tarlouse", "tea bag", "teabag", "teebag", "teensex", "teino", "Testa di Cazzo", "Testicles", "Thot", "tieokure", "tinpo", "Tits", "Titz", "titties", "tittiez", "tokushugakkyu", "tokusyugakkyu", "torukoburo", "torukojo", "torukozyo", "tosatsu", "tosatu", "towelhead", "Trannie", "Tranny", "tunbo", "tw47", "tw4t", "twat", "tyankoro", "tyonga", "tyonko", "tyonkoro", "tyourinbo", "tyourippo", "tyurenbo", "ushigoroshi", "usigorosi", "v461n4", "v461na", "v46in4", "v46ina", "v4g1n4", "v4g1na", "v4gin4", "v4gina", "va61n4", "va61na", "va6in4", "va6ina", "Vaccagare", "Vaffanculo", "Vag", "vag1n4", "vag1na", "vagin4", "vagina", "VateFaire", "vvhitepower", "w3tb4ck", "w3tback", "Wank", "wanker", "wetb4ck", "wetback", "wh0r3", "wh0re", "white power", "whitepower", "whor3", "whore", "whores", "Wog", "Wop", "x8lp3t", "xbl pet", "XBLPET", "XBLRewards", "Xl3LPET", "yabunirami", "Zipperhead");
        bannedWords.addAll(tempBannedWords);
    }

    @EventHandler
    public void asyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();

        boolean dontSend = false;
        StringBuilder newMessage = new StringBuilder();

        for (String word : message.split(" ")) {
            if (bannedWords.contains(word) && !player.hasPermission("chatguard.bypass")) {
                if (censorInsteadOfBlock) {
                    newMessage.append(newMessage.length() == 0 ? "***" : " ***");
                    continue;
                }
                dontSend = true;
                continue;
            }
            newMessage.append(newMessage.length() == 0 ? word : " " + word);
        }

        if (dontSend || SpamChecker.isSpamming(player, newMessage.toString())) {
            event.setCancelled(true);
            if (data.getConfig().get().getBoolean("enableSpamWarningMessage")) {
                player.sendMessage(Language.WORD_WARNING.getMessageWithColor());
            }
            return;
        }

        event.setMessage(newMessage.toString());
    }
}
