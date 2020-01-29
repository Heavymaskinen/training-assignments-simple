package eu.sig.training.ch05.buildandsendmail;

class Recipient {
    public String firstName, lastName, division;
}

class FormattedMessage {
    public String message;
    public MailFont font;
    public String subject;

    public MailMessage formatMessage() {
        return null;
    }


}

class MailMessage {

}

class MailFont {

}

public class BuildAndSendMail {
    public void buildAndSendMail(MailMan m, Recipient recipient, FormattedMessage message) {
        String mId = new MailIdCreator(recipient).create();
        MailMessage mMessage = message.formatMessage();
        m.send(mId, message.subject, mMessage);
    }

    @SuppressWarnings("unused")

    private class MailMan {

        @SuppressWarnings("unused")
        public void send(String mId, String subject, MailMessage mMessage) {
        }

    }


    private class MailIdCreator {
        private Recipient recipient;

        public MailIdCreator(Recipient recipient) {
            this.recipient = recipient;
        }

        public String create() {
            return recipient.firstName.charAt(0) + "." + recipient.lastName.substring(0, 7) + "@"
                    + recipient.division.substring(0, 5) + ".compa.ny";
        }
    }
}
