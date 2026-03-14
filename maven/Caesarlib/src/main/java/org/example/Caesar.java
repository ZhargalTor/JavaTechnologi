package org.example;

public class Caesar {

    private final char[] LWL = {
            'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о',
            'п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'
    };

    private final char[] UPL = {
            'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О',
            'П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'
    };


    public String encrypt(String text, int key) {
        return process(text, key);
    }

    public String decrypt(String text, int key) {
        return process(text, -key);
    }

    private String process(String text, int key) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (Character.isWhitespace(chars[i])) {
                continue;
            }

            boolean found = false;

            for (int j = 0; j < 33; j++) {

                if (chars[i] == LWL[j]) {
                    int index = (j + key) % 33;

                    if (index < 0) {
                        index += 33;
                    }

                    chars[i] = LWL[index];
                    found = true;
                    break;
                }

                if (chars[i] == UPL[j]) {
                    int index = (j + key) % 33;

                    if (index < 0) {
                        index += 33;
                    }

                    chars[i] = UPL[index];
                    found = true;
                    break;
                }
            }
        }

        return new String(chars);
    }
}