public class LoginProcessor {
    public Encryptor encryptor;

    public LoginProcessor() {
        this.encryptor = new Encryptor();
    }

    private String prepareForEncyrption(LoginAttempt attempt) {
        return attempt.username.length() + attempt.username + attempt.password;
    }

    public String encyrptAndSendTransmission(LoginAttempt attempt) {
        String prepared = this.prepareForEncyrption(attempt);

        return this.encryptor.encrypt(prepared);
    }

    public LoginAttempt recieveAndDecryptTransmission(String transmission) {
        String decrypted = this.encryptor.decrypt(transmission);

        int length = Integer.parseInt(String.valueOf(decrypted.charAt(0)));
        String username = transmission.substring(1, length + 1);
        String password = transmission.substring(length + 1);

        return new LoginAttempt(username, password);
    }
}
