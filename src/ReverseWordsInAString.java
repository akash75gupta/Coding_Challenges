public class ReverseWordsInAString {
        public static void main(String[] args) {
            // Replace this placeholder return statement with your code
            String sentence = args[0];
            char[] sentenceArray = sentence.toCharArray();
            reverseSentence(sentenceArray);
            reverseWords(sentenceArray);
            //return (new String(sentenceArray)).trim();
            System.out.println((new String(sentenceArray)).trim());
        }

        public static void reverseSentence(char[] sentenceArray){
            int i=0;
            int j=sentenceArray.length-1;

            while(i<j){
                char temp=sentenceArray[j];
                sentenceArray[j] = sentenceArray[i];
                sentenceArray[i] = temp;
                i++;
                j--;
            }
        }

        public static void reverseWords(char[] sentenceArray){
            int i=0;
            int j=0;
            int checkpoint=0;
            while(j < sentenceArray.length){
                j = checkpoint;
                i = checkpoint;
                while(j < sentenceArray.length){
                    if(sentenceArray[j] == ' '){
                        break;
                    }
                    j++;
                }
                checkpoint = j+1;
                while(i < j){
                    char temp=sentenceArray[j-1];
                    sentenceArray[j-1] = sentenceArray[i];
                    sentenceArray[i] = temp;
                    j--;
                    i++;
                }

            }
        }

    }
