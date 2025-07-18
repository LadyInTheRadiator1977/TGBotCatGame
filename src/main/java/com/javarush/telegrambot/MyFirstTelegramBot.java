package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "SK_Kozyavkin_bot"; //
    public static final String TOKEN = "8170868912:AAHSk17LPiC08746snTD0qXIgVpWAuALdSo";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().equals("/start")) {
            sendPhotoMessageAsync("step_1_pic");
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            sendPhotoMessageAsync("step_2_pic");
            addUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Взять сосиску! +20 славы", "step_2_btn",
                            "Взять рыбку! +20 славы", "step_2_btn",
                            "Скинуть банку с огурцами! +20 славы", "step_2_btn"));

        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            sendPhotoMessageAsync("step_3_pic");
            addUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Взлом робота-пылесоса", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            sendPhotoMessageAsync("step_4_pic");
            addUserGlory(20);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Отправить робот пылесос за едой! +30 славы", "step_4_btn",
                            "Покататься на роботе пылесоса! +30 славы", "step_4_btn",
                            "Убежать от робота пылесоса! +30 славы", "step_4_btn"));

        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            sendPhotoMessageAsync("step_5_pic");
            addUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Надеть и включить GoPro!", "step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            sendPhotoMessageAsync("step_6_pic");
            addUserGlory(30);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Бегать по крышам, снимать на GoPro! +40 славы", "step_6_btn",
                            "С GoPro нападать на других котов из засады! +40 славы", "step_6_btn",
                            "С GoPro нападать на собак из засады! +30 славы", "step_6_btn"));

        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            sendPhotoMessageAsync("step_7_pic");
            addUserGlory(40);
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Взлом пароля!!", "step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            sendPhotoMessageAsync("step_8_pic");
            addUserGlory(50);
            sendTextMessageAsync(STEP_8_TEXT, Map.of("Бежать хвастаться местным котам", "step_8_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_8_btn")){
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }
        if (getMessageText().equals("/glory")){
            sendTextMessageAsync(String.valueOf(getUserGlory()));
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}