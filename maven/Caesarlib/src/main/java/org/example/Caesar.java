package org.example;

public class Caesar {
    public Caesar() {
    }

    public Caesar(String text, int key) {
        System.out.println(encrypt(text, key));
    }

    private final char[] LWL = {
            'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о',
            'п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'
    };

    private final char[] UPL = {
            'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О',
            'П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'
    };

    public String encrypt(String text, int key){
        return process(text, key);
    }

    public String decrypt(String text, int key){
        return process(text, -key);
    }

    private String process(String text, int key){

        char[] textChar = text.toCharArray();

        for (int i=0;i<textChar.length;i++){

            if(Character.isWhitespace(textChar[i]))
                continue;

            if(Character.isLowerCase(textChar[i])){

                int index = 0;

                while(textChar[i] != LWL[index]) index++;

                index = (index + key) % 33;

                if(index < 0) index += 33;

                textChar[i] = LWL[index];
            }

            else if(Character.isUpperCase(textChar[i])){

                int index = 0;

                while(textChar[i] != UPL[index]) index++;

                index = (index + key) % 33;

                if(index < 0) index += 33;

                textChar[i] = UPL[index];
            }
        }

        return new String(textChar);
    }
}
