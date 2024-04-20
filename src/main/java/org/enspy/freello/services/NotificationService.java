package org.enspy.freello.services;
import org.enspy.freello.models.Project;
import org.enspy.freello.models.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    // Cette méthode est un exemple simple d'envoi de notification.
    // Dans un cas réel, vous pourriez envoyer un email, un SMS, ou une notification push.
    public void notify(User user, String message) {
        // Logique d'envoi de la notification
        // Par exemple, envoi d'un email ou d'une notification push
        System.out.println("Notification envoyée à " + user.getEmail() + ": " + message);
        // Ici, vous pouvez intégrer un service de messagerie réel comme SendGrid, Twilio, etc.
    }

    // Vous pouvez ajouter d'autres méthodes pour gérer différents types de notifications
    // Par exemple, notifications pour les événements, les erreurs, etc.

    // Méthode pour envoyer une notification de bienvenue à un nouvel utilisateur
    public void sendWelcomeNotification(User user) {
        String welcomeMessage = "Bienvenue " + user.getName() + "! Nous sommes heureux de vous voir parmi nous.";
        notify(user, welcomeMessage);
    }

    // Méthode pour envoyer une notification de confirmation de création de projet
    public void sendProjectCreationConfirmation(User user, Project project) {
        String confirmationMessage = "Le projet '" + project.getName() + "' a été créé avec succès.";
        notify(user, confirmationMessage);
    }

    // Ajoutez ici d'autres méthodes selon les besoins de votre application
}
