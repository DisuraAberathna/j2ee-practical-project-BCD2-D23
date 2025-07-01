package com.disuraaberathna.practical.core.provider;

import com.disuraaberathna.practical.core.mail.Mailable;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MailServiceProvider {
    private final Properties properties = new Properties();
    private Authenticator authenticator;
    private static MailServiceProvider instance;
    private static final String USERNAME = "c822a1050ba776";
    private static final String PASSWORD = "6886f5dbf2250f";
    private ThreadPoolExecutor executor;
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    private MailServiceProvider() {
        properties.setProperty("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        properties.setProperty("mail.smtp.port", "2525");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "false");
    }

    public static MailServiceProvider getInstance() {
        if (instance == null) {
            instance = new MailServiceProvider();
        }
        return instance;
    }

    public void start() {
        authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        };

        executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, queue, new ThreadPoolExecutor.AbortPolicy());
        executor.prestartAllCoreThreads();

        System.out.println("Mail service provider : running...");
    }

    public void sendMail(Mailable mailable) {
        queue.offer(mailable);
    }

    public void shutdown() {
        if (executor != null) {
            executor.shutdown();
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }
}
