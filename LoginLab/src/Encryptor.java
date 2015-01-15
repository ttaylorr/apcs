public class Encryptor {
    public String encrypt(String str) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            (i % 2 == 0 ? first : second).append(str.charAt(i));
        }

        return first.append(second).toString();
    }

    public String decrypt(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < result.length() / 2; i++) {
            result.append(result.charAt(i))
                  .append(result.charAt(i + result.length() / 2));
        }

        return result.toString();
    }
}
